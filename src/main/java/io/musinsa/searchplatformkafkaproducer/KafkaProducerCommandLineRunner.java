package io.musinsa.searchplatformkafkaproducer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.navercorp.fixturemonkey.FixtureMonkey;
import com.navercorp.fixturemonkey.api.introspector.FieldReflectionArbitraryIntrospector;
import io.musinsa.searchplatformkafkaproducer.application.DataProducer;
import io.musinsa.searchplatformkafkaproducer.vo.GoodsVO;
import io.musinsa.searchplatformkafkaproducer.vo.SearchPlatformTopicTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerCommandLineRunner implements ApplicationRunner {

    private static final String TOPIC = "test-cluster-v1";
    private static final FixtureMonkey fixtureMonkey = FixtureMonkey.builder()
            .objectIntrospector(FieldReflectionArbitraryIntrospector.INSTANCE)
            .defaultNotNull(true)
            .build();
    static AtomicInteger counter = new AtomicInteger(0);
    private final DataProducer dataProducer;
    private final ObjectMapper objectMapper;

    @Override
    public void run(ApplicationArguments args) throws Exception {

//        threadSender();
        sender();


    }

    private void sender() throws InterruptedException {

        List<GoodsVO> goodsVOS = fixtureMonkey.giveMe(GoodsVO.class, 10);
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>  goodsVOS.size() : {}", goodsVOS.size());
        send(goodsVOS);


    }

    private void threadSender() throws InterruptedException {
        log.info("<<<<<<<<<<<<<<<<<<  Create goods >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        ExecutorService es = Executors.newFixedThreadPool(2);

        CyclicBarrier barrier = new CyclicBarrier(3);

        StopWatch main = new StopWatch();
        main.start();

        for (int i = 0; i < 10; i++) {
            es.submit(() -> {
                log.info("<<<<<<<<<<<<<<<<<<  Start Sender >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                int idx = counter.addAndGet(1);
                barrier.await();
                log.info("Thread {}", idx);

                StopWatch sw = new StopWatch();
                sw.start();
                List<GoodsVO> goodsVOS = fixtureMonkey.giveMe(GoodsVO.class, 1);
                log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>  goodsVOS.size() : {}", goodsVOS.size());
                send(goodsVOS);
                sw.stop();
                log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>  Elapsed ", idx, sw.getTotalTimeSeconds());
                return null;
            });
        }
        log.info("<<<<<<<<<<<<<<<<<<  End Sender >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");


        es.shutdown();
        log.info("<<<<<<<<<<<<<<<<<<  wait: {}", main.getTotalTimeSeconds());
        es.awaitTermination(1000, TimeUnit.SECONDS);

        main.stop();
        log.info("<<<<<<<<<<<<<<<<<<  Total: {}", main.getTotalTimeSeconds());
    }

    private void send(List<GoodsVO> goodsList) {

        for (int i = 0; i < goodsList.size(); i++) {
            try {
                var template = buildSearchTemplate(goodsList.get(i), i);
                String data = objectMapper.writeValueAsString(template);
                dataProducer.sendMessage(TOPIC, template.getId(), data);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private SearchPlatformTopicTemplate<GoodsVO> buildSearchTemplate(GoodsVO goodsVO, int key) {
        return SearchPlatformTopicTemplate.<GoodsVO>builder()
                .id(String.valueOf(key))
                .sentDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS")))
                .updateDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS")))
                .topic(TOPIC)
                .eventType("create")
                .version("v1")
                .clusterName("test-cluster")
                .aliasName("origin-platform-consumer")
                .payload(goodsVO)
                .useWriteAliasYN("N")
                .build();
    }

}

package io.musinsa.searchplatformkafkaproducer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.navercorp.fixturemonkey.FixtureMonkey;
import com.navercorp.fixturemonkey.api.introspector.FieldReflectionArbitraryIntrospector;
import io.musinsa.searchplatformkafkaproducer.application.DataProducer;
import io.musinsa.searchplatformkafkaproducer.vo.GoodsVO;
import io.musinsa.searchplatformkafkaproducer.vo.SearchPlatformTopicTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.util.StopWatch;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
@Slf4j
public class SearchPlatformKafkaProducerApplication {


    private static final String TOPIC = "voc-v1";
    private static final FixtureMonkey fixtureMonkey = FixtureMonkey.builder()
            .objectIntrospector(FieldReflectionArbitraryIntrospector.INSTANCE)
            .defaultNotNull(true)
            .build();
    static AtomicInteger counter = new AtomicInteger(0);

    @Autowired
    private DataProducer dataProducer;
    @Autowired
    private ObjectMapper objectMapper;

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SearchPlatformKafkaProducerApplication.class);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onMyEvent() throws InterruptedException {

        ExecutorService es = Executors.newFixedThreadPool(10);
        int count = 0;
        while (count++ < 10) {
            log.info("<<<<<<<<<<<<<<<<<<  RUN goods >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            for (int i = 0; i < 100; i++) {
                es.submit(() -> {
                    StopWatch sw = new StopWatch();
                    sw.start();
                    send(fixtureMonkey.giveMe(GoodsVO.class, 20));
                    sw.stop();
                    log.info(">>> time {}", sw.getTotalTimeSeconds());
                    return null;
                });
            }
        }

        log.info("<<<<<<<<<<<<<<<<<<  End Sender >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        StopWatch main = new StopWatch();
        main.start();
        es.shutdown();
        log.info("<<<<<<<<<<<<<<<<<<  wait: {}", main.getTotalTimeSeconds());
        es.awaitTermination(1000, TimeUnit.SECONDS);
        main.stop();
        log.info("<<<<<<<<<<<<<<<<<<  Total: {}", main.getTotalTimeSeconds());
        Thread.sleep(1000);
    }

    private void send(List<GoodsVO> goodsList) {

        for (int i = 0; i < goodsList.size(); i++) {
            try {
                GoodsVO goodsVO = goodsList.get(i);
                goodsVO.setId(UUID.randomUUID().toString());
                var template = buildSearchTemplate(goodsVO);
                String data = objectMapper.writeValueAsString(template);
                dataProducer.sendMessage(TOPIC, template.getId(), data);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private SearchPlatformTopicTemplate<GoodsVO> buildSearchTemplate(GoodsVO goodsVO) {
        return SearchPlatformTopicTemplate.<GoodsVO>builder()
                .id(goodsVO.getId())
                .sentDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS")))
                .updateDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS")))
                .topic(TOPIC)
                .eventType("create")
                .version("v1")
                .clusterName("voc")
                .aliasName("platform-concurrency")
                .payload(goodsVO)
                .useWriteAliasYN("N")
                .build();
    }

}

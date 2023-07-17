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

    private static final String TOPIC = "voc-v1";
    private static final FixtureMonkey fixtureMonkey = FixtureMonkey.builder()
            .objectIntrospector(FieldReflectionArbitraryIntrospector.INSTANCE)
            .defaultNotNull(true)
            .build();
    static AtomicInteger counter = new AtomicInteger(0);
    private final DataProducer dataProducer;
    private final ObjectMapper objectMapper;

    @Override
    public void run(ApplicationArguments args) throws Exception {

//        log.info("<<<<<<<<<<<<<<<<<<  Sleep 5초 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//        threadSender();
//        sender();


    }
}

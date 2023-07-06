package io.musinsa.searchplatformkafkaproducer;

import java.util.UUID;

import io.musinsa.searchplatformkafkaproducer.application.DataProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaProducerCommandLineRunner implements ApplicationRunner {

    private static final String TOPIC = "test-cluster-v1";
    private final DataProducer dataProducer;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        String key = UUID.randomUUID().toString();
        dataProducer.sendMessage(TOPIC, key, "value");

        System.out.println("Hello World from KafkaProducerCommandLineRunner");
    }
}

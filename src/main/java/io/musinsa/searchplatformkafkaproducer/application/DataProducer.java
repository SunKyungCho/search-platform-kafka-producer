package io.musinsa.searchplatformkafkaproducer.application;

import java.time.Duration;

import io.musinsa.searchplatformkafkaproducer.config.PlatformKafkaConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderRecord;
import reactor.util.retry.Retry;

@Component
@Slf4j
public class DataProducer {

    private final KafkaSender<String, String> producer;

    public DataProducer(PlatformKafkaConfig platformKafkaConfig) {
        this.producer = platformKafkaConfig.producer();
    }

    public void sendMessage(String topic, String key, String data) {
        final ProducerRecord<String, String> stringStringProducerRecord = new ProducerRecord<>(topic, key, data);
        final SenderRecord<String, String, String> stringStringIntegerSenderRecord = SenderRecord.create(stringStringProducerRecord, key);

        producer.send(Flux.just(stringStringIntegerSenderRecord))
                .retryWhen(Retry.backoff(2, Duration.ofSeconds(3)).transientErrors(true))
                .subscribe();
    }
}

package io.musinsa.searchplatformkafkaproducer;

import com.navercorp.fixturemonkey.FixtureMonkey;
import com.navercorp.fixturemonkey.api.introspector.FieldReflectionArbitraryIntrospector;
import io.musinsa.searchplatformkafkaproducer.application.DataProducer;
import io.musinsa.searchplatformkafkaproducer.vo.GoodsVO;
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

        FixtureMonkey fixtureMonkey = FixtureMonkey.builder()
                .objectIntrospector(FieldReflectionArbitraryIntrospector.INSTANCE)
                .defaultNotNull(true)
                .build();


        System.out.println();


//        String key = UUID.randomUUID().toString();
//        dataProducer.sendMessage(TOPIC, key, "value");
    }
}

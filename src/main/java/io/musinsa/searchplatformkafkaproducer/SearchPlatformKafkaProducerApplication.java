package io.musinsa.searchplatformkafkaproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.actuate.autoconfigure.wavefront.WavefrontProperties;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SearchPlatformKafkaProducerApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SearchPlatformKafkaProducerApplication.class);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);
    }

}

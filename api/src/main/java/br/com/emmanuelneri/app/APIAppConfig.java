package br.com.emmanuelneri.app;

import org.ff4j.FF4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class APIAppConfig {

    @Value("${ff4j.features.hello.active}")
    private boolean hello;

    @Value("${ff4j.features.clients.active}")
    private boolean clients;

    public static void main(String[] args) {
        SpringApplication.run(APIAppConfig.class, args);
    }

    @Bean
    public FF4j FF4j() {
        final FF4j ff4j = new FF4j()
                .audit(true);

        ff4j.createFeature("hello", hello);
        ff4j.createFeature("clients", clients);


        return ff4j;
    }

}

package br.com.emmanuelneri.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CloudConfigAppConfig {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigAppConfig.class, args);
    }

}
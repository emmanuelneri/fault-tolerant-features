package br.com.emmanuelneri.app;

import br.com.emmanuelneri.feature.toggle.impl.FeatureToggleImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({FeatureToggleImpl.class})
public class WebAppConfig {

    public static void main(String[] args) {
        SpringApplication.run(WebAppConfig.class, args);
    }

}

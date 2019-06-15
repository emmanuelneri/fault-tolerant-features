package br.com.emmanuelneri.app;

import br.com.emmanuelneri.feature.toggle.Features;
import br.com.emmanuelneri.feature.toggle.impl.FeatureToggleImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.togglz.core.manager.EnumBasedFeatureProvider;
import org.togglz.core.spi.FeatureProvider;

@SpringBootApplication
@Import({FeatureToggleImpl.class})
public class APIAppConfig {

    public static void main(String[] args) {
        SpringApplication.run(APIAppConfig.class, args);
    }

    @Bean
    public FeatureProvider featureProvider() {
        return new EnumBasedFeatureProvider(Features.class);
    }

}

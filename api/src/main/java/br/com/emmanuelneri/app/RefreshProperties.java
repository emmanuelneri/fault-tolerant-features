package br.com.emmanuelneri.app;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
@RefreshScope
@Getter
public class RefreshProperties {

    @Value("${hello.api.active}")
    private boolean helloApiActive;
}

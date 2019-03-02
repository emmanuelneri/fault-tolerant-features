package br.com.emmanuelneri.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web")
public class WebController {

    private final RefreshProperties refreshProperties;

    public WebController(RefreshProperties refreshProperties) {
        this.refreshProperties = refreshProperties;
    }

    @GetMapping(value = "/hello")
    public String getHello() {
        return refreshProperties.isHelloApiActive() ? "Hello" : "Inactive API";
    }
}

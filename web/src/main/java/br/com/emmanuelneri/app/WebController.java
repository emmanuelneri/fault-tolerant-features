package br.com.emmanuelneri.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static br.com.emmanuelneri.app.Client.Classification.FREQUENT_BUYER;
import static br.com.emmanuelneri.app.Client.Classification.NEVER_BUYER;
import static br.com.emmanuelneri.app.Client.Classification.NEW;

@RestController
@RequestMapping("/web")
public class WebController {

    private final RefreshProperties refreshProperties;

    public WebController(RefreshProperties refreshProperties) {
        this.refreshProperties = refreshProperties;
    }

    @GetMapping(value = "/hello")
    public String getHello() {
        if(!refreshProperties.isHelloFeatureActive()) {
            throw new InactiveFeatureException("hello inactive");
        }

        return "Web API";
    }

    @GetMapping(value = "/clients")
    public List<Client> getClientes() {
        if(!refreshProperties.isHelloFeatureActive()) {
            throw new InactiveFeatureException("clients inactive");
        }

        return Arrays.asList(
                new Client(1L, "Client 1", FREQUENT_BUYER),
                new Client(2L,"Client 2",  NEVER_BUYER),
                new Client(3L, "Client 3", NEW)
        );
    }
}

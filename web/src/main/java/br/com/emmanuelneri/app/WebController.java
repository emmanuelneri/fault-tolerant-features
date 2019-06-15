package br.com.emmanuelneri.app;

import br.com.emmanuelneri.feature.toggle.FeatureToggle;
import br.com.emmanuelneri.feature.toggle.Features;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static br.com.emmanuelneri.app.Client.Classification.*;

@RestController
@RequestMapping("/web")
public class WebController {

    @GetMapping(value = "/hello")
    @FeatureToggle(feature = Features.HELLO)
    public String getHello() {
        return "Web API";
    }

    @GetMapping(value = "/clients")
    @FeatureToggle(feature = Features.CLIENTS)
    public List<Client> getClients() {
        return Arrays.asList(
                new Client(1L, "Client 1", FREQUENT_BUYER),
                new Client(2L,"Client 2",  NEVER_BUYER),
                new Client(3L, "Client 3", NEW)
        );
    }
}

package br.com.emmanuelneri.app;

import br.com.emmanuelneri.feature.toggle.FeatureToggle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController {

    @GetMapping(value = "/hello")
    @FeatureToggle(
            enableKey = "feature.toggle.feature.hello.active",
            nameKey = "feature.toggle.feature.hello.name")
    public String getHello() {
        return "Hello API";
    }

    @GetMapping(value = "/clients")
    @FeatureToggle(
            enableKey = "feature.toggle.feature.clients.active",
            nameKey = "feature.toggle.feature.clients.name")
    public List<Client> getClientes() {
        return Arrays.asList(
                new Client("Client 1", "094043943"),
                new Client("Client 2", "948394893"),
                new Client("Client 3", "942389342")
        );
    }
}

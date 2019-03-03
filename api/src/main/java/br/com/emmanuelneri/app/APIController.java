package br.com.emmanuelneri.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController {

    @Autowired
    private RefreshProperties refreshProperties;

    @GetMapping(value = "/hello")
    public String getHello() {
        if(!refreshProperties.isHelloFeatureActive()) {
            throw new InactiveFeatureException("hello inactive");
        }

        return "Hello API";
    }

    @GetMapping(value = "/clients")
    public List<Client> getClientes() {
        if(!refreshProperties.isClientsFeatureActive()) {
            throw new InactiveFeatureException("clients inactive");
        }

        return Arrays.asList(
                new Client("Client 1", "094043943"),
                new Client("Client 2", "948394893"),
                new Client("Client 3", "942389342")
        );
    }
}

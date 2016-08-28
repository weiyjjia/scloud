package c.d.e;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;


@Configuration
@EnableAutoConfiguration
@RestController
@EnableConfigServer
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}

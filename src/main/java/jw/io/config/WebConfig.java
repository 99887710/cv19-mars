package jw.io.config;

import jw.io.web.Rest;
import jw.io.web.RestDbClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public Rest rest() {
        return new RestDbClient();
    }
}

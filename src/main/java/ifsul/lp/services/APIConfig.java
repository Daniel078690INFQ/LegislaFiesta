package ifsul.lp.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class APIConfig {

    @Bean
    public RestTemplate restTesmplate() {
        return new RestTemplate();
    }
}

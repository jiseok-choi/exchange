package assignment.exchange.domain.externalapi.config;

import org.springframework.web.client.RestTemplate;

public class RestTemplateClient {

    private static RestTemplate restTemplate;

    public static RestTemplate restTemplate() {

        if (restTemplate == null) {
            restTemplate = new RestTemplate();
        }
        return restTemplate;
    }
}

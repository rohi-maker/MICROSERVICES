package com.LearningMicroservices.microserviceA.config;

import com.LearningMicroservices.microserviceA.client.MicroserviceBClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class MicroserviceBHttpClientConfig {

    @Bean
    public WebClient BMicroserviceWebClient() {
        return WebClient.builder().
                baseUrl("http://microservice-b:8082").
                build();
    }

    @Bean
    public MicroserviceBClient client() {
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(BMicroserviceWebClient())).build();
        return httpServiceProxyFactory.createClient(MicroserviceBClient.class);
    }


}

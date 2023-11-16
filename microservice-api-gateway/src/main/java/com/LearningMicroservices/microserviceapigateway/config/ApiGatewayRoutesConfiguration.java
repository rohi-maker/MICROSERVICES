package com.LearningMicroservices.microserviceapigateway.config;

import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import reactor.netty.http.client.HttpClient;


@Configuration
public class ApiGatewayRoutesConfiguration {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes().route("MICROSERVICE-A", r ->
                        r.path("/a/demo").
                                uri("lb://MICROSERVICE-A"))
                .route("MICROSERVICE-B", r -> r.path("/b/demo").
                        and().
                        method(HttpMethod.GET).
                        uri("lb://MICROSERVICE-B")).build();

    }

//    @Bean
//    public HttpClient httpClient() {
//        return HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
//    }
}

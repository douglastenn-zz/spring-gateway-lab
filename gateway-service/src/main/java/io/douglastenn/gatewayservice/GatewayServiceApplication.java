package io.douglastenn.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

    @Bean
    public RouteLocatorBuilder routeLocatorBuilder(ConfigurableApplicationContext configurableApplicationContext) {
        return new RouteLocatorBuilder(configurableApplicationContext);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("beer-service", r -> r.path("/api/v1/beer/**")
                        .filters(f -> f.rewritePath("/api/v1/beer/(?<ID>.*)", "/api/v1/beer/${ID}"))
                        .uri("lb://beer-service"))
                .build();
    }
}

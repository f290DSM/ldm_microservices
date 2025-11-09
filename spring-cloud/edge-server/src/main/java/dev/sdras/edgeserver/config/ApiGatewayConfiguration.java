package dev.sdras.edgeserver.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//TODO: Remover caso seja utilizado apenas o YAML
@Configuration
public class ApiGatewayConfiguration {
//    @Bean
//    RouteLocator getRouteLocator(RouteLocatorBuilder builder) {
//        return builder
//                .routes()
//                .route("clientms", p -> p.path("/clients/**").uri("lb://clientms"))
//                .build();
//    }
}

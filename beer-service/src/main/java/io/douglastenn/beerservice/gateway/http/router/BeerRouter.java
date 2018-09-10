package io.douglastenn.beerservice.gateway.http.router;

import io.douglastenn.beerservice.gateway.http.api.BeerHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import reactor.core.publisher.Flux;

import java.time.Duration;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class BeerRouter {
    public static final String API_BEER = "/api/v1/beer";
    public static final String ID_PATH_VARIABLE = "/{id}";
    public static final String DELAY = "/delay";

    @Bean
    public RouterFunction<?> routerFunction(final BeerHandler handler) {
        return route(GET(API_BEER).and(accept(APPLICATION_JSON)), handler::findAll)
                .andRoute(GET(API_BEER.concat(DELAY)).and(accept(APPLICATION_JSON)),
                        r -> ok().body(Flux.just("HELLO CHARLES!").delayElements(Duration.ofSeconds(10)), String.class))
                .andRoute(POST(API_BEER).and(accept(APPLICATION_JSON)), handler::create)
                .andRoute(GET(API_BEER.concat(ID_PATH_VARIABLE)).and(accept(APPLICATION_JSON)), handler::findById);

    }
}

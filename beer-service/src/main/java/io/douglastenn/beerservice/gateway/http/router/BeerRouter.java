package io.douglastenn.beerservice.gateway.http.router;

import io.douglastenn.beerservice.gateway.http.api.BeerHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class BeerRouter {
    public static final String API_BEER = "/api/v1/beer";
    public static final String ID_PATH_VARIABLE = "/{id}";

    @Bean
    public RouterFunction<ServerResponse> routerFunction(final BeerHandler handler) {
        return route(GET(API_BEER).and(accept(APPLICATION_JSON)), handler::findAll)
                .andRoute(POST(API_BEER).and(accept(APPLICATION_JSON)), handler::create)
                .andRoute(GET(API_BEER.concat(ID_PATH_VARIABLE)).and(accept(APPLICATION_JSON)), handler::findById);
    }
}

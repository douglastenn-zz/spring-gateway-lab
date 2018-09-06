package io.douglastenn.beerservice.gateway.http.api;

import io.douglastenn.beerservice.gateway.http.api.request.BeerRequest;
import io.douglastenn.beerservice.gateway.http.api.response.BeerResponse;
import io.douglastenn.beerservice.usecase.BeerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

import static io.douglastenn.beerservice.gateway.http.router.BeerRouter.API_BEER;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@RequiredArgsConstructor
public class BeerHandler {

    private final BeerUseCase beerUseCase;

    public Mono<ServerResponse> create(final ServerRequest request) {
        return request
                .bodyToMono(BeerRequest.class)
                .flatMap(beerUseCase::create)
                .flatMap(response ->
                        ServerResponse.created(
                                URI.create(API_BEER.concat(response.getId())))
                                .contentType(APPLICATION_JSON)
                                .body(Mono.just(response), BeerResponse.class));
    }

    public Mono<ServerResponse> findById(final ServerRequest request) {
        return beerUseCase
                .findById(request.pathVariable("id"))
                .flatMap(post -> ok()
                        .contentType(APPLICATION_JSON)
                        .body(Mono.just(post), BeerResponse.class))
                .switchIfEmpty(notFound().build());
    }

    public Mono<ServerResponse> findAll(final ServerRequest request) {
        return ok().contentType(APPLICATION_JSON)
                .body(beerUseCase.findAll(), BeerResponse.class);
    }
}

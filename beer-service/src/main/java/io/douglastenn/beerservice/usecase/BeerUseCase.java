package io.douglastenn.beerservice.usecase;

import io.douglastenn.beerservice.domain.Beer;
import io.douglastenn.beerservice.gateway.BeerGateway;
import io.douglastenn.beerservice.gateway.http.api.request.BeerRequest;
import io.douglastenn.beerservice.gateway.http.api.response.BeerResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class BeerUseCase {

    private final BeerGateway beerGateway;

    private final ModelMapper modelMapper;

    public Mono<BeerResponse> create(final BeerRequest beerRequest) {
        return beerGateway
                .save(modelMapper.map(beerRequest, Beer.class))
                .map(beer -> modelMapper.map(beer, BeerResponse.class));
    }

    public Mono<BeerResponse> findById(final String id) {
        return beerGateway.findById(id)
                .flatMap(beer -> Mono.just(modelMapper.map(beer, BeerResponse.class)));
    }

    public Flux<BeerResponse> findAll() {
        return beerGateway
                .findAll()
                .map(beer -> modelMapper.map(beer, BeerResponse.class));
    }
}

package io.douglastenn.beerservice.gateway.impl;

import io.douglastenn.beerservice.domain.Beer;
import io.douglastenn.beerservice.gateway.BeerGateway;
import io.douglastenn.beerservice.gateway.repository.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BeerGatewayImpl implements BeerGateway {

    private final BeerRepository beerRepository;

    @Override
    public Beer save(final Beer beer) {
        return beerRepository.save(beer);
    }

    @Override
    public Optional<Beer> findById(final String id) {
        return beerRepository.findById(id);
    }

    @Override
    public List<Beer> findAll() {
        return beerRepository.findAll();
    }
}

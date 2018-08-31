package io.douglastenn.beerservice.gateway;

import io.douglastenn.beerservice.domain.Beer;

import java.util.List;
import java.util.Optional;

public interface BeerGateway {
    Beer save(Beer beer);

    Optional<Beer> findById(String id);

    List<Beer> findAll();
}

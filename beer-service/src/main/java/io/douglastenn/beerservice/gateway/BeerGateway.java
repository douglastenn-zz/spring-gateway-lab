package io.douglastenn.beerservice.gateway;

import io.douglastenn.beerservice.domain.Beer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BeerGateway extends ReactiveMongoRepository<Beer, String> {
}

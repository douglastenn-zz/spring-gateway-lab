package io.douglastenn.beerservice.gateway.repository;

import io.douglastenn.beerservice.domain.Beer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BeerRepository extends MongoRepository<Beer, String> {
}

package com.example.webflux.cache;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;


/**
 * @author gutenlee
 * @since 2022/12/22
 */
@Repository
public interface ItemRepository extends ReactiveMongoRepository<Item, String> {
}

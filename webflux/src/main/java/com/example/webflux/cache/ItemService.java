package com.example.webflux.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author gutenlee
 * @since 2022/12/22
 */
@Service
public class ItemService {

    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public Mono<Item> getItem(String id) {
        return repository.findById(id);
    }

    public Mono<Item> save(Item item) {
        return repository.save(item);
    }

}


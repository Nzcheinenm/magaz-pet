package ru.pet.nzcheinenm.repository;

import reactor.core.publisher.Flux;
import ru.pet.nzcheinenm.entity.Product;

import java.util.Set;

public interface ReactiveProductRepository {
    Flux<Product> findAllById(Set<String> ids);
}

package ru.pet.nzcheinenm.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import ru.pet.nzcheinenm.entity.Product;

import java.util.Set;

public interface ReactiveProductRepository extends R2dbcRepository<Product, String> {
}

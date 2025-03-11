package ru.pet.nzcheinenm.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import ru.pet.nzcheinenm.entity.Product;

public interface ReactiveProductRepository extends R2dbcRepository<Product, String> {
}

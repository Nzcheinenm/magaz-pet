package ru.pet.nzcheinenm.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.pet.nzcheinenm.BaseTest;
import ru.pet.nzcheinenm.entity.Product;
import ru.pet.nzcheinenm.repository.ReactiveProductRepository;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DatabaseServiceTest extends BaseTest {
    @Autowired
    ReactiveProductRepository repository;

    @Test
    void smokeTest() {
        assertNull(repository.findAll().blockFirst());

        Product product = new Product();
        product.setId("123");
        product.setType("Product");
        product.setStatus("FAILED");
        product.setExternalId("321");
        product.setCreatedDate(LocalDateTime.now());

        assertNotNull(repository.save(product).block());
    }
}

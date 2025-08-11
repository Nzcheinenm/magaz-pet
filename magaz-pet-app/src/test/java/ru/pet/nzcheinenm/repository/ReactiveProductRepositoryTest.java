package ru.pet.nzcheinenm.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.pet.nzcheinenm.BaseTest;
import ru.pet.nzcheinenm.entity.Product;
import types.StatusType;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ReactiveProductRepositoryTest extends BaseTest {
    @Autowired
    ReactiveProductRepository repository;

    @Test
    void smokeTest() {
        assertNull(repository.findAll().blockFirst());

        Product product = new Product();
        product.setId("123");
        product.setType("Product");
        product.setStatus(StatusType.FAILED);
        product.setExternalId("321");
        product.setCreatedDate(LocalDateTime.now());

        assertNotNull(repository.save(product).block());
    }
}

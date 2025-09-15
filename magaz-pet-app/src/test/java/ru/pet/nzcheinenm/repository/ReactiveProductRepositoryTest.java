package ru.pet.nzcheinenm.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import ru.pet.nzcheinenm.BaseTest;
import ru.pet.nzcheinenm.entity.Product;
import types.StatusType;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ReactiveProductRepositoryTest extends BaseTest {
    @Autowired
    ReactiveProductRepository repository;

    @Test
    void save_product_success() {
        assertNull(repository.findAll().blockFirst());

        Product product = new Product();
        product.setId("123");
        product.setType("Product");
        product.setStatus(StatusType.FAILED);
        product.setExternalId("321");
        product.setCreatedDate(LocalDateTime.now());

        assertNotNull(repository.save(product).block());
    }

    @Test
    void find_product_success() {

        Product product = new Product();
        product.setId("1234");
        product.setType("Product");
        product.setStatus(StatusType.COMPLETED);
        product.setExternalId("4321");
        product.setCreatedDate(LocalDateTime.now());

        assertNotNull(repository.save(product).block());

        Flux<Product> result = repository.findAllByStatus(StatusType.COMPLETED.name());
        assertNotNull(result.blockFirst());
        assertEquals(result.blockFirst(),product);
    }
}

package ru.pet.nzcheinenm.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.pet.nzcheinenm.BaseTest;
import ru.pet.nzcheinenm.entity.Product;
import ru.pet.nzcheinenm.types.StatusType;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest extends BaseTest {
    @Autowired
    ProductRepository repository;

    @Test
    void smokeTest() {
        assertTrue(repository.findAll().isEmpty());

        Product product = new Product();
        product.setId("123");
        product.setType("Product");
        product.setStatus(StatusType.FAILED);
        product.setExternalId("321");
        product.setCreatedDate(LocalDateTime.now());

        assertNotNull(repository.save(product));
    }
}

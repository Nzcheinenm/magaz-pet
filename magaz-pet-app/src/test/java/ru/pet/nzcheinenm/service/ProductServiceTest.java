package ru.pet.nzcheinenm.service;

import dto.request.ProductRequestDto;
import dto.response.ProductResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;
import ru.pet.nzcheinenm.BaseTest;
import types.StatusType;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductServiceTest extends BaseTest {

    @Autowired
    ProductService productService;

    @Test
    public void saveProductTest() {
        ProductRequestDto requestDto = ProductRequestDto.builder()
                .externalId(Constants.EXTERNAL_ID)
                .type(Constants.TYPE)
                .status(StatusType.FAILED)
                .build();

        Mono<ProductResponseDto> result = productService.saveProduct(requestDto);
        assertNotNull(result.block());
    }

    private static class Constants {
        public static final String EXTERNAL_ID = UUID.randomUUID().toString();
        public static final String TYPE = "product_test";
    }
}

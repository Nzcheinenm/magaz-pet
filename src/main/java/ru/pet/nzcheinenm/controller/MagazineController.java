package ru.pet.nzcheinenm.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.pet.nzcheinenm.controller.swagger.Default200ApiResponse;
import ru.pet.nzcheinenm.dto.PageWrapper;
import ru.pet.nzcheinenm.dto.response.ProductResponseDto;


@RestController
@RequiredArgsConstructor
@Tag(name = "Товары", description = "API для товаров")
public class MagazineController {
    public static final String GET_PATH = "/products";

    @Default200ApiResponse
    @Operation(description = "Получение информации по товарам")
    @GetMapping(value = GET_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<PageWrapper<ProductResponseDto>> getProducts(
            @RequestParam(required = false) Integer price,
            @RequestParam String group
    ) {
        return Mono.empty();
    }

}

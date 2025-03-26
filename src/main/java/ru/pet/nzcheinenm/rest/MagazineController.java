package ru.pet.nzcheinenm.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.pet.nzcheinenm.dto.request.ProductRequestDto;
import ru.pet.nzcheinenm.dto.response.ProductResponseDto;
import ru.pet.nzcheinenm.rest.swagger.Default200ApiResponse;
import ru.pet.nzcheinenm.service.ProductService;


@Slf4j
@RestController
@EnableWebFluxSecurity
@RequiredArgsConstructor
@Tag(name = "Товары", description = "API для товаров")
public class MagazineController {
    public static final String GET_PATH = "/products";
    public static final String SAVE_PATH = "/product";
    public static final String SEND_TO_KAFKA_PATH = "/product-kafka";

    private final ProductService productService;
    private final ObjectMapper objectMapper;

    @Default200ApiResponse
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(description = "Получение информации по товарам")
    @GetMapping(value = GET_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<ProductResponseDto> getProducts(
            @RequestParam(required = false) Integer price,
            @RequestParam(required = false) String group,
            @RequestParam String externalId
    ) {
        log.info("[START] Request to getProduct, externalId={}", externalId);
        return productService.getProducts(price, group, externalId);
    }

    @Default200ApiResponse
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(description = "Сохранение информации по товарам")
    @PostMapping(value = SAVE_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ProductResponseDto> saveProduct(
            @RequestBody ProductRequestDto requestDto
    ) throws JsonProcessingException {
        log.info("[START] Request to saveProduct, product={}", objectMapper.writeValueAsString(requestDto));
        return productService.saveProduct(requestDto);
    }

    @Default200ApiResponse
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(description = "Передача информации в канал кафки по товарам")
    @PostMapping(value = SEND_TO_KAFKA_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Void> sendToKafka(
            @RequestBody ProductRequestDto requestDto
    ) throws JsonProcessingException {
        log.info("[START] Request to sendToKafka, product={}", objectMapper.writeValueAsString(requestDto));
        return productService.sendToKafka(requestDto);
    }

}

package ru.pet.nzcheinenm.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.pet.nzcheinenm.dto.PageWrapper;
import ru.pet.nzcheinenm.dto.entity.ProductDto;
import ru.pet.nzcheinenm.dto.request.ProductRequestDto;
import ru.pet.nzcheinenm.dto.response.ProductResponseDto;
import ru.pet.nzcheinenm.mapper.ProductMapper;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;
    private final DatabaseProductService databaseProductService;

    public Flux<ProductResponseDto> getProducts(Integer price,
                                                String group,
                                                String externalId) {
        Flux<ProductDto> products = databaseProductService.findAll(externalId, group, price);
        return products.map(productMapper::convertToResponse);
    }

    public Mono<ProductResponseDto> saveProduct(ProductRequestDto requestDto) {
        ProductDto productDto = productMapper.convertRequest(requestDto);
        return databaseProductService.save(productDto)
                .map(product -> productMapper.convertToResponse(productDto));
    }
}

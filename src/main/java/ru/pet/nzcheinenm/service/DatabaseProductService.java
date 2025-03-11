package ru.pet.nzcheinenm.service;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.pet.nzcheinenm.dto.entity.ProductDto;
import ru.pet.nzcheinenm.entity.Product;
import ru.pet.nzcheinenm.mapper.ProductMapper;
import ru.pet.nzcheinenm.repository.ReactiveProductRepository;

import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class DatabaseProductService {
    private final ReactiveProductRepository repository;

    private final ProductMapper productMapper;

    public Mono<Product> save(ProductDto dto) {
        Product product = productMapper.convert(dto);
        return repository.save(product);
    }

    public Flux<ProductDto> findAll(@NotBlank String externalId,
                                    String group,
                                    Integer price) {
        var probe = constructProduct(externalId, group, price)
                .build();
        Example<Product> productExample = Example.of(probe);
        return repository.findAll(productExample)
                .map(productMapper::convert);
    }

    private Product.ProductBuilder constructProduct(String externalId, String group, Integer price) {
        var probeBuilder = Product.builder();
        probeBuilder.externalId(externalId);
        if (Strings.isNotBlank(group)) {
            probeBuilder.groupType(group);
        }
        if (Objects.nonNull(price)) {
            probeBuilder.price(price);
        }
        return probeBuilder;
    }
}

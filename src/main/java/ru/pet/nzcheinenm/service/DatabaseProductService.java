package ru.pet.nzcheinenm.service;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import ru.pet.nzcheinenm.dto.entity.ProductDto;
import ru.pet.nzcheinenm.entity.Product;
import ru.pet.nzcheinenm.mapper.ProductMapper;
import ru.pet.nzcheinenm.repository.ProductRepository;
import ru.pet.nzcheinenm.types.StatusType;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class DatabaseProductService {
    private final ProductRepository repository;

    private final ProductMapper productMapper;

    public ProductDto save(ProductDto dto) {
        Product product = productMapper.convert(dto);
        return productMapper.convert(repository.save(product));
    }

    public List<ProductDto> findAllByStatus(StatusType status) {
        return repository.findAllByStatus(status.name()).stream()
                .map(productMapper::convert)
                .toList();
    }

    public List<ProductDto> findAllByExternalIdAndGroupAndPrice(@NotBlank String externalId,
                                                                String group,
                                                                Integer price) {
        var probe = constructProduct(externalId, group, price)
                .build();
        Example<Product> productExample = Example.of(probe);
        return repository.findAll(productExample).stream()
                .map(productMapper::convert)
                .toList();
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

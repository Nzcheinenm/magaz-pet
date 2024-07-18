package ru.pet.nzcheinenm.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.pet.nzcheinenm.dto.entity.ProductDto;
import ru.pet.nzcheinenm.dto.request.ProductRequestDto;
import ru.pet.nzcheinenm.dto.response.ProductResponseDto;
import ru.pet.nzcheinenm.entity.Product;

import java.time.LocalDateTime;

@Mapper(imports = LocalDateTime.class)
public interface ProductMapper {
    @Mapping(target = "version", ignore = true)
    Product convert(ProductDto dto);

    ProductDto convert(Product dto);

    @Mapping(target = "name", ignore = true)
    ProductResponseDto convertToResponse(ProductDto dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "messageId", ignore = true)
    @Mapping(target = "createdDate", expression = "java(LocalDateTime.now())")
    ProductDto convertRequest(ProductRequestDto dto);
}

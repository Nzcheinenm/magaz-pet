package ru.pet.nzcheinenm.mapper;

import dto.request.ProductRequestDto;
import dto.response.ProductResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.pet.nzcheinenm.dto.entity.ProductDto;
import ru.pet.nzcheinenm.dto.request.ProductRequestKafkaDto;
import ru.pet.nzcheinenm.entity.Product;

import java.time.LocalDateTime;
import java.util.UUID;

@Mapper(imports = {LocalDateTime.class, UUID.class})
public interface ProductMapper {
    @Mapping(target = "version", ignore = true)
    Product convert(ProductDto dto);

    ProductDto convert(Product dto);

    @Mapping(target = "name", ignore = true)
    ProductResponseDto convertToResponse(ProductDto dto);

    @Mapping(target = "id", expression = "java(UUID.randomUUID().toString())")
    @Mapping(target = "messageId", expression = "java(UUID.randomUUID().toString())")
    @Mapping(target = "createdDate", expression = "java(LocalDateTime.now())")
    ProductDto convertRequest(ProductRequestDto dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "messageId", ignore = true)
    ProductRequestKafkaDto convertRequestToKafka(ProductRequestDto dto);
}

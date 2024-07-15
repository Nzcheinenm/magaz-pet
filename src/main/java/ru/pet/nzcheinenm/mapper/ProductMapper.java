package ru.pet.nzcheinenm.mapper;

import org.mapstruct.Mapper;
import ru.pet.nzcheinenm.dto.entity.ProductDto;
import ru.pet.nzcheinenm.entity.Product;

@Mapper
public interface ProductMapper {
    Product convert(ProductDto dto);
    ProductDto convert(Product dto);
}

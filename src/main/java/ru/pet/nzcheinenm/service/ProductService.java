package ru.pet.nzcheinenm.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.SenderResult;
import ru.pet.nzcheinenm.dto.entity.ProductDto;
import ru.pet.nzcheinenm.dto.request.ProductRequestDto;
import ru.pet.nzcheinenm.dto.request.ProductRequestKafkaDto;
import ru.pet.nzcheinenm.dto.response.ProductResponseDto;
import ru.pet.nzcheinenm.mapper.ProductMapper;
import ru.pet.nzcheinenm.service.kafka.ProductProducerService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;
    private final DatabaseProductService databaseProductService;
    private final ProductProducerService productProducerService;

    public List<ProductResponseDto> getProducts(Integer price,
                                                String group,
                                                String externalId) {
        List<ProductDto> products = databaseProductService.findAllByExternalIdAndGroupAndPrice(externalId, group, price);
        return products.stream().map(productMapper::convertToResponse).toList();
    }

    public ProductResponseDto saveProduct(ProductRequestDto requestDto) {
        ProductDto productDto = productMapper.convertRequest(requestDto);
        databaseProductService.save(productDto);
        return productMapper.convertToResponse(productDto);
    }

    public void sendToKafka(ProductRequestDto requestDto) {
        ProductRequestKafkaDto requestKafkaDto = productMapper.convertRequestToKafka(requestDto);
        productProducerService.sendProductToKafka(requestKafkaDto);
    }
}

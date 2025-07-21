package ru.pet.nzcheinenm.service.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.SenderResult;
import ru.pet.nzcheinenm.config.kafka.property.KafkaAdminProperty;
import ru.pet.nzcheinenm.dto.request.ProductRequestKafkaDto;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductProducerService {
    private final ReactiveKafkaProducerTemplate<String, ProductRequestKafkaDto> productTemplate;
    private final KafkaAdminProperty kafkaAdminProperty;

    public void sendProductToKafka(ProductRequestKafkaDto productRequestKafkaDto) {
        String topicName = kafkaAdminProperty.getTopic().getTopicName();
        try {
            Mono<SenderResult<Void>> result = productTemplate.send(topicName, productRequestKafkaDto);
            log.info("[SUCCESS] Send message to {} topic. ", topicName);
        } catch (Exception e) {
            log.error("[FAILED] Send message to {} topic. ", topicName);
            throw e;
        }
    }
}

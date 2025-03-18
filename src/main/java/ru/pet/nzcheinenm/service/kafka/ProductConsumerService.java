package ru.pet.nzcheinenm.service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.pet.nzcheinenm.dto.request.KafkaConsumeRequestDto;

@Service
public class ProductConsumerService {

    @KafkaListener(topics = "${spring.kafka.consumer.topic-name:test_topic_rq}")
    public void consume(KafkaConsumeRequestDto data) {
        return;
    }
}

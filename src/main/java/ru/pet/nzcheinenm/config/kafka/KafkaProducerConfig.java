package ru.pet.nzcheinenm.config.kafka;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import reactor.kafka.sender.SenderOptions;
import ru.pet.nzcheinenm.dto.request.ProductRequestKafkaDto;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class KafkaProducerConfig {
    private final KafkaProperties kafkaProperties;

    @Bean
    @ConditionalOnProperty(prefix = "spring.kafka.producer", name = "enabled", havingValue = "true")
    public ReactiveKafkaProducerTemplate<String, ProductRequestKafkaDto> productTemplate() {
        return new ReactiveKafkaProducerTemplate<>(getProductSenderOptions());
    }

    private SenderOptions<String, ProductRequestKafkaDto> getProductSenderOptions() {
        Map<String, Object> config = getCommonConfigMap();
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        config.put(JsonDeserializer.VALUE_DEFAULT_TYPE, ProductRequestKafkaDto.class);
        return SenderOptions.create(config);
    }

    private Map<String, Object> getCommonConfigMap() {
        final Map<String, Object> config = new HashMap<>(kafkaProperties.getSecurity().buildProperties());
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);
        return config;
    }
}
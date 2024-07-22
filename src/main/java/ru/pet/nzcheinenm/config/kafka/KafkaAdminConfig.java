package ru.pet.nzcheinenm.config.kafka;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;
import ru.pet.nzcheinenm.config.kafka.property.KafkaAdminProperty;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
@ConditionalOnProperty(prefix = "spring.kafka.admin", name = "enabled", havingValue = "true")
public class KafkaAdminConfig {
    private final KafkaAdminProperty kafkaAdminProperty;
    private final KafkaProperties kafkaProperties;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        final Map<String, Object> config = new HashMap<>(kafkaProperties.getSecurity().buildProperties());
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaAdminProperty.getBootstrapServers());
        KafkaAdmin kafkaAdmin = new KafkaAdmin(config);
        kafkaAdmin.createOrModifyTopics(buildProductTopic());
        return kafkaAdmin;
    }


    private NewTopic buildProductTopic() {
        KafkaAdminProperty.TopicProperty topicProperty = kafkaAdminProperty.getTopic();
        return new NewTopic(kafkaAdminProperty.getTopic().getTopicName(),
                topicProperty.getPartitions(),
                topicProperty.getReplicas())
                .configs(topicConfiguration());
    }

    private Map<String, String> topicConfiguration() {
        Map<String, String> topicConfig = new HashMap<>();
        topicConfig.put(TopicConfig.RETENTION_MS_CONFIG, String.valueOf(kafkaAdminProperty.getTopic().getRetentionMs()));
        return topicConfig;
    }
}


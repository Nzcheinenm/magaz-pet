package ru.pet.nzcheinenm.config.kafka.property;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "spring.kafka.admin")
public class KafkaAdminProperty {
    private boolean enabled;
    private TopicProperty topic;
    private String bootstrapServers;

    @Getter
    @Setter
    public static class TopicProperty {
        private boolean enabled;
        @NotBlank
        private String topicName;
        @Positive
        private int partitions;
        @Positive
        private short replicas;
        @Positive
        private long retentionMs;
        @Positive
        private long deleteDelayMs;
    }
}

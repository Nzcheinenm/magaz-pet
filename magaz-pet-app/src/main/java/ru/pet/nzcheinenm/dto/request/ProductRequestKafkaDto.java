package ru.pet.nzcheinenm.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record ProductRequestKafkaDto(
        @NotBlank
        String id,
        String type,
        String status,
        String messageId
) {
}

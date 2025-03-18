package ru.pet.nzcheinenm.dto.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ProductDto(
        @NotBlank
        String id,
        String type,
        String status,
        String messageId,
        LocalDateTime createdDate,
        String phone,
        String email,
        String text,
        @NotBlank
        String externalId,
        String groupType,
        Integer price
) {
}

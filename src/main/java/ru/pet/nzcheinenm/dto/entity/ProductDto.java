package ru.pet.nzcheinenm.dto.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import ru.pet.nzcheinenm.types.StatusType;

import java.time.LocalDateTime;

@Builder
public record ProductDto(
        @NotBlank
        String id,
        @NotBlank
        String type,
        @NotNull
        StatusType status,
        String messageId,
        @NotNull
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

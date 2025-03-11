package ru.pet.nzcheinenm.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record ProductRequestDto(
        @NotBlank
        String type,
        @NotBlank
        String status,
        String phone,
        String email,
        String text,
        @NotBlank
        String externalId,
        String groupType,
        Integer price
) {
}

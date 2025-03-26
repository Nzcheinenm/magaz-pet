package ru.pet.nzcheinenm.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import ru.pet.nzcheinenm.types.StatusType;

@Builder
public record ProductRequestDto(
        @NotBlank
        String type,
        @NotBlank
        StatusType status,
        String phone,
        String email,
        String text,
        @NotBlank
        String externalId,
        String groupType,
        Integer price
) {
}

package ru.pet.nzcheinenm.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record KafkaConsumeRequestDto(@NotBlank String id) {
}

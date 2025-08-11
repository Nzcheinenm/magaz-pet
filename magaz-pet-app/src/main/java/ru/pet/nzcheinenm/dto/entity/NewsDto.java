package ru.pet.nzcheinenm.dto.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record NewsDto(
        @NotBlank
        String id,
        String name,
        LocalDate dateNews,
        String description
) {
}

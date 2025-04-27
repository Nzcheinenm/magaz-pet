package ru.pet.nzcheinenm.dto.request;

import org.apache.kafka.common.protocol.types.Field;

public record NewsRequestDto(
        String name,
        String description
) {
}

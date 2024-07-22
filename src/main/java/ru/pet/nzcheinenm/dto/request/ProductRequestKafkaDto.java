package ru.pet.nzcheinenm.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ProductRequestKafkaDto {
    @NotBlank
    String id;
    String type;
    String status;
    String messageId;
}

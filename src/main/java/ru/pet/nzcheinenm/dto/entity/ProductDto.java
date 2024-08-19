package ru.pet.nzcheinenm.dto.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class ProductDto {
    @NotBlank
    String id;
    String type;
    String status;
    String messageId;
    LocalDateTime createdDate;
    String phone;
    String email;
    String text;
    @NotBlank
    String externalId;
    String groupType;
    Integer price;
}

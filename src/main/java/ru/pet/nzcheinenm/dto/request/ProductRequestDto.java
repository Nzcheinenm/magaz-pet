package ru.pet.nzcheinenm.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class ProductRequestDto {
    String type;
    String status;
    String phone;
    String email;
    String text;
    @NotBlank
    String externalId;
    String group;
    Integer price;
}

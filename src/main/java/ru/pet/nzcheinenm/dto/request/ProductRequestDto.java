package ru.pet.nzcheinenm.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ProductRequestDto {
    @NotBlank
    String type;
    @NotBlank
    String status;
    String phone;
    String email;
    String text;
    @NotBlank
    String externalId;
    String groupType;
    Integer price;
}

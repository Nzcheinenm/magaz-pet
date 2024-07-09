package ru.pet.nzcheinenm.dto.entity;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class ProductDto {
    Integer version;
    String id;
    String type;
    String status;
    String messageId;
    LocalDateTime createdDate;
    String phone;
    String email;
    String text;
}

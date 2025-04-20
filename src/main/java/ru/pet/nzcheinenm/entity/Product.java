package ru.pet.nzcheinenm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.pet.nzcheinenm.types.StatusType;

import java.time.LocalDateTime;

@Data
@Entity
@Table
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseEntity {
    String type;
    StatusType status;
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

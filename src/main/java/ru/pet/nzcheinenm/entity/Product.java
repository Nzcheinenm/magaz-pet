package ru.pet.nzcheinenm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.pet.nzcheinenm.types.StatusType;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "product")
@SuperBuilder
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

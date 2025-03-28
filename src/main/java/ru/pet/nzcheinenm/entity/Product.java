package ru.pet.nzcheinenm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pet.nzcheinenm.types.StatusType;

import java.time.LocalDateTime;

@Data
@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Version
    Integer version;
    @Id
    String id;
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

package dto.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import types.StatusType;

@Builder
public record ProductRequestDto(
        @NotBlank
        String type,
        @NotBlank
        StatusType status,
        String phone,
        String email,
        String text,
        @NotBlank
        String externalId,
        String groupType,
        Integer price
) {
}

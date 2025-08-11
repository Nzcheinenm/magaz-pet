package dto.response;

import lombok.Builder;


@Builder
public record ProductResponseDto(
        String name,
        Integer price
) {
}

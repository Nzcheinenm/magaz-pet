package ru.pet.nzcheinenm.dto;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.Collection;

@Schema
@Value
@Builder
@AllArgsConstructor
@Jacksonized
public class PageWrapper<T> {
    @ArraySchema(arraySchema = @Schema(description = "Содержание", minimum = "1", maximum = "2147483647"),
            maxItems = Integer.MAX_VALUE)
    Collection<T> content;
    @Schema(description = "Текущая страница", minimum = "1", maximum = "2147483647")
    int currentPage;
    @Schema(description = "Всего страниц", minimum = "0", maximum = "2147483647")
    int totalPages;
    @Schema(description = "Всего элементов", minimum = "0", maximum = "2147483647")
    long totalElements;
}

package ru.pet.nzcheinenm.mapper;

import dto.request.NewsRequestDto;
import dto.response.NewsResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.pet.nzcheinenm.dto.entity.NewsDto;
import ru.pet.nzcheinenm.entity.News;

import java.time.LocalDate;
import java.util.UUID;

@Mapper(imports = {LocalDate.class, UUID.class})
public interface NewsMapper {
    @Mapping(target = "version", ignore = true)
    News convert(NewsDto dto);

    NewsDto convert(News dto);

    @Mapping(target = "id", expression = "java(UUID.randomUUID().toString())")
    @Mapping(target = "dateNews", expression = "java(LocalDate.now())")
    NewsDto convertRequest(NewsRequestDto dto);

    NewsResponseDto convertResponse(NewsDto x);
}

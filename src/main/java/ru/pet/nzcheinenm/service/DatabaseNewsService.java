package ru.pet.nzcheinenm.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.pet.nzcheinenm.dto.entity.NewsDto;
import ru.pet.nzcheinenm.entity.News;
import ru.pet.nzcheinenm.mapper.NewsMapper;
import ru.pet.nzcheinenm.repository.NewsRepository;

@Service
@RequiredArgsConstructor
public class DatabaseNewsService {
    private final NewsRepository repository;
    private final NewsMapper newsMapper;

    public NewsDto save(NewsDto dto) {
        News news = newsMapper.convert(dto);
        return newsMapper.convert(repository.save(news));
    }
}

package ru.pet.nzcheinenm.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.pet.nzcheinenm.dto.entity.NewsDto;
import ru.pet.nzcheinenm.entity.News;
import ru.pet.nzcheinenm.mapper.NewsMapper;
import ru.pet.nzcheinenm.repository.ReactiveNewsRepository;

@Service
@RequiredArgsConstructor
public class DatabaseNewsService {
    private final ReactiveNewsRepository repository;
    private final NewsMapper newsMapper;

    public Mono<NewsDto> save(NewsDto dto) {
        News news = newsMapper.convert(dto);
        return repository.save(news).map(newsMapper::convert);
    }
}

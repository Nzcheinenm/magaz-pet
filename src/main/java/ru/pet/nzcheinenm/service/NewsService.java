package ru.pet.nzcheinenm.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.pet.nzcheinenm.dto.entity.NewsDto;
import ru.pet.nzcheinenm.dto.request.NewsRequestDto;
import ru.pet.nzcheinenm.dto.response.NewsResponseDto;
import ru.pet.nzcheinenm.mapper.NewsMapper;

@Service
@RequiredArgsConstructor
public class NewsService {
    private DatabaseNewsService service;
    private NewsMapper mapper;

    public Mono<NewsResponseDto> saveNews(NewsRequestDto requestDto) {
        Mono<NewsDto> entity = service.save(mapper.convertRequest(requestDto));
        return entity.map(x -> mapper.convertResponse(x));
    }
}

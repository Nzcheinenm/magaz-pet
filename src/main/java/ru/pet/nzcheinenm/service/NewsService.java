package ru.pet.nzcheinenm.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.pet.nzcheinenm.dto.request.NewsRequestDto;
import ru.pet.nzcheinenm.dto.response.NewsResponseDto;
import ru.pet.nzcheinenm.mapper.NewsMapper;
import ru.pet.nzcheinenm.service.database.DatabaseNewsService;

@Service
@RequiredArgsConstructor
public class NewsService {
    private final DatabaseNewsService service;
    private final NewsMapper mapper;

    public Mono<NewsResponseDto> saveNews(NewsRequestDto requestDto) {
        return service.save(mapper.convertRequest(requestDto))
                .map(mapper::convertResponse);
    }
}

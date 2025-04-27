package ru.pet.nzcheinenm.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.pet.nzcheinenm.dto.request.NewsRequestDto;
import ru.pet.nzcheinenm.dto.response.ProductResponseDto;

@Service
@RequiredArgsConstructor
public class NewsService {
    public Mono<ProductResponseDto> saveNews(NewsRequestDto requestDto) {
        return Mono.empty();
    }
}

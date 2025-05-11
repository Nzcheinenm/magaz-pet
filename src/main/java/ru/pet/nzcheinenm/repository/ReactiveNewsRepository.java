package ru.pet.nzcheinenm.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import ru.pet.nzcheinenm.entity.News;

public interface ReactiveNewsRepository extends R2dbcRepository<News, String> {
}

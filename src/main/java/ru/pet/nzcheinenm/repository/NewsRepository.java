package ru.pet.nzcheinenm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pet.nzcheinenm.entity.News;

public interface NewsRepository extends JpaRepository<News, String> {
}

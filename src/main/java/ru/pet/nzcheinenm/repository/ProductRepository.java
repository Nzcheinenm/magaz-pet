package ru.pet.nzcheinenm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pet.nzcheinenm.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findAllByStatus(String status);
}

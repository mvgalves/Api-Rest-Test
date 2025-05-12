package me.dio.bradesco_cloud_native.repository;

import me.dio.bradesco_cloud_native.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}

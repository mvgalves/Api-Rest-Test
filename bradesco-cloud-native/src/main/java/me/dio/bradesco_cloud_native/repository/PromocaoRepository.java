package me.dio.bradesco_cloud_native.repository;

import me.dio.bradesco_cloud_native.model.Promocao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromocaoRepository extends JpaRepository<Promocao, Long> {
}

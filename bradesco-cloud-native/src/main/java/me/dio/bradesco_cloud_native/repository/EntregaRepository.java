package me.dio.bradesco_cloud_native.repository;

import me.dio.bradesco_cloud_native.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {
}

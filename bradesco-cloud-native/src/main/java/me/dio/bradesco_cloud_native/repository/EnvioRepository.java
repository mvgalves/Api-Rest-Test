package me.dio.bradesco_cloud_native.repository;

import me.dio.bradesco_cloud_native.model.Envio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvioRepository extends JpaRepository<Envio, Long> {
}

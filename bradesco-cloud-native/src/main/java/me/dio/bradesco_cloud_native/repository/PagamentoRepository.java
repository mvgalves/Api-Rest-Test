package me.dio.bradesco_cloud_native.repository;

import me.dio.bradesco_cloud_native.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}

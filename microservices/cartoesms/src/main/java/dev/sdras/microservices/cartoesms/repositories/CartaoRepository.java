package dev.sdras.microservices.cartoesms.repositories;

import dev.sdras.microservices.cartoesms.domain.CartaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface CartaoRepository extends JpaRepository<CartaoEntity, Long> {
    List<CartaoEntity> findByRendaLessThanEqual(BigDecimal renda);
}

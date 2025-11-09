package dev.sdras.microservices.cartoesms.repositories;

import dev.sdras.microservices.cartoesms.domain.ClienteCartaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteCartaoRepository extends JpaRepository<ClienteCartaoEntity, Long> {
    List<ClienteCartaoEntity> findByCpf(String cpf);
}

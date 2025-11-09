package dev.sdras.microservices.cartoesms.services;

import dev.sdras.microservices.cartoesms.domain.ClienteCartaoEntity;
import dev.sdras.microservices.cartoesms.repositories.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {

    private final ClienteCartaoRepository repository;

    public List<ClienteCartaoEntity> listCartoesByCpf(String cpf){
        return repository.findByCpf(cpf);
    }
}

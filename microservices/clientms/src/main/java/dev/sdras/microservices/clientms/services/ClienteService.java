package dev.sdras.microservices.clientms.services;

import dev.sdras.microservices.clientms.domain.ClienteEntity;
import dev.sdras.microservices.clientms.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;

    @Transactional
    public ClienteEntity save(ClienteEntity cliente){
        return repository.save(cliente);
    }

    public Optional<ClienteEntity> getByCPF(String cpf){
        return repository.findByCpf(cpf);
    }
}

package dev.sdras.microservices.clientms.resources;

import dev.sdras.microservices.clientms.domain.ClienteDTO;
import dev.sdras.microservices.clientms.domain.ClienteEntity;
import dev.sdras.microservices.clientms.services.ClienteService;
import dev.sdras.microservices.clientms.services.InstanceInformationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    final ClienteService service;
    final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ClienteDTO dto){
        var cliente = mapper.map(dto, ClienteEntity.class);
        service.save(cliente);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(cliente.getCpf())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<?> dadosCliente(@RequestParam("cpf") String cpf){
        var cliente = service.getByCPF(cpf);
        if(cliente.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }
}

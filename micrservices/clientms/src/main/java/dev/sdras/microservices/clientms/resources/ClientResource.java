package dev.sdras.microservices.clientms.resources;

import dev.sdras.microservices.clientms.domain.Client;
import dev.sdras.microservices.clientms.services.InstanceInformationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/clients")
public class ClientResource {

    final InstanceInformationService instanceInformationService;

    public ClientResource(InstanceInformationService instanceInformationService) {
        this.instanceInformationService = instanceInformationService;
    }

    @GetMapping
    public Client getClient() {
        return Client.builder()
                .uuid(UUID.randomUUID().toString())
                .name("Client " + UUID.randomUUID().toString())
                .email("vip@client.com")
                .address("server: " + instanceInformationService.getServerPort())
                .build();
    }
}

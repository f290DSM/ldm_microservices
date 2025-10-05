# Client Micro Service

## Guide

### Criando o Projeto

1. Crie um diretorio ldmp_microservices;
2. Dentro do diretorio ldmp_microservices crie o diretorio microservices;
3. Dentro do diretório `microservices`, crie um projeto Spring Boot com dependencia `Spring Web`, `Spring Actuator` e `Lombok`;
4. Ative o `Annotation Processors` nos pluggins do IntelliJ.

### Camada de Domínio

1. Crie o pacote `domain` dentro da raiz do projeto;
2. Crie a classe `Client` com o código abaixo;

```java
package seupacotedeaplicacao.domain;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private String uuid;
    private String name;
    private String email;
    private String address;
}
```

#### ServiceUtil

Iremos criar um utiliario para exibir as informaçoes dos hosts envolvidos as requisicoes entre microservices, este utilitario posteriormente sera refatorado para utilizacao nos demais microservices.

Para criar o utilitário, siga as instruçoes abaixo.

1. Crie a classe `InstanceInformationService.java` no pacote `services`;

```java
package seupacotdeaplicacao.services;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class InstanceInformationService implements ApplicationListener<WebServerInitializedEvent> {

    private Integer serverPort;

    public Integer getServerPort() {
        return serverPort;
    }

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        this.serverPort = event.getWebServer().getPort();
    }
}

```

### Camada de Aplicacao

A camada de aplicacao será composta por 2 classes inicialmente, um service e um resource.

1. Crie a classe `ClientResource` no pacote `resources`, o applicatio deve estar na raiz do projeto.
2. Inclua o codigo abaixo na classe:

```java
package seupacotedeaplicacao.resources;

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
                .address("server port: " + instanceInformationService.getServerPort())
                .build();
    }
}
```

3. Renomeie o aqruivo `application.properties` para `application.yml`.
4. Inclua o nome do serviço e a porta do servidor no arquivo `application.yml`.

```yaml
server:
  port: 9000

spring:
  application:
    name: product-service
```

## Testando a aplicação

1. Execute a aplicação;
> A dentro do diretório raiz de clientms execute o projet com o comando abaixo.
```shell
.\gradlew bootRun
```
2. No navegador, entre com a url `localhost:9000`, o resultado deve ser um white label.
3. No navegador, entre com a url `localhost:9000/clients`, o resultado deve ser um json conforme o exemplo abaixo.

```json
{"uuid":"479d0607-d598-42ee-a475-3257d923c3e2","name":"Client e478f44b-8abf-4186-a185-319802efc972","email":"vip@client.com","address":"server port: 9000"}
```

# Concluímos o MVP de nosso primeiro MicroService
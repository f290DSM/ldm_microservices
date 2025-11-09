package dev.sdras.microservices.clientms.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class ClienteDTO {
    private String cpf;
    private String nome;
    private Integer idade;
}

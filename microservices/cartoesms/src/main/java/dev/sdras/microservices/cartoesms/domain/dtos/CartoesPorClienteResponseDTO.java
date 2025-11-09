package dev.sdras.microservices.cartoesms.domain.dtos;

import dev.sdras.microservices.cartoesms.domain.ClienteCartaoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartoesPorClienteResponseDTO {
    private String nome;
    private String bandeira;
    private BigDecimal limiteLiberado;

    public static CartoesPorClienteResponseDTO fromModel(ClienteCartaoEntity model){
        return new CartoesPorClienteResponseDTO(
                model.getCartaoEntity().getNome(),
                model.getCartaoEntity().getBandeira().toString(),
                model.getLimite()
        );
    }
}

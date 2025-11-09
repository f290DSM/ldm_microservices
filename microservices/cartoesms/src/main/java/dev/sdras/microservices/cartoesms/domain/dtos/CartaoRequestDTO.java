package dev.sdras.microservices.cartoesms.domain.dtos;

import dev.sdras.microservices.cartoesms.domain.BandeiraCartao;
import dev.sdras.microservices.cartoesms.domain.CartaoEntity;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoRequestDTO {

    private String nome;
    private BandeiraCartao bandeira;
    private BigDecimal renda;
    private BigDecimal limite;

    public CartaoEntity toModel() {
        return new CartaoEntity(nome, bandeira, renda, limite);
    }
}

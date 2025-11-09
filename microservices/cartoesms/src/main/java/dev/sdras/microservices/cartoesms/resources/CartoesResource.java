package dev.sdras.microservices.cartoesms.resources;

import dev.sdras.microservices.cartoesms.domain.CartaoEntity;
import dev.sdras.microservices.cartoesms.domain.ClienteCartaoEntity;
import dev.sdras.microservices.cartoesms.domain.dtos.CartaoRequestDTO;
import dev.sdras.microservices.cartoesms.domain.dtos.CartoesPorClienteResponseDTO;
import dev.sdras.microservices.cartoesms.services.CartaoService;
import dev.sdras.microservices.cartoesms.services.ClienteCartaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cartoes")
@RequiredArgsConstructor
public class CartoesResource {

    private final CartaoService cartaoService;
    private final ClienteCartaoService clienteCartaoService;

    @PostMapping
    public ResponseEntity<Void> cadastra( @RequestBody CartaoRequestDTO dto){
        CartaoEntity cartao = dto.toModel();
        cartaoService.save(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<CartaoEntity>> getCartoesRendaAteh(@RequestParam("renda") Long renda){
        List<CartaoEntity> list = cartaoService.getCartoesRendaMenorIgual(renda);
        return ResponseEntity.ok(list);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartoesPorClienteResponseDTO>> getCartoesByCliente(
            @RequestParam("cpf") String cpf){
        List<ClienteCartaoEntity> lista = clienteCartaoService.listCartoesByCpf(cpf);
        List<CartoesPorClienteResponseDTO> resultList = lista.stream()
                .map(CartoesPorClienteResponseDTO::fromModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resultList);
    }
}

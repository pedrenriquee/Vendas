package org.example.controller;


import jakarta.validation.Valid;
import org.example.dto.PedidoDTO;
import org.example.model.PEDIDO;
import org.example.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private PedidoService pedidos;

    public PedidoController(PedidoService pedidos) {
        this.pedidos = pedidos;
    }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public Integer save(@RequestBody @Valid PedidoDTO dto){
          PEDIDO pedido = pedidos.salvar(dto);
            return pedido.getId();
        }

}

//A requisição funcionará assim

/* {
    "cliente": *,
    "total":*,
    "items":[{
        "produto":*,
        "quantidade": *
    }]
} */

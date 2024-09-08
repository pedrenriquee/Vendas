package org.example.service;

import org.example.dto.PedidoDTO;
import org.example.model.PEDIDO;

public interface PedidoService {
    PEDIDO salvar(PedidoDTO dto);
}

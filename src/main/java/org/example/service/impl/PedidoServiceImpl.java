package org.example.service.impl;


import org.example.repositoy.Pedidos;
import org.example.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {
    private Pedidos pedidos;

    public PedidoServiceImpl(Pedidos pedidos) {
        this.pedidos = pedidos;
    }
}

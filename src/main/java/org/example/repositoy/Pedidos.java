package org.example.repositoy;

import org.example.model.PEDIDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pedidos extends JpaRepository<PEDIDO, Integer> {
}

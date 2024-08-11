package org.example.repositoy;

import org.example.model.ITEMPEDIDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedido extends JpaRepository<ITEMPEDIDO, Integer> {
}

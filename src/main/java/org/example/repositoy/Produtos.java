package org.example.repositoy;

import org.example.model.PRODUTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<PRODUTO, Integer> {
}

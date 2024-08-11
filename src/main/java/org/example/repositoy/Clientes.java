package org.example.repositoy;

import org.example.model.CLIENTE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface Clientes extends JpaRepository<CLIENTE, Long> {


   @Query(value = "select c from CLIENTE c where c.nome like :nome")
   List<CLIENTE> encontrarPorNome(@Param("nome") String nome);

   @Query("select c from CLIENTE c left join fetch c.pedidos where c.id =:id")
   CLIENTE findClienteFetchPedidos(@Param("id") Long id);



}

package org.example.repositoy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.model.CLIENTE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Repository
public class Clientes {

  @Autowired
  private EntityManager entityManager;

  @Transactional
  public CLIENTE inserir(CLIENTE cliente){
      entityManager.persist(cliente);
      return cliente;
  }
  @Transactional
  public CLIENTE atualizar(CLIENTE cliente){
      entityManager.merge(cliente);
      return cliente;
  }

  @Transactional
  public void deletar(CLIENTE cliente){
     if(!entityManager.contains(cliente)){
         cliente = entityManager.merge(cliente);
     }

     entityManager.remove(cliente);
  }
  @Transactional
  public void deletar( Long id){
     CLIENTE cliente= entityManager.find(CLIENTE.class, id);
     deletar(cliente);
  }

  @Transactional(readOnly = true)
  public List<CLIENTE> buscarPorNome(String nome){
      String jpql = " select c from CLIENTE c where c.nome like = :nome ";
     TypedQuery<CLIENTE> query = entityManager.createQuery(jpql, CLIENTE.class);
      query.setParameter("nome", "%" + nome +"%");
      return query.getResultList();
  }

  @Transactional(readOnly = true)
  public List<CLIENTE> obterTodos(){
      return entityManager.
              createQuery("from CLIENTE", CLIENTE.class)
              .getResultList();
  }


}

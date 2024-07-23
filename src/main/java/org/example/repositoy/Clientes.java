package org.example.repositoy;

import org.example.model.CLIENTE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class Clientes {

   private static String INSERT = "insert into CLIENTE (nome) values (?)";
   private static String SELECT_ALL = "SELECT * FROM CLIENTE";
  @Autowired
  private  JdbcTemplate jdbcTemplate;
  public CLIENTE salvar(CLIENTE cliente){
      jdbcTemplate.update(INSERT, new Object[]{cliente.getNome()});
      return cliente;
  }

  public List<CLIENTE> obterTodos(){
      return jdbcTemplate.query(SELECT_ALL, new RowMapper<CLIENTE>() {
          @Override
          public CLIENTE mapRow(ResultSet rs, int rowNum) throws SQLException {
              Long id = rs.getLong("id");
              String nome = rs.getString("nome");
              return new CLIENTE(nome, id);
          }
      });
  }


}

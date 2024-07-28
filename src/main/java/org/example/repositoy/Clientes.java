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
   private static String UPDATE = "update CLIENTE set nome = ? where id = ?";
   private static String DELETE = "delete from CLIENTE where id = ?";

  @Autowired
  private  JdbcTemplate jdbcTemplate;
  public CLIENTE inserir(CLIENTE cliente){
      jdbcTemplate.update(INSERT, new Object[]{cliente.getNome()});
      return cliente;
  }

  public CLIENTE atualizar(CLIENTE cliente){
      jdbcTemplate.update(UPDATE, new Object[]{cliente.getNome(), cliente.getId()} );
      return cliente;
  }

  public void deletar(CLIENTE cliente){
      deletar(cliente.getId());
  }

  public void deletar( Long id){
      jdbcTemplate.update(DELETE, new Object[]{id});
  }

  public List<CLIENTE> buscarPorNome(String nome){
      return  jdbcTemplate.query(SELECT_ALL.concat(
              "where nome like ?"), new Object[]{"%"+ nome + "%"}, obterCLIENTEMapper());
  }


  public List<CLIENTE> obterTodos(){
      return jdbcTemplate.query(SELECT_ALL, obterCLIENTEMapper());
  }

    private static RowMapper<CLIENTE> obterCLIENTEMapper() {
        return new RowMapper<CLIENTE>() {
            @Override
            public CLIENTE mapRow(ResultSet resultSet, int i) throws SQLException {
                Long id = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                return new CLIENTE(id, nome);
            }
        };
    }


}

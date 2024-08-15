package org.example;


import org.example.model.CLIENTE;
import org.example.model.PEDIDO;
import org.example.repositoy.Clientes;
import org.example.repositoy.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes, @Autowired Pedidos pedidos){

        return args -> {
           CLIENTE fulano = new CLIENTE("pedro");
           clientes.save(fulano);

            PEDIDO p = new PEDIDO();
            p.setCliente(fulano);
            p.setDataPedido(LocalDate.now());
            p.setTotal(BigDecimal.valueOf(100));
            pedidos.save(p);

           CLIENTE cliente = clientes.findClienteFetchPedidos(fulano.getId());
            System.out.println(cliente);
            System.out.println(cliente.getPedidos());


          /* List<CLIENTE> todosCliente = clientes.findAll();
            todosCliente.forEach(System.out::println);

            System.out.println("Atualizando Clientes");
            todosCliente.forEach(c -> {
                c.setNome(c.getNome() + " new ");
                clientes.save(c);
            });

            todosCliente = clientes.findAll();
            todosCliente.forEach(System.out::println);
            List<CLIENTE> result = clientes.encontrarPorNome("pedro");
            result.forEach(System.out::println);

           System.out.println("deletando clientes");
            clientes.findAll().forEach(c -> {
                clientes.delete(c);
            });

            todosCliente = clientes.findAll();
            if(todosCliente.isEmpty()){
                System.out.println("Nenhum cliente encontrado");
            }else{
                todosCliente.forEach(System.out::println);
            } */


        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}

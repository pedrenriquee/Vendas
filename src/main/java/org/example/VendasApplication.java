package org.example;



import org.example.model.CLIENTE;
import org.example.repositoy.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){

        return args -> {
            CLIENTE cliente = new CLIENTE();
            cliente.setNome("pedro");
            clientes.salvar(cliente);

            List<CLIENTE> TodosClientes = clientes.obterTodos();
            TodosClientes.forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}

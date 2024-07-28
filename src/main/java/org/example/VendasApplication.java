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
            clientes.inserir(new CLIENTE("pedro"));
            clientes.inserir(new CLIENTE("henrique"));

            List<CLIENTE> todosCliente = clientes.obterTodos();
            todosCliente.forEach(System.out::println);

            todosCliente.forEach(c ->{
                c.setNome(c.getNome() + " atualizado");
                clientes.atualizar(c);
            });

            todosCliente = clientes.obterTodos();
            todosCliente.forEach(System.out::println);

            //bug
           // System.out.println("Buscando clientes");
           // clientes.buscarPorNome("henri").forEach(System.out::println);

            System.out.println("deletando clientes");
            clientes.obterTodos().forEach(c -> {
                clientes.deletar(c);
            });

            todosCliente = clientes.obterTodos();
            if(todosCliente.isEmpty()){
                System.out.println("Nenhum cliente encontrado");
            }else{
                todosCliente.forEach(System.out::println);
            }


        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}

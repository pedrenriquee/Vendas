package org.example.controller;

import org.example.model.CLIENTE;
import org.example.repositoy.Clientes;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private Clientes clientes;

    public ClienteController(Clientes clientes) {
        this.clientes = clientes;
    }

    @GetMapping("{id}")
    public ResponseEntity getClienteById(@PathVariable Long id){
       Optional<CLIENTE> cliente = clientes.findById(id);

       if(cliente.isPresent()){
           return ResponseEntity.ok( cliente.get() );
       }
       return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CLIENTE cliente){
       CLIENTE clienteSalvo = clientes.save(cliente);
       return ResponseEntity.ok(clienteSalvo);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id){
        Optional<CLIENTE> cliente= clientes.findById(id);

        if(cliente.isPresent()){
            clientes.delete( cliente.get() );
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();

    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody CLIENTE cliente){
        return clientes.findById(id).map(clienteExistente ->{
            cliente.setId(clienteExistente.getId());
            clientes.save(cliente);
            return ResponseEntity.noContent().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity find(CLIENTE filtro){

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase().
                withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filtro, matcher);
        List<CLIENTE> lista = clientes.findAll(example);
        return ResponseEntity.ok(lista);
    }




}

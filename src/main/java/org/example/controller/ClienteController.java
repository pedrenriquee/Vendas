package org.example.controller;

import jakarta.validation.Valid;
import org.example.model.CLIENTE;
import org.example.repositoy.Clientes;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public CLIENTE getClienteById(@PathVariable Long id){
       return clientes.
               findById(id).
               orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                               "Cliente não encontrado"));

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CLIENTE save(@RequestBody @Valid CLIENTE cliente){
       return clientes.save(cliente);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        clientes.findById(id).map(cliente ->{
            clientes.delete(cliente);
                return cliente;})
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cliente não encontrado") );
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody @Valid CLIENTE cliente){
         clientes.findById(id).map(clienteExistente ->{
            cliente.setId(clienteExistente.getId());
                clientes.save(cliente);
                    return clienteExistente;
        }).orElseThrow(() ->
                 new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Cliente não encontrado"));
    }

    @GetMapping
    public List<CLIENTE> find(CLIENTE filtro){
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().
                    withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);
            return clientes.findAll(example);

    }

}

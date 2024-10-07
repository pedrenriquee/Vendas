package org.example.controller;

import jakarta.validation.Valid;
import org.example.model.CLIENTE;
import org.example.model.PRODUTO;
import org.example.repositoy.Produtos;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private Produtos produtos;

    public ProdutoController(Produtos produtos) {
        this.produtos = produtos;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PRODUTO salvar(@RequestBody @Valid PRODUTO produto){
        return produtos.save(produto);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody @Valid PRODUTO produto){

        produtos.findById(id).map(p -> {
            produto.setId(produto.getId());
                produtos.save(produto);
                    return produto;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "produto não encotrado!"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        produtos.findById(id).map(p -> {
            produtos.delete(p);
                return p;
        }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "produto não encontrado!"));
    }

    @GetMapping("{id}")
    public PRODUTO GetByid(@PathVariable Integer id){
        return produtos.findById(id).
                orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "produto não encontrado"));
    }

    @GetMapping
    public List<PRODUTO> find(PRODUTO filtro){
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().
                withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);
        return produtos.findAll(example);
    }
}

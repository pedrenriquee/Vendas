package org.example.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "CLIENTE")
public class CLIENTE {

    @Id //define a pk
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name ="nome", length = 100)
    private String nome;

    @Column(name="cpf", length = 11)
    private String cpf;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private Set<PEDIDO> pedidos;


    public CLIENTE() {
    }

    public Set<PEDIDO> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<PEDIDO> pedidos) {
        this.pedidos = pedidos;
    }

    public CLIENTE(Long id, String nome)  {
        this.id = id;
        this.nome = nome;

    }

    public CLIENTE(String nome) {

        this.nome = nome;
    }

    // Getters e Setters
    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "CLIENTE{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}


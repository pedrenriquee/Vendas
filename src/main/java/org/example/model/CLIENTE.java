package org.example.model;


import jakarta.persistence.*;

@Entity
@Table(name = "CLIENTE")
public class CLIENTE {

    @Id //define a pk
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name ="nome", length = 100)
    private String nome;

    public CLIENTE() {
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

    @Override
    public String toString() {
        return "CLIENTE{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}


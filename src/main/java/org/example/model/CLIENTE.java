package org.example.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
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


    public CLIENTE(Long id, String nome)  {
        this.id = id;
        this.nome = nome;
    }

}


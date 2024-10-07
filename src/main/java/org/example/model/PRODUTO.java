package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="PRODUTO")
public class PRODUTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="descricao")
    @NotEmpty(message = "Campo descrição é obrigatória")
    private String descricao;

    @Column(name="preco_unitario")
    @NotNull(message = "Campo preço é obrigatório")
    private BigDecimal preco;


}

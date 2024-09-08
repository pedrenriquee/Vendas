package org.example.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="item_pedido")
public class ITEMPEDIDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="pedido_id")
    private PEDIDO pedido;

    @ManyToOne
    @JoinColumn(name="produto_id")
    private PRODUTO produto;

    @Column(name = "quantidade")
    private Integer quantidade;

}

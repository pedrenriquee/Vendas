package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="PEDIDO")
public class PEDIDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="CLIENTE_id")
    private CLIENTE cliente;

    @Column(name="data_pedido")
    private LocalDate dataPedido;

    @Column(name = "total", precision = 20, scale = 2)
    private BigDecimal total;


    @OneToMany(mappedBy = "pedido")
    private List<ITEMPEDIDO> itens;


}

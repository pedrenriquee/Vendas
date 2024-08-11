package org.example.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


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

    @Column(name="total", length = 20, precision = 2)
    private BigDecimal total;

    @OneToMany(mappedBy = "pedido")
    private List<ITEMPEDIDO> itens;

    public List<ITEMPEDIDO> getItens() {
        return itens;
    }

    public void setItens(List<ITEMPEDIDO> itens) {
        this.itens = itens;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CLIENTE getCliente() {
        return cliente;
    }

    public void setCliente(CLIENTE cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}

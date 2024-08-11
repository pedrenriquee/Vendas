package org.example.model;


import jakarta.persistence.*;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PEDIDO getPedido() {
        return pedido;
    }

    public void setPedido(PEDIDO pedido) {
        this.pedido = pedido;
    }

    public PRODUTO getProduto() {
        return produto;
    }

    public void setProduto(PRODUTO produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}

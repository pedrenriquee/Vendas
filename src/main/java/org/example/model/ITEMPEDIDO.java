package org.example.model;

public class ITEMPEDIDO {
    private Integer id;
    private PEDIDO pedido;
    private PRODUTO produto;
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

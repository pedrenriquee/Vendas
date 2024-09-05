package org.example.dto;


import java.math.BigDecimal;
import java.util.List;

public class PedidoDTO {
    private Long cliente;
    private BigDecimal total;
    private List<ItemPedidoDTO> items;

}

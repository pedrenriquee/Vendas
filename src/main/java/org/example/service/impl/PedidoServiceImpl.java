package org.example.service.impl;


import lombok.RequiredArgsConstructor;
import org.example.dto.ItemPedidoDTO;
import org.example.dto.PedidoDTO;
import org.example.exception.RegraNegocioException;
import org.example.model.CLIENTE;
import org.example.model.ITEMPEDIDO;
import org.example.model.PEDIDO;
import org.example.model.PRODUTO;
import org.example.repositoy.Clientes;
import org.example.repositoy.ItensPedido;
import org.example.repositoy.Pedidos;
import org.example.repositoy.Produtos;
import org.example.service.PedidoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {
    private final Pedidos pedidos;
    private final Clientes clientesRepository;
    private final Produtos produtosRepository;
    private final ItensPedido itensPedidoRepository;

    @Override
    @Transactional
    public PEDIDO salvar(PedidoDTO dto) {
        Long idCliente = dto.getCliente();
        CLIENTE cliente = clientesRepository.
               findById(idCliente).
                    orElseThrow(() ->
                       new RegraNegocioException("Codigo de cliente invalido"+ idCliente));

        PEDIDO pedido = new PEDIDO();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);

        List<ITEMPEDIDO> itemsPedido = converterItems(pedido,dto.getItems());
        pedidos.save(pedido);
        itensPedidoRepository.saveAll(itemsPedido);
        pedido.setItens(itemsPedido);
        return pedido;
    }
    public List<ITEMPEDIDO> converterItems(PEDIDO pedido, List<ItemPedidoDTO> items){
        if(items.isEmpty()){
            throw new RegraNegocioException("Não é possivel realizar um pedido sem items.");
        }
        return items.stream().map(dto -> {
            Integer idProduto = dto.getProduto();
            PRODUTO produto = produtosRepository.findById(idProduto).orElseThrow(() ->
                    new RegraNegocioException("Codigo de Produto invalido: "+ idProduto));

            ITEMPEDIDO itempedido = new ITEMPEDIDO();
            itempedido.setQuantidade(dto.getQuantidade());
            itempedido.setPedido(pedido);
            itempedido.setProduto(produto);
            return itempedido;

        }).collect(Collectors.toList());
    }
}

package br.com.juliomartins.VassCommerce.model.pedido;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private Long id;
    private Long idCliente;
    private Date dataCadastro;
    private BigDecimal valorTotal;
    private PedidoStatus pedidoStatus;
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido(long id, Date dataCadastro, PedidoStatus pedidoStatus) {
        this.id = id;
        this.dataCadastro = dataCadastro;
        this.pedidoStatus = pedidoStatus;
        this.valorTotal = BigDecimal.ZERO;
    }

    // Metodo para adicionar item
    public void adicionarItem(ItemPedido item) {
        itens.add(item);
        recalcularValorTotal();
    }

    // Metodo para recalcular o total
    public void recalcularValorTotal() {
        this.valorTotal = itens.stream()
                .map(ItemPedido::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public PedidoStatus getPedidoStatus() {
        return pedidoStatus;
    }
    public void setPedidoStatus(PedidoStatus pedidoStatus) {
        this.pedidoStatus = pedidoStatus;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }
    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
        recalcularValorTotal();
    }
}

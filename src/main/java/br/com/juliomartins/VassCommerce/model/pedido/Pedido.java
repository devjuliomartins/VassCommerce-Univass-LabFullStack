package br.com.juliomartins.VassCommerce.model.pedido;

import java.math.BigDecimal;
import java.util.Date;

public class Pedido {
    private long id;
    private Date dataCadastro;
    private BigDecimal valorTotal;
    private PedidoStatus pedidoStatus;
    private ItemPedido itemPedido;

    public Pedido(long id, Date dataCadastro, BigDecimal valorTotal, PedidoStatus pedidoStatus, ItemPedido itemPedido) {
        this.id = id;
        this.dataCadastro = dataCadastro;
        this.valorTotal = valorTotal;
        this.pedidoStatus = pedidoStatus;
        this.itemPedido = itemPedido;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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

    public ItemPedido getItemPedido() {
        return itemPedido;
    }
    public void setItemPedido(ItemPedido itemPedido) {
        this.itemPedido = itemPedido;
    }
}

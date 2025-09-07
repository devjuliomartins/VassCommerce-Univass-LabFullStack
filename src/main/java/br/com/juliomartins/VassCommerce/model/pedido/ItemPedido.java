package br.com.juliomartins.VassCommerce.model.pedido;

import br.com.juliomartins.VassCommerce.model.Produto;

import java.math.BigDecimal;

public class ItemPedido {
    private long id;
    private int quantidade;
    private BigDecimal valorUnitario;
    private Produto produto;

    public ItemPedido(long id, int quantidade, BigDecimal valorUnitario, Produto produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.produto = produto;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }
    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}

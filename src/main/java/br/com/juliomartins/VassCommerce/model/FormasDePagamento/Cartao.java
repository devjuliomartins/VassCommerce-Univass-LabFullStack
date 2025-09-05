package br.com.juliomartins.VassCommerce.model.FormasDePagamento;

import java.util.Date;

public class Cartao extends FormasDePagamento {
    private TipoCartao tipoCartao;

    public Cartao(long id, Date dataCricao, boolean exluido, TipoCartao tipoCartao) {
        super(id, dataCricao, exluido);
        this.tipoCartao = tipoCartao;
    }

    public TipoCartao getTipoCartao() {
        return tipoCartao;
    }
    public void setTipoCartao(TipoCartao tipoCartao) {
        this.tipoCartao = tipoCartao;
    }
}
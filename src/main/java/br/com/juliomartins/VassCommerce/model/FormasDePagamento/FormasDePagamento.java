package br.com.juliomartins.VassCommerce.model.FormasDePagamento;

import java.util.Date;

public class FormasDePagamento {
    private long id;
    private Date dataCriacao;
    private boolean excluido;

    public FormasDePagamento (long id, Date dataCriacao, boolean excluido) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.excluido = excluido;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public boolean isExcluido() {
        return excluido;
    }
    public void setExcluido(boolean excluido) {
        this.excluido = excluido;
    }
}

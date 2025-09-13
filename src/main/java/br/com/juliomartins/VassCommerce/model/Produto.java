package br.com.juliomartins.VassCommerce.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "produto")
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String descricao;
    private String fotoUrl;

    @CreationTimestamp
    private Date dataCadastro;

    @UpdateTimestamp
    private Date dataUltimaAtualizacao;

    @Column(name = "valor_unitario")
    private BigDecimal valorUnitario;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    public Produto() {}

    public Produto(long id, String nome, String descricao, String fotoUrl,
                   Date dataCadastro, Date dataUltimaAtualizacao, BigDecimal valorUnitario, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.fotoUrl = fotoUrl;
        this.dataCadastro = dataCadastro;
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
        this.valorUnitario = valorUnitario;
        this.categoria = categoria;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }
    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }
    public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }
    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Categoria getIdCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
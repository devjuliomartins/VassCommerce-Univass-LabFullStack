package br.com.juliomartins.VassCommerce.model;

import jakarta.persistence.*;

@Entity(name = "categoria")
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String imagemSimboloUrl;
    private String nome;
    private String descricao;

    public Categoria() {}

    public Categoria(Integer id, String imagemSimboloUrl, String nome, String descricao) {
        this.id = id;
        this.imagemSimboloUrl = imagemSimboloUrl;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getImagemSimboloUrl() {
        return imagemSimboloUrl;
    }
    public void setImagemSimboloUrl(String imagemSimboloUrl) {
        this.imagemSimboloUrl = imagemSimboloUrl;
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
}
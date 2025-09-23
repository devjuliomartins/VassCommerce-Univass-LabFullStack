package br.com.juliomartins.VassCommerce.model.endereco;

public class Cidade {
    private long id;
    private String nome;
    private Estado estado;

    public Cidade(long id, String nome, Estado estado) {
        this.id = id;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}

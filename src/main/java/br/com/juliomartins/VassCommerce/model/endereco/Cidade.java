package br.com.juliomartins.VassCommerce.model.endereco;

public class Cidade {
    private long id;
    private String nome;

    public Cidade(long id, String nome) {
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
}

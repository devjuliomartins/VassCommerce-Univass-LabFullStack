package br.com.juliomartins.VassCommerce.dtos;

public class ProdutoResponse {

    private long id;
    private String nome;
    private Float valorUnitario;
    private Long idCategoria;

    public ProdutoResponse() {}

    public ProdutoResponse(long id, String nome, Float valorUnitario, Long idCategoria) {
        this.id = id;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.idCategoria = idCategoria;
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

    public Float getValorUnitario() {
        return valorUnitario;
    }
    public void setValorUnitario(Float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }
    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }
}

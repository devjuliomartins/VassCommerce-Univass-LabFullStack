package br.com.juliomartins.VassCommerce.model;

import br.com.juliomartins.VassCommerce.model.FormasDePagamento.FormasDePagamento;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Cliente extends Usuario {
    private String fotoUrl;
    private LocalDate dataNascimento;
    private String cpf;
    private List<FormasDePagamento> formasDePagamento;

    public Cliente(int id, String nomeCompleto, String email, String senha, Date dataCadastro, Date dataUltimaAtualizacao, String fotoUrl, LocalDate dataNascimento, String cpf, List<FormasDePagamento> formasDePagamentos) {
        super(id, nomeCompleto, email, senha, dataCadastro, dataUltimaAtualizacao, fotoUrl);
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.formasDePagamento = formasDePagamentos;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<FormasDePagamento> getFormasDePagamento() {
        return formasDePagamento;
    }
}

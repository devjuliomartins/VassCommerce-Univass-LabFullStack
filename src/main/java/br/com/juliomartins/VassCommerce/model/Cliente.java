package br.com.juliomartins.VassCommerce.model;

import java.time.LocalDate;
import java.util.Date;

public class Cliente extends Usuario {
    private String fotoUrl;
    private LocalDate dataNascimento;
    private String cpf;

    public Cliente(int id, String nomeCompleto, String email, String senha, Date dataCadastro, Date dataUltimaAtualizacao, String fotoUrl, LocalDate dataNascimento, String cpf) {
        super(id, nomeCompleto, email, senha, dataCadastro, dataUltimaAtualizacao, fotoUrl);
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
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
}

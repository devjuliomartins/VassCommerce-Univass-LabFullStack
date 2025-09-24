package br.com.juliomartins.VassCommerce.mapper;

import br.com.juliomartins.VassCommerce.dtos.ProdutoCreateRequest;
import br.com.juliomartins.VassCommerce.dtos.ProdutoResponse;
import br.com.juliomartins.VassCommerce.model.Produto;

import java.util.Date;

public class ProdutoMapper {

    // Converte DTO de criação para entidade
    public static Produto toEntity(ProdutoCreateRequest dto, long novoId) {
        Produto produto = new Produto();
        produto.setId(novoId);
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setFotoUrl(dto.getFotoUrl());
        produto.setValorUnitario(dto.getValorUnitario());
        produto.setIdCategoria(dto.getIdCategoria());
        produto.setDataCadastro(new Date());
        produto.setDataUltimaAtualizacao(new Date());
        return produto;
    }

    // Converte entidade para DTO de resposta
    public static ProdutoResponse toResponse(Produto produto) {
        return new ProdutoResponse(
                produto.getId(),
                produto.getNome(),
                produto.getValorUnitario(),
                produto.getIdCategoria()
        );
    }
}

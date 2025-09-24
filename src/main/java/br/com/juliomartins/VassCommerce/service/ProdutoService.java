package br.com.juliomartins.VassCommerce.service;

import br.com.juliomartins.VassCommerce.model.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProdutoService {

    private final List<Produto> produtos;
    private final AtomicLong sequence = new AtomicLong(1);


    public ProdutoService() {
        produtos = new ArrayList<>();
        produtos.add(new Produto(
                1,
                "Notebook",
                "Notebook gamer 16GB RAM",
                "http://exemplo.com/notebook.jpg",
                new Date(), new Date(), 4500.00F, 1L
        ));

        produtos.add(new Produto(
                2,
                "Mouse Gamer",
                "Mouse com 7200 DPI",
                "http://exemplo.com/mouse.jpg",
                new Date(), new Date(), 4500.00F, 1L
        ));
    }

    public long gerarNovoId() {
        return sequence.getAndIncrement();
    }

    // Buscar Produto pelo ID
    public Produto buscarProdutoId(long id) {
        return produtos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Este Produto não existe! Id:" + id));
    }

    // Listar todos Produtos por nome e faixa de valor
    public List<Produto> listarPorNomeValor(String nome, Float valorMinimo, Float valorMaximo) {
        return produtos.stream()
                .filter(p -> nome == null || p.getNome().toLowerCase().contains(nome.toLowerCase()))
                .filter(p -> valorMinimo == null || p.getValorUnitario() >= valorMinimo)
                .filter(p -> valorMaximo == null || p.getValorUnitario() <= valorMaximo)
                .toList();
    }

    // Listar todos Produtos da Categoria
    public List<Produto> listarPorCategoria(Long categoriaId, String nome, Float valorMinimo, Float valorMaximo) {
        return produtos.stream()
                .filter(p -> p.getIdCategoria().equals(categoriaId))
                .filter(p -> nome == null || p.getNome().toLowerCase().contains(nome.toLowerCase()))
                .filter(p -> valorMinimo == null || p.getValorUnitario() >= valorMinimo)
                .filter(p -> valorMaximo == null || p.getValorUnitario() <= valorMaximo)
                .toList();
    }

    // Criar novo Produto
    public Produto create(Produto produto) {
        produto.setId(sequence.getAndIncrement());

        produto.setDataCadastro(new Date());
        produto.setDataUltimaAtualizacao(new Date());

        produtos.add(produto);
        return produto;
    }

    // Atualizar dados do Produto
    public Produto update(Long id, Produto produtoAtualizado) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                // Atualiza os campos permitidos
                p.setNome(produtoAtualizado.getNome());
                p.setDescricao(produtoAtualizado.getDescricao());
                p.setFotoUrl(produtoAtualizado.getFotoUrl());
                p.setValorUnitario(produtoAtualizado.getValorUnitario());
                p.setIdCategoria(produtoAtualizado.getIdCategoria());
                p.setDataUltimaAtualizacao(new Date());

                return p;
            }
        }
        throw new RuntimeException("Não foi possível atualizar: produto com id " + id);
    }

    // excluir cadastro do Produto
    public void delete(long id) {
        boolean removido = produtos.removeIf(p -> p.getId() == id);
        if (!removido) {
            throw new RuntimeException("Produto não encontrado com id: " + id);
        }
    }
}

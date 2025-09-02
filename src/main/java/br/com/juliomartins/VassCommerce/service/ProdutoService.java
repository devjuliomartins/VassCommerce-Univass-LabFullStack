package br.com.juliomartins.VassCommerce.service;

import br.com.juliomartins.VassCommerce.model.Produto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProdutoService {

    private final List<Produto> produtos;

    public ProdutoService() {
        produtos = new ArrayList<>();
        produtos.add(new Produto(
                1,
                "Notebook",
                "Notebook gamer 16GB RAM",
                "http://exemplo.com/notebook.jpg",
                new Date(), new Date(), new BigDecimal("4500.00")
        ));

        produtos.add(new Produto(
                2,
                "Mouse Gamer",
                "Mouse com 7200 DPI",
                "http://exemplo.com/mouse.jpg",
                new Date(), new Date(), new BigDecimal("4500.00")
        ));
    }

    public Produto buscarProdutoId(int id) {
        return produtos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Este Produto não existe! Id:" + id));
    }
}

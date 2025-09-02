package br.com.juliomartins.VassCommerce.controller;

import br.com.juliomartins.VassCommerce.model.Produto;
import br.com.juliomartins.VassCommerce.service.ProdutoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }


//  GET /produto/{id} → Visualizar dados do produto
    @GetMapping("/produto/{id}")
    public Produto buscarProdutoId(@PathVariable int id) {
        return produtoService.buscarProdutoId(id);
    }

//  GET /produto → lista todos os Produtos
    @GetMapping("/produto")
    public List<Produto> listarTodosProdutos() {
        return produtoService.listarTodos();
    }
}

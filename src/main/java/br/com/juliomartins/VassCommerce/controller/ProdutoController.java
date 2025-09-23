package br.com.juliomartins.VassCommerce.controller;

import br.com.juliomartins.VassCommerce.model.Produto;
import br.com.juliomartins.VassCommerce.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // GET /produto?nome=<nomeProduto>&valorMinimo=<valor>&valorMaximo=<valor> → listar Produtos por nome e valor
    @GetMapping(produces = "application/json")
    public List<Produto> listarTodosProdutosFiltrados(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) Float valorMinimo,
            @RequestParam(required = false) Float valorMaximo
    ) {
        return produtoService.listarPorNomeValor(nome, valorMinimo, valorMaximo);
    }

    // POST /produto → criar novo produto
    @PostMapping(consumes = "application/json", produces = "application/json")
    public Produto criarProduto(@RequestBody Produto produto) {
        return produtoService.create(produto);
    }

    // GET /produto/{idProduto} → buscar Produto pro ID
    @GetMapping(value = "/{id}", produces = "application/json")
    public Produto buscarProdutoId(@PathVariable long id) {
        return produtoService.buscarProdutoId(id);
    }

    // PUT /produto/{idProduto} → atualizar dados do Produto
    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public Produto atualizarProduto(@PathVariable long id, @RequestBody Produto produto) {
        return produtoService.update(id, produto);
    }

    // DELETE /produto/{idProduto} →  excluir cadastro do Produto
    @DeleteMapping(value = "/{id}", produces = "application/json")
    public void deletarProduto(@PathVariable long id) {
        produtoService.delete(id);
    }
}

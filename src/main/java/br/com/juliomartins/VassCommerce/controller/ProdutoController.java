package br.com.juliomartins.VassCommerce.controller;

import br.com.juliomartins.VassCommerce.dtos.ProdutoDto;
import br.com.juliomartins.VassCommerce.model.Produto;
import br.com.juliomartins.VassCommerce.repository.CategoriaRepository;
import br.com.juliomartins.VassCommerce.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoRepository repository;
    private CategoriaRepository categoriaRepository;

    public ProdutoController(ProdutoRepository repository, CategoriaRepository categoriaRepository) {
        this.repository = repository;
        this.categoriaRepository = categoriaRepository;

    }

    // POST /produto → Criar Produto
    @PostMapping
    public ResponseEntity save(@RequestBody ProdutoDto dto) {
        var produto = new Produto();
        BeanUtils.copyProperties(dto, produto);

        var categoria = categoriaRepository.findById(dto.getIdCategoria())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        produto.setCategoria(categoria);

        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
    }

    // GET /produto/{id} → Buscar produto pelo ID
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable(value = "id") Long id) {
        Optional<Produto> produto = repository.findById(id);

        if (produto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(produto.get());
    }

    // GET /produto → Listar todos os produtos
    @GetMapping
    public ResponseEntity getAll() {
        List<Produto> listarProdutos = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listarProdutos);
    }

    // PUT /produto/{id} → Atualizar produto
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable(value = "id") Long id, @RequestBody ProdutoDto dto) {
        Optional<Produto> produto = repository.findById(id);

        if (produto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
        }

        var produtoModel = produto.get();
        BeanUtils.copyProperties(dto, produtoModel);
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(produtoModel));
    }

    // DELETE /produto/{id} → Deletar produto
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long id) {
        Optional<Produto> produto = repository.findById(id);

        if (produto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
        }

        repository.delete(produto.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso!");
    }

    // GET /categoria/{idCategoria}/produto → Listagem de todos os produtos da categoria
    @GetMapping("/categoria/{idCategoria}")
    public ResponseEntity listarProdutosCategoria(@PathVariable Long idCategoria) {
        List<Produto> produtos = repository.findByCategoria_Id(idCategoria);
        return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }
}

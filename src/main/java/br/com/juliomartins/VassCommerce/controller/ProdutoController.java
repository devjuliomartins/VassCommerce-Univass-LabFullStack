package br.com.juliomartins.VassCommerce.controller;

import br.com.juliomartins.VassCommerce.dtos.ProdutoDto;
import br.com.juliomartins.VassCommerce.model.Produto;
import br.com.juliomartins.VassCommerce.service.CategoriaService;
import br.com.juliomartins.VassCommerce.service.ProdutoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // GET /produto → listar todos os produtos
    @GetMapping()
    public List<Produto> listarTodosProdutos() {
        return produtoService.listarTodos();
    }
}

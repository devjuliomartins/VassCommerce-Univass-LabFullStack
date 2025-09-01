package br.com.juliomartins.VassCommerce.controller;

import br.com.juliomartins.VassCommerce.model.Categoria;
import br.com.juliomartins.VassCommerce.service.CategoriaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

//  GET /categoria - lista todas categorais
    @GetMapping
    public List<Categoria> listarCategorias(){
        return categoriaService.ListarTodas();
    }
}

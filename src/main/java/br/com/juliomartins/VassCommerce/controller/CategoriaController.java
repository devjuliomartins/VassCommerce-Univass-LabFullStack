package br.com.juliomartins.VassCommerce.controller;

import br.com.juliomartins.VassCommerce.model.Categoria;
import br.com.juliomartins.VassCommerce.service.CategoriaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }


//  GET /categoria - Lista todas Categorais
//  GET /categoria?nome= - Filtragem de lista por nome
    @GetMapping("/categoria")
    public List<Categoria> listarCategorias(@RequestParam(name = "nome",required = false) String nome){
        if (nome != null && !nome.isBlank()) {
            return categoriaService.buscarPorNome(nome);
        }
        return categoriaService.listarTodas();
    }

}

package br.com.juliomartins.VassCommerce.controller;

import br.com.juliomartins.VassCommerce.model.endereco.Cidade;
import br.com.juliomartins.VassCommerce.model.endereco.Estado;
import br.com.juliomartins.VassCommerce.service.EstadoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class EstadoController {

    private final EstadoService estadoService;

    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }


//
    @GetMapping("/estado")
    public List<Estado> listarEstados() {
        return estadoService.todosEstados();
    }
}

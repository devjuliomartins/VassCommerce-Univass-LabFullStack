package br.com.juliomartins.VassCommerce.controller;

import br.com.juliomartins.VassCommerce.model.endereco.Estado;
import br.com.juliomartins.VassCommerce.service.EstadoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    private final EstadoService estadoService;

    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }


    //  GET /estado → Listar todos os Estados
    @GetMapping
    public List<Estado> listarEstados() {
        return estadoService.listarEstados();
    }
}

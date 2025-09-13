//package br.com.juliomartins.VassCommerce.controller;
//
//import br.com.juliomartins.VassCommerce.model.endereco.Cidade;
//import br.com.juliomartins.VassCommerce.model.endereco.Estado;
//import br.com.juliomartins.VassCommerce.service.EstadoService;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping
//public class EstadoController {
//
//    private final EstadoService estadoService;
//
//    public EstadoController(EstadoService estadoService) {
//        this.estadoService = estadoService;
//    }
//
//
////  Get /estado → Listar todos os Estados
//    @GetMapping("/estado")
//    public List<Estado> listarEstados() {
//        return estadoService.todosEstados();
//    }
//
////  Get /estado/{idEstado}/cidade → Listar todas Cidades de um Estado
//    @GetMapping("/estado/{idEstado}/cidade")
//    public List<Cidade> listarCidadesEstado(@PathVariable long idEstado) {
//        return estadoService.todasCidadesEstado(idEstado);
//    }
//
//}

package br.com.juliomartins.VassCommerce.controller;

import br.com.juliomartins.VassCommerce.model.Cliente;
import br.com.juliomartins.VassCommerce.service.ClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

//  GET /cliente/{id} → Visualizar dados do Cliente
    @GetMapping("/cliente/{id}")
    public Cliente VisualizarDadosCliente(@PathVariable int id) {
        return clienteService.dadosCliente(id);
    }
}

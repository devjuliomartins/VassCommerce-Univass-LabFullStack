package br.com.juliomartins.VassCommerce.controller;

import br.com.juliomartins.VassCommerce.model.Cliente;
import br.com.juliomartins.VassCommerce.service.ClienteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


    //  GET /cliente/{id} → Visualizar dados do Cliente
    @GetMapping("/{id}")
    public Cliente visualizarDadosCliente(@PathVariable long id) {
        return clienteService.visualizarDadosCliente(id);
    }

    //  PUT /cliente/{id} → Atualizar dados do Cliente
    @PutMapping("/{id}")
    public Cliente atualizarDadosClienteup(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.update(id, cliente);
    }
}

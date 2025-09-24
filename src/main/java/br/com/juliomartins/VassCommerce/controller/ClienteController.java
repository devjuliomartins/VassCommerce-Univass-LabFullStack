package br.com.juliomartins.VassCommerce.controller;

import br.com.juliomartins.VassCommerce.model.Cliente;
import br.com.juliomartins.VassCommerce.model.pedido.Pedido;
import br.com.juliomartins.VassCommerce.service.ClienteService;
import br.com.juliomartins.VassCommerce.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;
    private final PedidoService pedidoService;

    public ClienteController(ClienteService clienteService, PedidoService pedidoService) {
        this.clienteService = clienteService;
        this.pedidoService = pedidoService;
    }


    //  GET /cliente/{id} → Visualizar dados do Cliente
    @GetMapping(value = "/{id}", produces = "application/json")
    public Cliente visualizarDadosCliente(@PathVariable long id) {
        return clienteService.visualizarDadosCliente(id);
    }

    //  PUT /cliente/{id} → Atualizar dados do Cliente
    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public Cliente atualizarDadosClienteup(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.update(id, cliente);
    }

    //  DELETE /cliente/{id} → Excluir dados do Cliente
    @DeleteMapping(value = "/{id}", produces = "application/json")
    public void deletarCliente(@PathVariable Long id) {
        clienteService.delete(id);
    }

    //  GET /cliente/{idCliente}/pedido → Visualizar Pedidos do cliente
    @GetMapping(value = "/{idCliente}/pedido", produces = "application/json")
    public List<Pedido> listarPedidos(
            @PathVariable Long idCliente,
            @RequestParam(required = false) String datainicio,
            @RequestParam(required = false) String datafinal
    ) {
        if (datainicio != null && datafinal != null) {
            try {
                Date inicio = new Date(Long.parseLong(datainicio));
                Date fim = new Date(Long.parseLong(datafinal));
                return pedidoService.listarPedidosPorPeriodo(idCliente, inicio, fim);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Datas devem ser em timestamp (ms)");
            }
        }
        return pedidoService.listarPedidosPorCliente(idCliente);
    }
}

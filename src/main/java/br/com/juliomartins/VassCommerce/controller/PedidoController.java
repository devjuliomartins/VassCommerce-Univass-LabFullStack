package br.com.juliomartins.VassCommerce.controller;

import br.com.juliomartins.VassCommerce.model.pedido.Pedido;
import br.com.juliomartins.VassCommerce.service.PedidoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }


    //  POST /pedido/{idCliente} → Cadastrar Pedido do cliente
    @PostMapping(value = "/{idCliente}", consumes = "application/json", produces = "application/json")
    public Pedido cadastrarPedido(@PathVariable Long idCliente, @RequestBody Pedido pedido) {
        return pedidoService.cadastrarPedido(idCliente, pedido);
    }

}


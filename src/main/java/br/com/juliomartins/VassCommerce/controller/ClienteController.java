package br.com.juliomartins.VassCommerce.controller;

import br.com.juliomartins.VassCommerce.model.Cliente;
import br.com.juliomartins.VassCommerce.model.formasdepagamento.Cartao;
import br.com.juliomartins.VassCommerce.model.pedido.Pedido;
import br.com.juliomartins.VassCommerce.service.CartaoService;
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
    private final CartaoService cartaoService;

    public ClienteController(ClienteService clienteService, PedidoService pedidoService, CartaoService cartaoService) {
        this.clienteService = clienteService;
        this.pedidoService = pedidoService;
        this.cartaoService = cartaoService;
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

    //  GET /cliente/{idCliente}/formas-de-pagamento → Listar formas-de-pagamento do cliente
    @GetMapping(value = "/{idCliente}/formas-de-pagamento", produces = "application/json")
    public List<Cartao> listarFormasDePagamento(@PathVariable Long idCliente) {
        return cartaoService.listarPorCliente(idCliente);
    }

    //  POST /cliente/{idCliente}/formas-de-pagamento → Criar nova formas-de-pagamento
    @PostMapping(value = "/{idCliente}/formas-de-pagamento", consumes = "application/json", produces = "application/json")
    public Cartao adicionarFormaDePagamento(@PathVariable Long idCliente, @RequestBody Cartao cartao) {
        return cartaoService.adicionarCartao(idCliente, cartao);
    }

    //  PUT /cliente/{idCliente}/formas-de-pagamento → Atualizar formas-de-pagamento do cliente
    @PutMapping(value = "/{idCliente}/formas-de-pagamento/{idFormaPagamento}", consumes = "application/json", produces = "application/json")
    public Cartao atualizarFormaDePagamento(
            @PathVariable Long idCliente,
            @PathVariable Long idFormaPagamento,
            @RequestBody Cartao cartao
    ) {
        return cartaoService.atualizarCartao(idCliente, idFormaPagamento, cartao);
    }

}

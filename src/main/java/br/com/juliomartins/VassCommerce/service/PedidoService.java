package br.com.juliomartins.VassCommerce.service;

import br.com.juliomartins.VassCommerce.model.Cliente;
import br.com.juliomartins.VassCommerce.model.pedido.Pedido;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PedidoService {

    private final List<Cliente> cliente;

    public PedidoService(ClienteService clienteService) {
        this.cliente = clienteService.getCliente();
    }


    public Pedido listarPedidosCliente(@RequestParam long id) {
        return cliente.stream()
                .filter(c -> c.getId() == id)
                .map(Cliente::getPedido)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Nenhum Pedido referente a este Cliente encontrado."));
    }
}

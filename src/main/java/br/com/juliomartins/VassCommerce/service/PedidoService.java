package br.com.juliomartins.VassCommerce.service;

import br.com.juliomartins.VassCommerce.model.pedido.Pedido;
import br.com.juliomartins.VassCommerce.model.pedido.PedidoStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    private final List<Pedido> pedidos = new ArrayList<>();

    public Pedido cadastrarPedido(Long idCliente, Pedido pedido) {
        long novoId = pedidos.stream().mapToLong(Pedido::getId).max().orElse(0L) + 1;

        pedido.setId(novoId);
        pedido.setIdCliente(idCliente);
        pedido.setDataCadastro(new Date());
        pedido.setPedidoStatus(PedidoStatus.AGUARDANDO_PAGAMENTO);

        // recalcula valor total com base nos itens
        pedido.recalcularValorTotal();

        pedidos.add(pedido);
        return pedido;
    }

    public List<Pedido> listarPedidosPorCliente(Long idCliente) {
        return pedidos;
    }

    public List<Pedido> listarPedidosPorPeriodo(Long idCliente, Date inicio, Date fim) {
        return pedidos.stream()
                .filter(p -> !p.getDataCadastro().before(inicio) && !p.getDataCadastro().after(fim))
                .collect(Collectors.toList());
    }
}

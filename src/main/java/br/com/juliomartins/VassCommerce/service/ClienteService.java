package br.com.juliomartins.VassCommerce.service;

import br.com.juliomartins.VassCommerce.model.Cliente;
import br.com.juliomartins.VassCommerce.model.Produto;
import br.com.juliomartins.VassCommerce.model.endereco.Cidade;
import br.com.juliomartins.VassCommerce.model.endereco.Endereco;
import br.com.juliomartins.VassCommerce.model.endereco.Estado;
import br.com.juliomartins.VassCommerce.model.formasdepagamento.Cartao;
import br.com.juliomartins.VassCommerce.model.formasdepagamento.FormasDePagamento;
import br.com.juliomartins.VassCommerce.model.formasdepagamento.TipoCartao;
import br.com.juliomartins.VassCommerce.model.pedido.ItemPedido;
import br.com.juliomartins.VassCommerce.model.pedido.Pedido;
import br.com.juliomartins.VassCommerce.model.pedido.PedidoStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Service
public class ClienteService {

    private final List<Cliente> cliente = new ArrayList<>();

    LocalDate dataNascimento = LocalDate.of(2005, 3, 3);
    public ClienteService() {
        List<FormasDePagamento> formasDePagamentos = new ArrayList<>();
        formasDePagamentos.add(new Cartao(123, new Date(), false, TipoCartao.CREDITO));
        formasDePagamentos.add(new Cartao(122, new Date(), false, TipoCartao.DEBITO));

        Estado rj = new Estado(1, "RJ", "Rio de Janeiro");
        Cidade rioDeJaneiro = new Cidade(1, "Valença", rj);

        Endereco endereco = new Endereco(1, "Rua A", 123, "01000-000", "", "11999999999",
                "Centro", new Date(), new Date(), rioDeJaneiro);


        ProdutoService produtoService = new ProdutoService();
        Produto notebook = produtoService.buscarProdutoId(1);
        ItemPedido itemPedido1 = new ItemPedido(1, 1, notebook.getValorUnitario(), notebook);
        Pedido pedido1 = new Pedido(1, new Date(),
                itemPedido1.getValorUnitario().multiply(new BigDecimal(itemPedido1.getQuantidade())),
                PedidoStatus.AGUARDANDO_PAGAMENTO, itemPedido1);

        cliente.add(new Cliente(
                1,
                "Julio Fernando",
                "julio@gmail.com",
                "1234",
                new Date(), new Date(),
                "",
                dataNascimento,
                "1234567",
                formasDePagamentos,
                endereco,
                pedido1
        ));
    }

    // Visualizar dados do Cliente pelo ID
    public Cliente dadosCliente(long id) {
        return cliente.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Listar todas as formas de pagamento pelo ID do Cliente
    public List<FormasDePagamento> formasDePagamentosCliente(@RequestParam long id) {
        return cliente.stream()
                .filter(c -> c.getId() == id)
                .map(Cliente::getFormasDePagamento)
                .findFirst()
                .orElse(Collections.emptyList());
    }

    // Busca dados de Endereço do Cliente
    public Endereco listarEnderecoCliente(long id) {
        return cliente.stream()
                .filter(c -> c.getId() == id)
                .map(Cliente::getEndereco)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado"));
    }

    public List<Cliente> getCliente() {
        return cliente;
    }
}

package br.com.juliomartins.VassCommerce.service;

import br.com.juliomartins.VassCommerce.model.Cliente;
import br.com.juliomartins.VassCommerce.model.Endereco.Cidade;
import br.com.juliomartins.VassCommerce.model.Endereco.Endereco;
import br.com.juliomartins.VassCommerce.model.Endereco.Estado;
import br.com.juliomartins.VassCommerce.model.FormasDePagamento.Cartao;
import br.com.juliomartins.VassCommerce.model.FormasDePagamento.FormasDePagamento;
import br.com.juliomartins.VassCommerce.model.FormasDePagamento.TipoCartao;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
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
                endereco
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
}

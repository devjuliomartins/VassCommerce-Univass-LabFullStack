package br.com.juliomartins.VassCommerce.service;

import br.com.juliomartins.VassCommerce.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClienteService {

    private final List<Cliente> cliente = new ArrayList<>();

    public ClienteService() {
        cliente.add(new Cliente(
                1L, "123.456.789-12", "https://exemplo.com/foto-julio.jpg",
                new GregorianCalendar(2005, Calendar.MARCH, 3).getTime()));

        cliente.add(new Cliente(
                2L, "123.321.123-45", "https://exemplo.com/foto-Felipe.jpg",
                new GregorianCalendar(2005, Calendar.MARCH, 3).getTime()));
    }

    // Visualizar dados do Cliente pelo ID
    public Cliente visualizarDadosCliente(long id) {
        return cliente.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Atualizar dados do Cliente
    public Cliente update(Long id, Cliente clienteAtualizado) {
        return cliente.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .map(c -> {
                    c.setCpf(clienteAtualizado.getCpf());
                    c.setFotoUrl(clienteAtualizado.getFotoUrl());
                    c.setDataNascimento(clienteAtualizado.getDataNascimento());
                    return c;
                })
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com id: " + id));
    }

    // Deletar Cliente
    public void delete(Long id) {
        boolean removido = cliente.removeIf(c -> c.getId().equals(id));
        if (!removido) {
            throw new RuntimeException("Cliente não encontrado com id: " + id);
        }
    }
}

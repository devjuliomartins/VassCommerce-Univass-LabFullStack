package br.com.juliomartins.VassCommerce.service;

import br.com.juliomartins.VassCommerce.model.formasdepagamento.Cartao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class CartaoService {
    private final List<Cartao> cartoes = new ArrayList<>();

    public CartaoService() {
        cartoes.add(new Cartao(1L, 1L, 1, new Date(), false));
        cartoes.add(new Cartao(2L, 2L, 2, new Date(), false));
        cartoes.add(new Cartao(3L, 1L, 2, new Date(), false));
    }

    public List<Cartao> listarPorCliente(Long idCliente) {
        return cartoes.stream()
                .filter(c -> Objects.equals(c.getIdCliente(), idCliente))
                .filter(c -> Boolean.FALSE.equals(c.getExcluido()))
                .toList();
    }

}

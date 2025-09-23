package br.com.juliomartins.VassCommerce.service;

import br.com.juliomartins.VassCommerce.model.formasdepagamento.TipoCartao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoCartaoService {

    private final List<TipoCartao> tiposCartoes = new ArrayList<>();

    public TipoCartaoService() {
        tiposCartoes.add(new TipoCartao(1));
        tiposCartoes.add(new TipoCartao(2));
    }

    public List<TipoCartao> listarTodos() {
        return tiposCartoes.stream().toList();
    }
}

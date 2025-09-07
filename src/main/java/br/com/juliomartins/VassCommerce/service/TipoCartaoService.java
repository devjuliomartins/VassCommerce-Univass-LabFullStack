package br.com.juliomartins.VassCommerce.service;

import br.com.juliomartins.VassCommerce.model.formasdepagamento.TipoCartao;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TipoCartaoService {

    // Lista todos os tipos de Cartão
    public List<TipoCartao> todosTipoCartao() {
        return Arrays.asList(TipoCartao.values());
    }
}

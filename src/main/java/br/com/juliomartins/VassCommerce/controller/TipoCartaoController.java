package br.com.juliomartins.VassCommerce.controller;

import br.com.juliomartins.VassCommerce.model.formasdepagamento.TipoCartao;
import br.com.juliomartins.VassCommerce.service.TipoCartaoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipo-cartao")
public class TipoCartaoController {

    private final TipoCartaoService tipoCartaoService;

    public TipoCartaoController(TipoCartaoService tipoCartaoService) {
        this.tipoCartaoService = tipoCartaoService;
    }


//  GET /tipo-cartao → listar todos os Tipos de Cartões
    @GetMapping
    public List<TipoCartao> listarTipoCartao() {
        return tipoCartaoService.listarTodos();
    }

}

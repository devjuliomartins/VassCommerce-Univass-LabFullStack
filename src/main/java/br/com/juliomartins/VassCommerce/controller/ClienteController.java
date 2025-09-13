//package br.com.juliomartins.VassCommerce.controller;
//
//import br.com.juliomartins.VassCommerce.model.Cliente;
//import br.com.juliomartins.VassCommerce.model.endereco.Endereco;
//import br.com.juliomartins.VassCommerce.model.formasdepagamento.FormasDePagamento;
//import br.com.juliomartins.VassCommerce.service.ClienteService;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import java.util.List;
//
//@RestController
//@RequestMapping
//public class ClienteController {
//    private final ClienteService clienteService;
//
//    public ClienteController(ClienteService clienteService) {
//        this.clienteService = clienteService;
//    }
//
//
////  GET /cliente/{id} → Visualizar dados do Cliente
//    @GetMapping("/cliente/{id}")
//    public Cliente VisualizarDadosCliente(@PathVariable long id) {
//        return clienteService.dadosCliente(id);
//    }
//
////  GET /cliente/{id}/forma-de-pagamento → Lista todas as formas de pagamento do Cliente
//    @GetMapping("/cliente/{id}/forma-de-pagamento")
//    public List<FormasDePagamento> VisualizarFormasDePagamentos(@PathVariable long id) {
//        return clienteService.formasDePagamentosCliente(id);
//    }
//
////  Get /cliente/{idCliente}/endereco → Busca pelos dados do endereço do cliente
//    @GetMapping("/cliente/{id}/endereco")
//    public Endereco VisualizarEnderecosCliente(@PathVariable long id) {
//        return clienteService.listarEnderecoCliente(id);
//    }
//
//}

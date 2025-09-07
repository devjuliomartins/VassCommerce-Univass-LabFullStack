package br.com.juliomartins.VassCommerce.service;

import br.com.juliomartins.VassCommerce.model.Categoria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {

    private List<Categoria> categorias;

    public CategoriaService() {
        categorias = new ArrayList<>();
        categorias.add(new Categoria(1,"eletronicos.png", "Eletrônicos","Aparelhos tecnologicos"));
        categorias.add(new Categoria(2, "roupas.png", "Roupas", "Vestuário e acessórios"));
        categorias.add(new Categoria(3, "livros.png", "Livros", "Diversos tipos de livros e revistas"));
    }

    // Listar todas Categorias
    public List<Categoria> listarTodas() {
        return categorias;
    }

    // Buscar Categoria por nome
    public List<Categoria> buscarPorNome(String nome) {
        return categorias.stream()
                .filter(c -> c.getNome().toLowerCase().contains(nome.toLowerCase()))
                .toList();
    }
}

package br.com.juliomartins.VassCommerce.service;

import br.com.juliomartins.VassCommerce.model.Categoria;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

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

    public List<Categoria> ListarTodas() {
        return categorias;
    }
}

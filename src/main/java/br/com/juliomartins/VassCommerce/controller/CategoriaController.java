package br.com.juliomartins.VassCommerce.controller;

import br.com.juliomartins.VassCommerce.dtos.CategoriaDto;
import br.com.juliomartins.VassCommerce.model.Categoria;
import br.com.juliomartins.VassCommerce.repository.CategoriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaRepository repository;

    public CategoriaController(CategoriaRepository repository) {
        this.repository = repository;
    }


    @PostMapping
    public ResponseEntity save(@RequestBody CategoriaDto dto) {
        var categoria = new Categoria();
        BeanUtils.copyProperties(dto, categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable(value = "id") Integer id) {
        Optional categoria = repository.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(categoria.get());
    }

    @GetMapping
    public ResponseEntity getAll() {
        List<Categoria> listarCategorias = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listarCategorias);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable(value = "id") Integer id, @RequestBody CategoriaDto dto) {
        Optional<Categoria> categoria = repository.findById(id);

        if (categoria.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Esta categoria não existe!");
        }

        var catergoriaModel = categoria.get();
        BeanUtils.copyProperties(dto, catergoriaModel);
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(catergoriaModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Integer id) {
        Optional<Categoria> categoria = repository.findById(id);

        if (categoria.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Esta categoria não existe!");
        }

        repository.delete(categoria.get());
        return ResponseEntity.status(HttpStatus.OK).body("Categoria deletada!");
    }


}

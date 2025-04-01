package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.record.CategoriasDTO;
import application.service.CategoriasService;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {
    @Autowired
    private CategoriasService categoriasService;

    @GetMapping
    public Iterable<CategoriasDTO> list() {
        return categoriasService.getAll();
    }

    @GetMapping("/{id}")
    public CategoriasDTO findOne(@PathVariable long id) {
        return categoriasService.getOne(id);
    }

    @PostMapping
    public CategoriasDTO insert(@RequestBody CategoriasDTO categorias) {
        return categoriasService.insert(categorias);
    }

    @PutMapping("/{id}")
    public CategoriasDTO update(@PathVariable long id, @RequestBody CategoriasDTO categorias) {
        return categoriasService.update(id, categorias);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        categoriasService.delete(id);
    }
}

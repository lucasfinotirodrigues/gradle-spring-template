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

import application.record.OpcoesDTO;
import application.service.OpcoesService;

@RestController
@RequestMapping("/opcoes")
public class OpcoesController {
    @Autowired
    private OpcoesService opcoesService;

    @GetMapping
    public Iterable<OpcoesDTO> list() {
        return opcoesService.getAll();
    }

    @GetMapping("/{id}")
    public OpcoesDTO findOne(@PathVariable long id) {
        return opcoesService.getOne(id);
    }

    @PostMapping
    public OpcoesDTO insert(@RequestBody OpcoesDTO opcoes) {
        return opcoesService.insert(opcoes);
    }

    @PutMapping("/{id}")
    public OpcoesDTO update(@PathVariable long id, @RequestBody OpcoesDTO opcoes) {
        return opcoesService.update(id, opcoes);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        opcoesService.delete(id);
    }
}
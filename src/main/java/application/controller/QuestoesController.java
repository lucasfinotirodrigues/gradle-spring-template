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

import application.record.QuestoesDTO;
import application.service.QuestoesService;

@RestController
@RequestMapping("/questoes")
public class QuestoesController {
    @Autowired
    private QuestoesService questoesService;

    @GetMapping
    public Iterable<QuestoesDTO> list() {
        return questoesService.getAll();
    }

    @GetMapping("/{id}")
    public QuestoesDTO findOne(@PathVariable long id) {
        return questoesService.getOne(id);
    }

    @PostMapping
    public QuestoesDTO insert(@RequestBody QuestoesDTO questoes) {
        return questoesService.insert(questoes);
    }

    @PutMapping("/{id}")
    public QuestoesDTO update(@PathVariable long id, @RequestBody QuestoesDTO questoes) {
        return questoesService.update(id, questoes);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        questoesService.delete(id);
    }
}
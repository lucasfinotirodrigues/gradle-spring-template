package application.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import application.model.Categorias;
import application.model.Questoes;
import org.springframework.http.HttpStatus;

import application.record.QuestoesDTO;
import org.springframework.web.server.ResponseStatusException;
import application.repository.QuestoesRepository;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class QuestoesService {
    @Autowired
    private QuestoesRepository questoesRepo;
    
    public Iterable<QuestoesDTO> getAll() {
        return questoesRepo.findAll().stream().map(QuestoesDTO::new).toList();
    }

      public QuestoesDTO getOne(long id) {
        Optional<Questoes> resultado = questoesRepo.findById(id);
        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Questão não encontrada"
            );
        }
        return new QuestoesDTO(resultado.get());
    }

    public QuestoesDTO insert(QuestoesDTO questoes) {
        Questoes newQuestoes = new Questoes(questoes);
        Questoes savedQuestoes = questoesRepo.save(newQuestoes);
        QuestoesDTO response = new QuestoesDTO(savedQuestoes);
        return response;
    }
    
    public QuestoesDTO update(long id, QuestoesDTO questoes) {
        Optional<Questoes> resultado = questoesRepo.findById(id);

        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Questão não encontrada"
            );
        }

        resultado.get().setEnunciado(questoes.enunciado());
        resultado.get().setCategorias(new Categorias(questoes.categorias()));

        return new QuestoesDTO(questoesRepo.save(resultado.get()));
    }

    public void delete(long id) {
        if(!questoesRepo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Questões não encontrada"
            );
        }
        questoesRepo.deleteById(id);
    }
}

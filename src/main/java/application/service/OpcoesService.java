package application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import application.model.Opcoes;
import application.model.Questoes;
import application.record.OpcoesDTO;
import application.repository.OpcoesRepository;

@Service
public class OpcoesService {
    @Autowired
    private OpcoesRepository opcoesRepo;
    
    public Iterable<OpcoesDTO> getAll() {
        return opcoesRepo.findAll().stream().map(OpcoesDTO::new).toList();
    }

      public OpcoesDTO getOne(long id) {
        Optional<Opcoes> resultado = opcoesRepo.findById(id);
        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Opção não encontrada"
            );
        }
        return new OpcoesDTO(resultado.get());
    }

    public OpcoesDTO insert(OpcoesDTO opcoes) {
        Opcoes newOpcoes = new Opcoes(opcoes);
        Opcoes savedOpcoes = opcoesRepo.save(newOpcoes);
        OpcoesDTO response = new OpcoesDTO(savedOpcoes);
        return response;
    }
    
    public OpcoesDTO update(long id, OpcoesDTO opcoes) {
        Optional<Opcoes> resultado = opcoesRepo.findById(id);

        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Opção não encontrada"
            );
        }

        resultado.get().setDescricao(opcoes.descricao());
        resultado.get().setCorreto(opcoes.correto());
        resultado.get().setQuestoes(new Questoes(opcoes.questoes()));

        return new OpcoesDTO(opcoesRepo.save(resultado.get()));
    }

    public void delete(long id) {
        if(!opcoesRepo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Opção não encontrada"
            );
        }
        opcoesRepo.deleteById(id);
    }
}

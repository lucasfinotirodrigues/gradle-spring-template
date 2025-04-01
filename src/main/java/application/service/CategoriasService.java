package application.service;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import application.model.Categorias;
import application.record.CategoriasDTO;
import application.repository.CategoriasRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@Service
public class CategoriasService {
    @Autowired
    private CategoriasRepository categoriasRepo;

    public Iterable<CategoriasDTO> getAll() {
        return this.categoriasRepo.findAll().stream().map(CategoriasDTO::new).toList();
    }

     public CategoriasDTO getOne(long id) {
        Optional<Categorias> resultado = categoriasRepo.findById(id);

        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Categoria não encontrada"
            );
        }

        return new CategoriasDTO(resultado.get());
    }

    public CategoriasDTO insert(CategoriasDTO categorias) {
        return new CategoriasDTO(categoriasRepo.save(new Categorias(categorias)));
    }

    public CategoriasDTO update(long id, CategoriasDTO dados) {
        Optional<Categorias> resultado = categoriasRepo.findById(id);

        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Genero Não Encontrado"
            );
        }

        resultado.get().setNome(dados.nome());
        return new CategoriasDTO(categoriasRepo.save(resultado.get()));
    }

    public void delete(long id) {
        if(!categoriasRepo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Genero Não Encontrado"
            );
        }

        categoriasRepo.deleteById(id);
    }
}

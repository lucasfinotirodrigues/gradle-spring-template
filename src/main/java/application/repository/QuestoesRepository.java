package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.model.Questoes;

public interface QuestoesRepository extends JpaRepository<Questoes, Long>{
    
}

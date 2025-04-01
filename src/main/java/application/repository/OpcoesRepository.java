package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.model.Opcoes;

public interface OpcoesRepository extends JpaRepository<Opcoes, Long>{
    
}

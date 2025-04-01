package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.model.Categorias;

public interface CategoriasRepository extends JpaRepository<Categorias, Long>{
    
}

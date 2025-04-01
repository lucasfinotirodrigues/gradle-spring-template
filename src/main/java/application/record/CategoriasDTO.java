package application.record;

import application.model.Categorias;

public record CategoriasDTO(
    long id,
    String nome
) {
    public CategoriasDTO(Categorias categorias){
        this(
            categorias.getId(),
            categorias.getNome()
        );
    }
}

package application.record;

import application.model.Questoes;

public record QuestoesDTO(
    long id,
    String enunciado,
    CategoriasDTO categorias
) {
    public QuestoesDTO(Questoes questoes) {
        this(
            questoes.getId(),
            questoes.getEnunciado(),
            new CategoriasDTO(questoes.getCategorias()) 
        );
    }
}

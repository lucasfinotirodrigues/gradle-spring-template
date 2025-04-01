package application.record;

import application.model.Opcoes;

public record OpcoesDTO(
    long id,
    String descricao,
    Boolean correto,
    QuestoesDTO questoes
) {
    public OpcoesDTO(Opcoes opcoes) {
        this(
            opcoes.getId(),
            opcoes.getDescricao(),
            opcoes.getCorreto(),
            new QuestoesDTO(opcoes.getQuestoes()) 
        );
    }
}

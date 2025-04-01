package application.model;


import application.record.OpcoesDTO;
import application.record.QuestoesDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "categorias")
@Getter
@Setter
@NoArgsConstructor
public class Opcoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String descricao;
    private String correto;

    @ManyToOne
    @JoinColumn(name = "id_questoes", nullable = false)
    private Questoes questoes;

    public Opcoes(OpcoesDTO dto) {
        this.id = dto.id();
        this.descricao = dto.descricao();
        this.correto = dto.correto();
        this.questoes = new Questoes(dto.questoes());
    }
}

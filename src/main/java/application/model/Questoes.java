package application.model;


import application.record.QuestoesDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "questoes")
@Getter
@Setter
@NoArgsConstructor
public class Questoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String enunciado;

    @ManyToOne
    @JoinColumn(name = "id_categorias", nullable = false)
    private Categorias categorias;

    public Questoes(QuestoesDTO record) {
        this.id = record.id();
        this.enunciado = record.enunciado();
        this.categorias = new Categorias(record.categorias());
    }
}

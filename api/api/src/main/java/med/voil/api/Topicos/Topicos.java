package med.voil.api.Topicos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "topicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private Date fecha_de_creacion;
    @Enumerated(EnumType.STRING)
    private Status status_del_topico;
    private String autor;
    private String curso;

    public Topicos(DatosregistroTopicos datosregistroTopicos) {
        this.titulo = datosregistroTopicos.titulo();
        this.mensaje = datosregistroTopicos.mensaje();
        this.fecha_de_creacion = new Date();
        this.status_del_topico = datosregistroTopicos.status_del_topico();
        this.autor = datosregistroTopicos.autor();
        this.curso = datosregistroTopicos.curso();
    }

    public void actualizarDatos(ActualizaTopico actualizatopico) {

        if (actualizatopico.titulo() != null){
            this.titulo = actualizatopico.titulo();
        }

        if (actualizatopico.mensaje() != null){
            this.mensaje = actualizatopico.mensaje();
        }

        if (actualizatopico.fecha_de_creacion() != null){
            this.fecha_de_creacion = new Date();
        }

        if (actualizatopico.status_del_topico() != null){
            this.status_del_topico = actualizatopico.status_del_topico();
        }

        if (actualizatopico.autor() != null){
            this.autor = actualizatopico.autor();
        }

        if (actualizatopico.curso() != null){
            this.curso = actualizatopico.curso();
        }

    }
}

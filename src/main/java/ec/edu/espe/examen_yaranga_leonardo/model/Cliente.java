package ec.edu.espe.examen_yaranga_leonardo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String tipoCliente;

    @Column(nullable = false)
    private Integer puntajeCrediticio;

    @ElementCollection
    private List<Deuda> deudasActuales;

    @Embeddable
    @Data
    public static class Deuda {
        private Double monto;
        private Integer plazoMeses;
    }
}
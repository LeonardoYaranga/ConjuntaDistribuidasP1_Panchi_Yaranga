package ec.edu.espe.examen_yaranga_leonardo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class HistorialEvaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String clienteNombre;

    @Column(nullable = false)
    private String tipoCliente;

    @Column(nullable = false)
    private Double montoSolicitado;

    @Column(nullable = false)
    private Integer plazoEnMeses;

    @Column(nullable = false)
    private String nivelRiesgo;

    @Column(nullable = false)
    private Boolean aprobado;

    @Column(nullable = false)
    private LocalDateTime fechaConsulta;
}
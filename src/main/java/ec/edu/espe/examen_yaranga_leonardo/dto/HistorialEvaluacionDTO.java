package ec.edu.espe.examen_yaranga_leonardo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HistorialEvaluacionDTO {
    private String clienteNombre;
    private String tipoCliente;
    private Double montoSolicitado;
    private Integer plazoEnMeses;
    private String nivelRiesgo;
    private Boolean aprobado;
    private LocalDateTime fechaConsulta;
}
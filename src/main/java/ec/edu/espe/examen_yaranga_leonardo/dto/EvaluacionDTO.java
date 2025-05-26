package ec.edu.espe.examen_yaranga_leonardo.dto;

import lombok.Data;

@Data
public class EvaluacionDTO {
    private String nivelRiesgo; // BAJO, MEDIO, ALTO
    private Boolean aprobado;
    private Integer puntajeFinal;
    private String mensaje;
    private Double tasaInteres;
    private Integer plazoAprobado;
}
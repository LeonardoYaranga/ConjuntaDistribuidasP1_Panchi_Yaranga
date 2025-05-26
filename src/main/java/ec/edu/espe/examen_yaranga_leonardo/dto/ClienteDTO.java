package ec.edu.espe.examen_yaranga_leonardo.dto;


import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class ClienteDTO {
    @NotNull
    @Size(min = 1, max = 255)
    private String nombre;

    @NotNull
    private String tipoCliente; // NATURAL o JURIDICA

    @NotNull
    @Min(300)
    private Integer puntajeCrediticio;

    @NotEmpty
    private List<DeudaDTO> deudasActuales;

    @NotNull
    @Min(0)
    private Double montoSolicitado;

    @NotNull
    @Min(1)
    private Integer plazoEnMeses;

    // Cliente Natural
    @Min(18)
    private Integer edad;

    @Min(0)
    private Double ingresoMensual;

    // Cliente Jurídico
    @Min(0)
    private Integer antiguedadAnios;

    @Min(0)
    private Double ingresoAnual;

    @Min(0)
    private Integer empleados;
}

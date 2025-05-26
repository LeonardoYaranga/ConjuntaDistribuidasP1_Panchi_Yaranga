package ec.edu.espe.examen_yaranga_leonardo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DeudaDTO {
    @NotNull
    @Min(0)
    private Double monto;

    @NotNull
    @Min(1)
    private Integer plazoMeses;
}
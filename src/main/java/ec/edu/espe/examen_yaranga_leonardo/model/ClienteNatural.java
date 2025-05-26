package ec.edu.espe.examen_yaranga_leonardo.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class ClienteNatural extends Cliente {
    private Integer edad;
    private Double ingresoMensual;
}
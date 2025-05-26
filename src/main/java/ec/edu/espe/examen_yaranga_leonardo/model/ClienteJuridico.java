package ec.edu.espe.examen_yaranga_leonardo.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class ClienteJuridico extends Cliente {
    private Integer antiguedadAnios;
    private Double ingresoAnual;
    private Integer empleados;
}
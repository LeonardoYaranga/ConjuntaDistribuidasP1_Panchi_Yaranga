package ec.edu.espe.examen_yaranga_leonardo.model;


import ec.edu.espe.examen_yaranga_leonardo.dto.ClienteDTO;
import ec.edu.espe.examen_yaranga_leonardo.dto.EvaluacionDTO;

public abstract class EvaluadorRiesgo {
    public abstract boolean aplica(ClienteDTO clienteDTO);

    public abstract EvaluacionDTO evaluar(ClienteDTO clienteDTO);

}
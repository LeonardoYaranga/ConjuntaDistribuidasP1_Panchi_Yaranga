package ec.edu.espe.examen_yaranga_leonardo.service;



import ec.edu.espe.examen_yaranga_leonardo.dto.ClienteDTO;
import ec.edu.espe.examen_yaranga_leonardo.dto.EvaluacionDTO;
import ec.edu.espe.examen_yaranga_leonardo.model.EvaluadorRiesgo;
import ec.edu.espe.examen_yaranga_leonardo.model.HistorialEvaluacion;
import ec.edu.espe.examen_yaranga_leonardo.repository.HistorialEvaluacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EvaluacionService {

    @Autowired
    private List<EvaluadorRiesgo> evaluadores;

    @Autowired
    private HistorialEvaluacionRepository historialRepository;

    public EvaluacionDTO evaluarRiesgo(ClienteDTO clienteDTO) {
        // Selección dinámica del evaluador usando Streams
        EvaluadorRiesgo evaluador = evaluadores.stream()
                .filter(e -> e.aplica(clienteDTO))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No se encontró un evaluador adecuado"));

        EvaluacionDTO resultado = evaluador.evaluar(clienteDTO);

        // Registrar en historial
        HistorialEvaluacion historial = new HistorialEvaluacion();
        historial.setClienteNombre(clienteDTO.getNombre());
        historial.setTipoCliente(clienteDTO.getTipoCliente());
        historial.setMontoSolicitado(clienteDTO.getMontoSolicitado());
        historial.setPlazoEnMeses(clienteDTO.getPlazoEnMeses());
        historial.setNivelRiesgo(resultado.getNivelRiesgo());
        historial.setAprobado(resultado.getAprobado());
        historial.setFechaConsulta(LocalDateTime.now());
        historialRepository.save(historial);

        return resultado;
    }
}
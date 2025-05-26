package ec.edu.espe.examen_yaranga_leonardo.service;

import ec.edu.espe.examen_yaranga_leonardo.dto.HistorialEvaluacionDTO;
import ec.edu.espe.examen_yaranga_leonardo.repository.HistorialEvaluacionRepository;
import ec.edu.espe.examen_yaranga_leonardo.model.HistorialEvaluacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistorialService {

    @Autowired
    private HistorialEvaluacionRepository historialRepository;

    public List<HistorialEvaluacionDTO> getHistorial() {
        return historialRepository.findAll()
                .stream()
                .map(h -> {
                    HistorialEvaluacionDTO dto = new HistorialEvaluacionDTO();
                    dto.setClienteNombre(h.getClienteNombre());
                    dto.setTipoCliente(h.getTipoCliente());
                    dto.setMontoSolicitado(h.getMontoSolicitado());
                    dto.setPlazoEnMeses(h.getPlazoEnMeses());
                    dto.setNivelRiesgo(h.getNivelRiesgo());
                    dto.setAprobado(h.getAprobado());
                    dto.setFechaConsulta(h.getFechaConsulta());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
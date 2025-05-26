package ec.edu.espe.examen_yaranga_leonardo.controller;


import ec.edu.espe.examen_yaranga_leonardo.dto.ClienteDTO;
import ec.edu.espe.examen_yaranga_leonardo.dto.EvaluacionDTO;
import ec.edu.espe.examen_yaranga_leonardo.dto.HistorialEvaluacionDTO;
import ec.edu.espe.examen_yaranga_leonardo.service.EvaluacionService;
import ec.edu.espe.examen_yaranga_leonardo.service.HistorialService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EvaluacionController {

    @Autowired
    private EvaluacionService evaluacionService;

    @Autowired
    private HistorialService historialService;

    @PostMapping
            ("/evaluar-riesgo")
    public EvaluacionDTO evaluarRiesgo(@Valid @RequestBody ClienteDTO clienteDTO) {
        return evaluacionService.evaluarRiesgo(clienteDTO);
    }

    @GetMapping
            ("/historial")
    public List<HistorialEvaluacionDTO> getHistorial() {
        return historialService.getHistorial();
    }

    //hacer un historial/1
}
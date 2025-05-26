package ec.edu.espe.examen_yaranga_leonardo.model;


import ec.edu.espe.examen_yaranga_leonardo.dto.ClienteDTO;
import ec.edu.espe.examen_yaranga_leonardo.dto.DeudaDTO;
import ec.edu.espe.examen_yaranga_leonardo.dto.EvaluacionDTO;
import org.springframework.stereotype.Component;

@Component
public class EvaluadorRiesgoBajo extends EvaluadorRiesgo {
    @Override
    public boolean aplica(ClienteDTO clienteDTO) {
        return calcularPuntaje(clienteDTO) >= 80;
    }

    @Override
    public EvaluacionDTO evaluar(ClienteDTO clienteDTO) {
        EvaluacionDTO evaluacion = new EvaluacionDTO();
        int puntaje = calcularPuntaje(clienteDTO);
        evaluacion.setNivelRiesgo("BAJO");
        evaluacion.setAprobado(true);
        evaluacion.setPuntajeFinal(puntaje);
        evaluacion.setMensaje("Cliente apto para préstamo con condiciones preferenciales");
        evaluacion.setTasaInteres(6.5);
        evaluacion.setPlazoAprobado(clienteDTO.getPlazoEnMeses());
        return evaluacion;
    }

    private int calcularPuntaje(ClienteDTO clienteDTO) {
        int puntaje = 100;

        // Penalización por puntaje crediticio
        if (clienteDTO.getPuntajeCrediticio() < 650) {
            puntaje -= 30;
        }

        // Penalizaciones para Cliente Natural
        if ("NATURAL".equals(clienteDTO.getTipoCliente())) {
            double deudasTotales = clienteDTO.getDeudasActuales().stream()
                    .mapToDouble(DeudaDTO::getMonto)
                    .sum();
            if (clienteDTO.getIngresoMensual() != null && clienteDTO.getIngresoMensual() > 0) {
                double ratioDeuda = deudasTotales / clienteDTO.getIngresoMensual();
                if (ratioDeuda > 0.4) {
                    puntaje -= 15;
                }
                double ratioMonto = clienteDTO.getMontoSolicitado() / clienteDTO.getIngresoMensual();
                if (ratioMonto > 0.5) {
                    puntaje -= 10;
                }
            }
        }
        // Penalizaciones para Cliente Jurídico
        else if ("JURIDICA".equals(clienteDTO.getTipoCliente())) {
            if (clienteDTO.getAntiguedadAnios() != null && clienteDTO.getAntiguedadAnios() < 3) {
                puntaje -= 30; // Cliente no apto
            }
            double deudasTotales = clienteDTO.getDeudasActuales().stream()
                    .mapToDouble(DeudaDTO::getMonto)
                    .sum();
            if (clienteDTO.getIngresoAnual() != null && clienteDTO.getIngresoAnual() > 0) {
                double ratioDeuda = deudasTotales / clienteDTO.getIngresoAnual();
                if (ratioDeuda > 0.35) {
                    puntaje -= 20;
                }
                double ratioMonto = clienteDTO.getMontoSolicitado() / clienteDTO.getIngresoAnual();
                if (ratioMonto > 0.3) {
                    puntaje -= 15;
                }
            }
        }

        return puntaje;
    }
}

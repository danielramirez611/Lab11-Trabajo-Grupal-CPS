package dev.cesarzavaleta.pruebas_unitarias_s11.controllers;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.HistorialMedico;
import dev.cesarzavaleta.pruebas_unitarias_s11.services.HistorialMedicoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historial-medico")
public class HistorialMedicoController {

    private final HistorialMedicoService historialMedicoService;

    public HistorialMedicoController(HistorialMedicoService historialMedicoService) {
        this.historialMedicoService = historialMedicoService;
    }

    @GetMapping
    public List<HistorialMedico> getAllHistorialMedicos() {
        return historialMedicoService.findAll();
    }

    @GetMapping("/{id}")
    public HistorialMedico getHistorialMedicoById(@PathVariable Long id) {
        return historialMedicoService.findById(id);
    }

    @PostMapping("/cliente")
    public HistorialMedico createHistorialMedico(@RequestBody HistorialMedico historialMedico) {
        return historialMedicoService.save(historialMedico);
    }

    @DeleteMapping("/{id}")
    public HistorialMedico deleteHistorialMedico(@PathVariable Long id) {
        HistorialMedico historialMedicoDelete = historialMedicoService.findById(id);
        historialMedicoService.deleteById(historialMedicoDelete.getIdHistorial());
        return historialMedicoDelete;
    }

}

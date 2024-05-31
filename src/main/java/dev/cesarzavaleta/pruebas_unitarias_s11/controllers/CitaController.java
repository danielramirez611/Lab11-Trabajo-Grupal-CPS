package dev.cesarzavaleta.pruebas_unitarias_s11.controllers;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Cita;
import dev.cesarzavaleta.pruebas_unitarias_s11.services.CitaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController {

    private final CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping
    public List<Cita> getAllCitas() {
        return citaService.findAll();
    }

    @GetMapping("/{id}")
    public Cita getCitaById(@PathVariable Long id) {
        return citaService.findById(id);
    }

    @PostMapping("/cliente")
    public Cita createCita(@RequestBody Cita cita) {
        return citaService.save(cita);
    }

    @DeleteMapping("/{id}")
    public Cita deleteCita(@PathVariable Long id) {
        Cita citaDelete = citaService.findById(id);
        citaService.deleteById(citaDelete.getIdCitas());
        return citaDelete;
    }

}

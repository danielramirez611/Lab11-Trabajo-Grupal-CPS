package dev.cesarzavaleta.pruebas_unitarias_s11.controllers;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Mascota;
import dev.cesarzavaleta.pruebas_unitarias_s11.services.MascotaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    private final MascotaService mascotaService;

    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    @GetMapping
    public List<Mascota> getAllMascotas() {
        return mascotaService.findAll();
    }

    @GetMapping("/{id}")
    public Mascota getMascotaById(@PathVariable Long id) {
        return mascotaService.findById(id);
    }

    @PostMapping("/mascota")
    public Mascota createMascota(@RequestBody Mascota mascota) {
        return mascotaService.save(mascota);
    }

    @DeleteMapping("/{id}")
    public Mascota deleteMascota(@PathVariable Long id) {
        Mascota mascotaDelete = mascotaService.findById(id);
        mascotaService.deleteById(mascotaDelete.getIdMascota());
        return mascotaDelete;
    }
}

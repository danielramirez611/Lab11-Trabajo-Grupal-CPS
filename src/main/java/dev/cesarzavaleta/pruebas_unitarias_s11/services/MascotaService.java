package dev.cesarzavaleta.pruebas_unitarias_s11.services;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Mascota;

import java.util.List;

public interface MascotaService {

    List<Mascota> findAll();
    Mascota findById(Long id);
    Mascota save(Mascota mascota);
    void deleteById(Long id);

}

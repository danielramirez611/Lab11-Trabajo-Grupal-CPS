package dev.cesarzavaleta.pruebas_unitarias_s11.repository;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Mascota;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaRepository extends CrudRepository<Mascota,Long> {
}

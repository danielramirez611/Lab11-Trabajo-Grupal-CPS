package dev.cesarzavaleta.pruebas_unitarias_s11.repository;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.HistorialMedico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialMedicoRepository extends CrudRepository<HistorialMedico, Long> {
}

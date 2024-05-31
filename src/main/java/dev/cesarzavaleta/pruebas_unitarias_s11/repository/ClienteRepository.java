package dev.cesarzavaleta.pruebas_unitarias_s11.repository;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}

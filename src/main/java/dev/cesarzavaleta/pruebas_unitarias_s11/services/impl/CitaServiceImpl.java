package dev.cesarzavaleta.pruebas_unitarias_s11.services.impl;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Cita;
import dev.cesarzavaleta.pruebas_unitarias_s11.repository.CitaRepository;
import dev.cesarzavaleta.pruebas_unitarias_s11.services.CitaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepository;

    public CitaServiceImpl(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @Override
    public List<Cita> findAll() {
        return (List<Cita>) citaRepository.findAll();
    }

    @Override
    public Cita findById(Long id) {
        return citaRepository.findById(id).orElseThrow();
    }

    @Override
    public Cita save(Cita cita) {
        return citaRepository.save(cita);
    }

    @Override
    public void deleteById(Long id) {
        citaRepository.deleteById(id);
    }
}

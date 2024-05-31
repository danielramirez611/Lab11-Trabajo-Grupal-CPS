package dev.cesarzavaleta.pruebas_unitarias_s11.services.impl;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.HistorialMedico;
import dev.cesarzavaleta.pruebas_unitarias_s11.repository.HistorialMedicoRepository;
import dev.cesarzavaleta.pruebas_unitarias_s11.services.HistorialMedicoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialMedicoServiceImpl implements HistorialMedicoService {

    private final HistorialMedicoRepository historialMedicoRepository;

    public HistorialMedicoServiceImpl(HistorialMedicoRepository historialMedicoRepository) {
        this.historialMedicoRepository = historialMedicoRepository;
    }

    @Override
    public List<HistorialMedico> findAll() {
        return (List<HistorialMedico>) historialMedicoRepository.findAll();
    }

    @Override
    public HistorialMedico findById(Long id) {
        return historialMedicoRepository.findById(id).orElseThrow();
    }

    @Override
    public HistorialMedico save(HistorialMedico historialMedico) {
        return historialMedicoRepository.save(historialMedico);
    }

    @Override
    public void deleteById(Long id) {
        historialMedicoRepository.deleteById(id);
    }
}

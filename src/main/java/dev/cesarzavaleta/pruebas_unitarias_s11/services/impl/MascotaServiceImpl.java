package dev.cesarzavaleta.pruebas_unitarias_s11.services.impl;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Mascota;
import dev.cesarzavaleta.pruebas_unitarias_s11.repository.MascotaRepository;
import dev.cesarzavaleta.pruebas_unitarias_s11.services.MascotaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaServiceImpl implements MascotaService {

    private final MascotaRepository mascotaRepository;

    public MascotaServiceImpl(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    @Override
    public List<Mascota> findAll() {
        return (List<Mascota>) mascotaRepository.findAll();
    }

    @Override
    public Mascota findById(Long id) {
        Optional<Mascota> mascota= mascotaRepository.findById(id);
        return mascota.orElse(null);
    }

    @Override
    public Mascota save(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    @Override
    public void deleteById(Long id) {
        mascotaRepository.deleteById(id);
    }
}

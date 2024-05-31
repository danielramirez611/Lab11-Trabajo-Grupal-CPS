package dev.cesarzavaleta.pruebas_unitarias_s11.services.impl;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Cliente;
import dev.cesarzavaleta.pruebas_unitarias_s11.repository.ClienteRepository;
import dev.cesarzavaleta.pruebas_unitarias_s11.services.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    //Llamar al repository
    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElseThrow();
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

}

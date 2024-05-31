package dev.cesarzavaleta.pruebas_unitarias_s11.controllers;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Cliente;
import dev.cesarzavaleta.pruebas_unitarias_s11.services.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Long id) {
        return clienteService.findById(id);
    }

    @PostMapping("/cliente")
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @DeleteMapping("/{id}")
    public Cliente deleteCliente(@PathVariable Long id) {
        Cliente clienteDelete = clienteService.findById(id);
        clienteService.deleteById(clienteDelete.getIdCliente());
        return clienteDelete;
    }

}

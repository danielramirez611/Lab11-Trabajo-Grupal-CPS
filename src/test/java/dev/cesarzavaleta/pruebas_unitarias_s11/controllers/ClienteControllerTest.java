package dev.cesarzavaleta.pruebas_unitarias_s11.controllers;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Cliente;
import dev.cesarzavaleta.pruebas_unitarias_s11.services.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ClienteControllerTest {

    private ClienteController clienteController;
    private ClienteService clienteService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        clienteService = mock(ClienteService.class);
        clienteController = new ClienteController(clienteService);
        mockMvc = MockMvcBuilders.standaloneSetup(clienteController).build();
    }

    @Test
    void getAllClientes() throws Exception {
        Cliente cliente1 = new Cliente();
        cliente1.setIdCliente(1L);
        cliente1.setNombre("Daniel");
        cliente1.setApellido("Soplopuco");
        cliente1.setDireccion("Villa Florencia");
        cliente1.setTelefono("999 882 333");
        cliente1.setCorreoElectronico("daniel@correo.com");
        Cliente cliente2 = new Cliente();
        cliente2.setIdCliente(2L);
        cliente2.setNombre("Jhennifer");
        cliente2.setApellido("Guevara");
        cliente2.setDireccion("Las Golondrinas");
        cliente2.setTelefono("938 747 828");
        cliente2.setCorreoElectronico("jhennifer@correo.com");
        List<Cliente> clientes = Arrays.asList(cliente1, cliente2);
        when(clienteService.findAll()).thenReturn(clientes);
        mockMvc.perform(get("/clientes"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].idCliente", is(1)))
                .andExpect(jsonPath("$[0].nombre", is("Daniel")))
                .andExpect(jsonPath("$[0].apellido", is("Soplopuco")))
                .andExpect(jsonPath("$[0].direccion", is("Villa Florencia")))
                .andExpect(jsonPath("$[0].telefono", is("999 882 333")))
                .andExpect(jsonPath("$[0].correoElectronico", is("daniel@correo.com")))
                .andExpect(jsonPath("$[1].idCliente", is(2)))
                .andExpect(jsonPath("$[1].nombre", is("Jhennifer")))
                .andExpect(jsonPath("$[1].apellido", is("Guevara")))
                .andExpect(jsonPath("$[1].direccion", is("Las Golondrinas")))
                .andExpect(jsonPath("$[1].telefono", is("938 747 828")))
                .andExpect(jsonPath("$[1].correoElectronico", is("jhennifer@correo.com")));
    }

    @Test
    public void testGetClienteById() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1L);
        cliente.setNombre("Daniel");
        cliente.setApellido("Soplopuco");
        cliente.setDireccion("Villa Florencia");
        cliente.setTelefono("999 882 333");
        cliente.setCorreoElectronico("daniel@correo.com");

        when(clienteService.findById(anyLong())).thenReturn(cliente);

        mockMvc.perform(get("/clientes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("Daniel")))
                .andExpect(jsonPath("$.apellido", is("Soplopuco")))
                .andExpect(jsonPath("$.direccion", is("Villa Florencia")))
                .andExpect(jsonPath("$.telefono", is("999 882 333")))
                .andExpect(jsonPath("$.correoElectronico", is("daniel@correo.com")));
    }

    @Test
    public void testCreateCliente() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1L);
        cliente.setNombre("Jhennifer");
        cliente.setApellido("Guevara");
        cliente.setDireccion("Las Golondrinas");
        cliente.setTelefono("938 747 828");
        cliente.setCorreoElectronico("jhennifer@correo.com");

        when(clienteService.save(any(Cliente.class))).thenReturn(cliente);

        mockMvc.perform(post("/clientes/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombre\": \"Jhennifer\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("Jhennifer")))
                .andExpect(jsonPath("$.apellido", is("Guevara")))
                .andExpect(jsonPath("$.direccion", is("Las Golondrinas")))
                .andExpect(jsonPath("$.telefono", is("938 747 828")))
                .andExpect(jsonPath("$.correoElectronico", is("jhennifer@correo.com")));
    }

    @Test
    public void testDeleteCliente() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1L);
        cliente.setNombre("Jhennifer");
        cliente.setApellido("Guevara");
        cliente.setDireccion("Las Golondrinas");
        cliente.setTelefono("938 747 828");
        cliente.setCorreoElectronico("jhennifer@correo.com");

        when(clienteService.findById(anyLong())).thenReturn(cliente);

        mockMvc.perform(delete("/clientes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("Jhennifer")))
                .andExpect(jsonPath("$.apellido", is("Guevara")))
                .andExpect(jsonPath("$.direccion", is("Las Golondrinas")))
                .andExpect(jsonPath("$.telefono", is("938 747 828")))
                .andExpect(jsonPath("$.correoElectronico", is("jhennifer@correo.com")));
    }

}

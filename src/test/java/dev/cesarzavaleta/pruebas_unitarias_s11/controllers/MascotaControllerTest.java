package dev.cesarzavaleta.pruebas_unitarias_s11.controllers;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Mascota;
import dev.cesarzavaleta.pruebas_unitarias_s11.services.MascotaService;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

class MascotaControllerTest {

    private MascotaController mascotaController;
    private MascotaService mascotaService;
    private MockMvc mockMvc;

    @BeforeEach //Esta anotación sirve para ejecutar el código setUp antes de cada método anotado con @Test
    void setUp() {
        //Se crean las instancias de cada atributo
        mascotaService = mock(MascotaService.class);
        mascotaController = new MascotaController(mascotaService);
        mockMvc = MockMvcBuilders.standaloneSetup(mascotaController).build();
    }

    @Test
    void getAllMascotas() throws Exception {
        //Creación objetos mascota
        Mascota mascota1 = new Mascota();
        mascota1.setIdMascota(1L);
        mascota1.setNombre("Lucas");
        Mascota mascota2 = new Mascota();
        mascota2.setIdMascota(2L);
        mascota2.setNombre("Luna");
        //Almacenar mascotas en una lista
        List<Mascota> mascotas = Arrays.asList(mascota1, mascota2);
        //Esta línea sirve para retornar un valor en específico cuando se llame a algún método del service.
        when(mascotaService.findAll()).thenReturn(mascotas);
        //Se hace el request al endpoint /mascotas
        //Luego se espera una respuesta OK
        //Luego se establece el contenido en JSON
        //Luego se espera que el tamaño de la lista sea de 2
        mockMvc.perform(get("/mascotas"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].idMascota", is(1)))
                .andExpect(jsonPath("$[0].nombre", is("Lucas")));
    }

    @Test
    public void testGetMascotaById() throws Exception {
        //Crear una mascota
        Mascota mascota = new Mascota();
        mascota.setIdMascota(1L);
        mascota.setNombre("Firulais");

        //Retornar la mascota cuando se llame al método findById del service
        when(mascotaService.findById(anyLong())).thenReturn(mascota);

        //Se hace el request a /mascotas/1 y se espere una respuesta OK
        mockMvc.perform(get("/mascotas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("Firulais")));
    }

    @Test
    public void testCreateMascota() throws Exception {
        Mascota mascota = new Mascota();
        mascota.setNombre("Firulais");

        when(mascotaService.save(any(Mascota.class))).thenReturn(mascota);

        mockMvc.perform(post("/mascotas/mascota")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombre\": \"Firulais\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("Firulais")));
    }

    @Test
    public void testDeleteMascota() throws Exception {
        Mascota mascota = new Mascota();
        mascota.setIdMascota(1L);
        mascota.setNombre("Firulais");

        when(mascotaService.findById(anyLong())).thenReturn(mascota);

        mockMvc.perform(delete("/mascotas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("Firulais")));
    }
}
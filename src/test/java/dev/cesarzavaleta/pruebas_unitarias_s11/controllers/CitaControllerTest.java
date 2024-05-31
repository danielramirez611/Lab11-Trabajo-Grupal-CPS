package dev.cesarzavaleta.pruebas_unitarias_s11.controllers;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Cita;
import dev.cesarzavaleta.pruebas_unitarias_s11.services.CitaService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.mock;

public class CitaControllerTest {

    private CitaController citaController;
    private CitaService citaService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        citaService = mock(CitaService.class);
        citaController = new CitaController(citaService);
        mockMvc = MockMvcBuilders.standaloneSetup(citaController).build();
    }

    @Test
    public void testGetAllCitas() throws Exception {
        Cita cita1 = new Cita();
        cita1.setIdCitas(1L);
        cita1.setFechaHora(new Date());
        cita1.setMotivoConsulta("Aseo de mascota");

        Cita cita2 = new Cita();
        cita2.setIdCitas(2L);
        cita2.setFechaHora(new Date());
        cita2.setMotivoConsulta("Vacunación antiparasitaria");

        List<Cita> citas = Arrays.asList(cita1, cita2);

        when(citaService.findAll()).thenReturn(citas);

        mockMvc.perform(get("/citas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(2)))
                .andExpect(jsonPath("$[0].motivoConsulta", is("Aseo de mascota")))
                .andExpect(jsonPath("$[1].motivoConsulta", is("Vacunación antiparasitaria")));
    }

    @Test
    public void testGetCitaById() throws Exception {
        Cita cita = new Cita();
        cita.setIdCitas(1L);
        cita.setFechaHora(new Date());
        cita.setMotivoConsulta("Aseo de mascota");

        when(citaService.findById(anyLong())).thenReturn(cita);

        mockMvc.perform(get("/citas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.motivoConsulta", is("Aseo de mascota")));
    }

    @Test
    public void testCreateCita() throws Exception {
        Cita cita = new Cita();
        cita.setFechaHora(new Date());
        cita.setMotivoConsulta("Aseo de mascota");

        when(citaService.save(any(Cita.class))).thenReturn(cita);

        mockMvc.perform(post("/citas/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"fechaHora\": \"2024-05-30T10:15:30\", \"motivoConsulta\": \"Aseo de mascota\", \"mascota\": {\"idMascota\": 1}}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.motivoConsulta", is("Aseo de mascota")));
    }

    @Test
    public void testDeleteCita() throws Exception {
        Cita cita = new Cita();
        cita.setIdCitas(1L);
        cita.setFechaHora(new Date());
        cita.setMotivoConsulta("Consulta de prueba");

        when(citaService.findById(anyLong())).thenReturn(cita);

        mockMvc.perform(delete("/citas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.motivoConsulta", is("Consulta de prueba")));
    }
}

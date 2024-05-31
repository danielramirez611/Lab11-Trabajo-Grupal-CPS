package dev.cesarzavaleta.pruebas_unitarias_s11.controllers;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.HistorialMedico;
import dev.cesarzavaleta.pruebas_unitarias_s11.services.HistorialMedicoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.mockito.Mockito.mock;

public class HistorialMedicoControllerTest {

    private HistorialMedicoController historialMedicoController;
    private HistorialMedicoService historialMedicoService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        historialMedicoService = mock(HistorialMedicoService.class);
        historialMedicoController = new HistorialMedicoController(historialMedicoService);
        mockMvc = MockMvcBuilders.standaloneSetup(historialMedicoController).build();
    }

    @Test
    public void testGetAllHistorialMedicos() throws Exception {
        HistorialMedico historial1 = new HistorialMedico();
        historial1.setIdHistorial(1L);
        historial1.setDiagnostico("Conjuntivitis");

        HistorialMedico historial2 = new HistorialMedico();
        historial2.setIdHistorial(2L);
        historial2.setDiagnostico("Heterocromia");

        List<HistorialMedico> historiales = Arrays.asList(historial1, historial2);

        when(historialMedicoService.findAll()).thenReturn(historiales);

        mockMvc.perform(get("/historial-medico"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(2)))
                .andExpect(jsonPath("$[0].diagnostico", is("Conjuntivitis")))
                .andExpect(jsonPath("$[1].diagnostico", is("Heterocromia")));
    }

    @Test
    public void testGetHistorialMedicoById() throws Exception {
        HistorialMedico historial = new HistorialMedico();
        historial.setIdHistorial(1L);
        historial.setDiagnostico("Conjuntivitis");

        when(historialMedicoService.findById(anyLong())).thenReturn(historial);

        mockMvc.perform(get("/historial-medico/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.diagnostico", is("Conjuntivitis")));
    }

    @Test
    public void testCreateHistorialMedico() throws Exception {
        HistorialMedico historial = new HistorialMedico();
        historial.setDiagnostico("Conjuntivitis");

        when(historialMedicoService.save(any(HistorialMedico.class))).thenReturn(historial);

        mockMvc.perform(post("/historial-medico/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"diagnostico\": \"Diagnóstico\", \"tratamiento\": \"Conjuntivitis\", \"observaciones\": \"Observaciones\", \"cita\": {\"idCitas\": 1}}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.diagnostico", is("Conjuntivitis")));
    }

    @Test
    public void testDeleteHistorialMedico() throws Exception {
        HistorialMedico historial = new HistorialMedico();
        historial.setIdHistorial(1L);
        historial.setDiagnostico("Conjuntivitis");

        when(historialMedicoService.findById(anyLong())).thenReturn(historial);

        mockMvc.perform(delete("/historial-medico/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.diagnostico", is("Conjuntivitis")));
    }
}

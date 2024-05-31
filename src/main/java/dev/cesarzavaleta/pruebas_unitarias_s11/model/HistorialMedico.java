package dev.cesarzavaleta.pruebas_unitarias_s11.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "historal_medico")
public class HistorialMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial")
    private Long idHistorial;

    @ManyToOne
    @JoinColumn(name = "id_cita", nullable = false)
    private Cita cita;

    private String diagnostico;

    private String tratamiento;

    @Column(columnDefinition = "TEXT")
    private String observaciones;

}

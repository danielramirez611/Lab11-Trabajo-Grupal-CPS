package dev.cesarzavaleta.pruebas_unitarias_s11.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "citas")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Long idCitas;

    @Column(name = "fecha_hora", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;

    @Column(name = "motivo_consulta")
    private String motivoConsulta;

    @ManyToOne
    @JoinColumn(name = "id_mascota", nullable = false)
    private Mascota mascota;

}

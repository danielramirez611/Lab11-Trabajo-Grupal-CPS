package dev.cesarzavaleta.pruebas_unitarias_s11.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(nullable = false, length = 255)
    private String nombre;

    @Column(nullable = false, length = 255)
    private String apellido;

    @Column(length = 255)
    private String direccion;

    @Column(length = 20)
    private String telefono;

    @Column(name = "correo_electronico", unique = true, length = 50)
    private String correoElectronico;

}

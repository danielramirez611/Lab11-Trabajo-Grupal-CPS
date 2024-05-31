-- Insertar datos de prueba en la tabla "clientes"
INSERT INTO clientes (nombre, apellido, direccion, telefono, correo_electronico) VALUES
  ('Juan', 'Pérez', 'Calle Mayor 123', '951234567', 'juan.perez@email.com'),
  ('María', 'García', 'Avenida del Sol 456', '963214578', 'maria.garcia@email.com'),
  ('Pedro', 'López', 'Calle Luna 789', '974321654', 'pedro.lopez@email.com');

-- Insertar datos de prueba en la tabla "mascotas"
INSERT INTO mascotas (nombre, especie, raza, sexo, fecha_nacimiento, id_cliente) VALUES
  ('Toby', 'Perro', 'Golden Retriever', 'Macho', '2020-01-01', 1),
  ('Luna', 'Gata', 'Siamés', 'Hembra', '2021-02-02', 2),
  ('Pelusa', 'Conejo', 'Blanco', 'Hembra', '2022-03-03', 1);

-- Insertar datos de prueba en la tabla "citas"
INSERT INTO citas (fecha_hora, motivo_consulta, id_mascota) VALUES
  ('2024-05-25 10:00:00', 'Revisión Anual', 1),
  ('2024-06-15 15:30:00', 'Vacunación', 2),
  ('2024-07-10 11:00:00', 'Control Dermatológico', 3);

-- Insertar datos de prueba en la tabla "historial_medico"
INSERT INTO historial_medico (id_cita, diagnostico, tratamiento, observaciones) VALUES
  (1, 'Parásitos intestinales', 'Desparasitación interna', 'Se desparasitó a la mascota y se le recomendó seguir tratamiento preventivo.'),
  (2, 'Rabia', 'Aplicación de vacuna antirrábica', 'Se aplicó la vacuna antirrábica a la mascota según el calendario de vacunación.'),
  (3, 'Alergia cutánea', 'Champú hipoalergénico y antihistamínico', 'Se detectó alergia cutánea a la mascota. Se recomienda bañar con champú hipoalergénico y administrar antihistamínico según prescripción.');

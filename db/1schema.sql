
-- Usar la base de datos "veterinaria"
-- USE veterinaria;

-- Crear tabla "clientes" para almacenar información de clientes
CREATE TABLE clientes (
  id_cliente SERIAL PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  apellido VARCHAR(255) NOT NULL,
  direccion VARCHAR(255),
  telefono VARCHAR(20),
  correo_electronico VARCHAR(50) UNIQUE
);

-- Crear tabla "mascotas" para almacenar información de mascotas
CREATE TABLE mascotas (
  id_mascota SERIAL PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  especie VARCHAR(50) NOT NULL,
  raza VARCHAR(50),
  sexo VARCHAR(10),
  fecha_nacimiento DATE,
  id_cliente INTEGER NOT NULL,
  FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
);

-- Crear tabla "citas" para almacenar información de citas
CREATE TABLE citas (
  id_cita SERIAL PRIMARY KEY,
  fecha_hora TIMESTAMP NOT NULL,
  motivo_consulta VARCHAR(255),
  id_mascota INTEGER NOT NULL,
  FOREIGN KEY (id_mascota) REFERENCES mascotas(id_mascota)
);

-- Crear tabla "historial_medico" para almacenar el historial médico de las mascotas
CREATE TABLE historial_medico (
  id_historial SERIAL PRIMARY KEY,
  id_cita INTEGER NOT NULL,
  diagnostico VARCHAR(255),
  tratamiento VARCHAR(255),
  observaciones TEXT,
  FOREIGN KEY (id_cita) REFERENCES citas(id_cita)
);

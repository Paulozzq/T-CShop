-- Inserción de Roles
INSERT INTO roles (nombre_rol) VALUES ('ADMIN');
INSERT INTO roles (nombre_rol) VALUES ('USER');

-- Inserción de Sedes
INSERT INTO sedes (nombre_sede, ciudad, direccion) VALUES ('Sede Arequipa', 'Arequipa', 'Av. Ejemplo 123');
INSERT INTO sedes (nombre_sede, ciudad, direccion) VALUES ('Sede Trujillo', 'Trujillo', 'Av. Ejemplo 456');
INSERT INTO sedes (nombre_sede, ciudad, direccion) VALUES ('Sede Lima', 'Lima', 'Av. Ejemplo 789');

INSERT INTO departamentos (nombre_departamento) VALUES ('Electricidad y Electrónica');
INSERT INTO departamentos (nombre_departamento) VALUES ('Gestión y Producción');
INSERT INTO departamentos (nombre_departamento) VALUES ('Mecánica y Aviación');
INSERT INTO departamentos (nombre_departamento) VALUES ('Mecatrónica');
INSERT INTO departamentos (nombre_departamento) VALUES ('Minería y Procesos Químico-Metalúrgicos');
INSERT INTO departamentos (nombre_departamento) VALUES ('Seguridad y Salud en el Trabajo');
INSERT INTO departamentos (nombre_departamento) VALUES ('Tecnología Agrícola');
INSERT INTO departamentos (nombre_departamento) VALUES ('Tecnología Digital');

-- Carreras de "Electricidad y Electrónica"
INSERT INTO carreras (nombre_carrera, id_departamento) VALUES ('Mecatrónica Industrial', 1);
INSERT INTO carreras (nombre_carrera, id_departamento) VALUES ('Electricidad Industrial', 1);
INSERT INTO carreras (nombre_carrera, id_departamento) VALUES ('Electrónica y Automatización Industrial', 1);
INSERT INTO carreras (nombre_carrera, id_departamento) VALUES ('Tecnología Mecánica Eléctrica', 1);

-- Carreras de "Gestión y Producción"
INSERT INTO carreras (nombre_carrera, id_departamento) VALUES ('Logística Digital Integrada', 2);
INSERT INTO carreras (nombre_carrera, id_departamento) VALUES ('Administración y Emprendimiento de Negocios Digitales', 2);
INSERT INTO carreras (nombre_carrera, id_departamento) VALUES ('Marketing Digital Analítico', 2);
INSERT INTO carreras (nombre_carrera, id_departamento) VALUES ('Diseño Industrial', 2);
INSERT INTO carreras (nombre_carrera, id_departamento) VALUES ('Tecnología de la Producción', 2);
INSERT INTO carreras (nombre_carrera, id_departamento) VALUES ('Producción y Gestión Industrial', 2);

-- Carreras de "Mecánica y Aviación"
INSERT INTO carreras (nombre_carrera, id_departamento) VALUES ('Mantenimiento de Equipo Pesado', 3);
INSERT INTO carreras (nombre_carrera, id_departamento) VALUES ('Mecatrónica y Gestión Automotriz', 3);
INSERT INTO carreras (nombre_carrera, id_departamento) VALUES ('Gestión y Mantenimiento de Maquinaria Pesada', 3);
INSERT INTO carreras (nombre_carrera, id_departamento) VALUES ('Aviónica y Mecánica Aeronáutica', 3);
INSERT INTO carreras (nombre_carrera, id_departamento) VALUES ('Mantenimiento y Gestión de Plantas Industriales', 3);
INSERT INTO carreras (nombre_carrera, id_departamento) VALUES ('Tecnología Mecánica Eléctrica', 3);

-- Carreras de "Mecatrónica"
INSERT INTO carreras (nombre_carrera, id_departamento) VALUES ('Mecatrónica', 4);

-- Carreras de "Minería y Procesos Químico-Metalúrgicos"
INSERT INTO carreras (nombre_carrera, id_departamento) VALUES ('Topografía y Geomática', 5);
INSERT INTO carreras (nombre_carrera, id_departamento) VALUES ('Procesos Químicos y Metalúrgicos', 5);
INSERT INTO carreras (nombre_carrera, id_departamento) VALUES ('Operaciones Mineras', 5);
INSERT INTO carreras (nombre_carrera, id_departamento) VALUES ('Operación de Plantas de Procesamiento de Minerales', 5);
INSERT INTO carreras (nombre_carrera, id_departamento) VALUES ('Gestión de Seguridad y Salud en el Trabajo', 5);

-- Carreras de "Seguridad y Salud en el Trabajo"
INSERT INTO carreras (nombre_carrera, id_departamento) VALUES ('Gestión de Seguridad y Salud en el Trabajo', 6);

-- Carreras de "Tecnología Agrícola"
INSERT INTO carreras (nombre_carrera, id_departamento) VALUES ('Tecnología Agrícola', 7);

-- Carreras de "Tecnología Digital"
INSERT INTO carreras (nombre_carrera, id_departamento) VALUES ('Modelado y Animación Digital', 8);
INSERT INTO carreras (nombre_carrera, id_departamento) VALUES ('Ciberseguridad y Auditoría Informática', 8);
INSERT INTO carreras (nombre_carrera, id_departamento) VALUES ('Diseño y Desarrollo de Software', 8);
INSERT INTO carreras (nombre_carrera, id_departamento) VALUES ('Diseño y Desarrollo de Simuladores y Videojuegos', 8);
INSERT INTO carreras (nombre_carrera, id_departamento) VALUES ('Administración de Redes y Comunicaciones', 8);
INSERT INTO carreras (nombre_carrera, id_departamento) VALUES ('Big Data y Ciencia de Datos', 8);

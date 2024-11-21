-- Inserción de Roles
INSERT INTO roles (nombre_rol) VALUES ('ADMIN');
INSERT INTO roles (nombre_rol) VALUES ('USER');

-- Inserción de Sedes
INSERT INTO sedes (nombre_sede, ciudad, direccion) VALUES ('Sede Arequipa', 'Arequipa', 'Av. Ejemplo 123');
INSERT INTO sedes (nombre_sede, ciudad, direccion) VALUES ('Sede Trujillo', 'Trujillo', 'Av. Ejemplo 456');
INSERT INTO sedes (nombre_sede, ciudad, direccion) VALUES ('Sede Lima', 'Lima', 'Av. Ejemplo 789');

-- Inserción de Departamentos
INSERT INTO departamentos (nombre_departamento) VALUES ('Tecnología Digital');
INSERT INTO departamentos (nombre_departamento) VALUES ('Diseño');
INSERT INTO departamentos (nombre_departamento) VALUES ('Construcción');
INSERT INTO departamentos (nombre_departamento) VALUES ('Administración');
INSERT INTO departamentos (nombre_departamento) VALUES ('Marketing');
INSERT INTO departamentos (nombre_departamento) VALUES ('Salud');

-- Inserción de Carreras
-- Tecnología Digital
INSERT INTO carreras (nombre_carrera) VALUES ('Desarrollo de Software');
INSERT INTO carreras (nombre_carrera) VALUES ('Redes y Comunicaciones');
INSERT INTO carreras (nombre_carrera) VALUES ('Ciberseguridad');

-- Diseño
INSERT INTO carreras (nombre_carrera) VALUES ('Diseño Gráfico');
INSERT INTO carreras (nombre_carrera) VALUES ('Diseño de Modas');
INSERT INTO carreras (nombre_carrera) VALUES ('Diseño de Interiores');

-- Construcción
INSERT INTO carreras (nombre_carrera) VALUES ('Ingeniería Civil');
INSERT INTO carreras (nombre_carrera) VALUES ('Arquitectura');
INSERT INTO carreras (nombre_carrera) VALUES ('Técnico en Construcción');

-- Administración
INSERT INTO carreras (nombre_carrera) VALUES ('Administración de Empresas');
INSERT INTO carreras (nombre_carrera) VALUES ('Contabilidad');
INSERT INTO carreras (nombre_carrera) VALUES ('Recursos Humanos');

-- Marketing
INSERT INTO carreras (nombre_carrera) VALUES ('Marketing Digital');
INSERT INTO carreras (nombre_carrera) VALUES ('Investigación de Mercados');
INSERT INTO carreras (nombre_carrera) VALUES ('Publicidad');

-- Salud
INSERT INTO carreras (nombre_carrera) VALUES ('Técnico en Enfermería');
INSERT INTO carreras (nombre_carrera) VALUES ('Nutrición');
INSERT INTO carreras (nombre_carrera) VALUES ('Fisioterapia');

INSERT INTO tiendas (sede_id, descripcion, nombre_tienda, ubicacion_mapa, imagen) VALUES (1, 'Tienda de deportes', 'Deportec', 'En el centro comercial', 'http://example.com/deportec.jpg');
INSERT INTO tiendas (sede_id, descripcion, nombre_tienda, ubicacion_mapa, imagen) VALUES (2, 'Tienda de ropa', 'ModaMax', 'Cerca de la plaza principal', 'http://example.com/modamax.jpg');
INSERT INTO tiendas (sede_id, descripcion, nombre_tienda, ubicacion_mapa, imagen) VALUES (3, 'Tienda de tecnología', 'TecnoShop', 'Frente al parque tecnológico', 'http://example.com/tecnoshop.jpg');
INSERT INTO tiendas (sede_id, descripcion, nombre_tienda, ubicacion_mapa, imagen) VALUES (1, 'Tienda de libros', 'Librerías Progreso', 'En la zona cultural', 'http://example.com/libreria.jpg');
INSERT INTO tiendas (sede_id, descripcion, nombre_tienda, ubicacion_mapa, imagen) VALUES (2, 'Tienda de juguetes', 'Juguetec', 'Al lado del cine', 'http://example.com/juguetec.jpg');
INSERT INTO tiendas (sede_id, descripcion, nombre_tienda, ubicacion_mapa, imagen) VALUES (3, 'Tienda de electrodomésticos', 'ElectroPlus', 'Cerca del centro comercial', 'http://example.com/electroplus.jpg');
INSERT INTO tiendas (sede_id, descripcion, nombre_tienda, ubicacion_mapa, imagen) VALUES (1, 'Tienda de vinos', 'VinoCasa', 'En la zona gourmet', 'http://example.com/vinocasa.jpg');
INSERT INTO tiendas (sede_id, descripcion, nombre_tienda, ubicacion_mapa, imagen) VALUES (2, 'Tienda de instrumentos musicales', 'MusicStore', 'En la calle principal', 'http://example.com/musicstore.jpg');
INSERT INTO tiendas (sede_id, descripcion, nombre_tienda, ubicacion_mapa, imagen) VALUES (3, 'Tienda de muebles', 'Muebles El Arte', 'En el distrito comercial', 'http://example.com/mueblesarte.jpg');
INSERT INTO tiendas (sede_id, descripcion, nombre_tienda, ubicacion_mapa, imagen) VALUES (1, 'Tienda de perfumes', 'Perfumería Lux', 'En el centro de la ciudad', 'http://example.com/perfumeria.jpg');

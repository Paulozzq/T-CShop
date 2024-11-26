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

INSERT INTO `usuarios` (`carrera_id`, `departamento_id`, `enable`, `id`, `rol_id`, `sede_id`, `register_date`, `number`, `email`, `name`, `username`, `password`, `token`) VALUES ('1', '1', b'1', NULL, '1', '1', '2024-11-22 15:52:31.000000', '1234567890', 'paulo.garcia@tecsup.edu.pe', 'Paulo Garcia', 'paulozzq1', '$2a$10$004cnzqeWonlQ3TKZ6prl.HWdSlww7uGp3V0iG9wAzPK7r6omLuyu', '7368e3ec-7ae2-4e41-8e55-37424cf71644')

INSERT INTO tiendas (sede_id, descripcion, nombre_tienda, ubicacion_mapa, imagen, qr_imagen, usuario_id) VALUES (1, 'Tienda de deportes', 'Deportec', 'En el centro comercial', 'http://example.com/deportec.jpg', "ksnewnduwwd", 1);
INSERT INTO tiendas (sede_id, descripcion, nombre_tienda, ubicacion_mapa, imagen, qr_imagen, usuario_id) VALUES (2, 'Tienda de ropa', 'ModaMax', 'Cerca de la plaza principal', 'http://example.com/modamax.jpg', "ksnewnduwwd", 1);
INSERT INTO tiendas (sede_id, descripcion, nombre_tienda, ubicacion_mapa, imagen, qr_imagen, usuario_id) VALUES (3, 'Tienda de tecnología', 'TecnoShop', 'Frente al parque tecnológico', 'http://example.com/tecnoshop.jpg', "ksnewnduwwd", 1);
INSERT INTO tiendas (sede_id, descripcion, nombre_tienda, ubicacion_mapa, imagen, qr_imagen, usuario_id) VALUES (1, 'Tienda de libros', 'Librerías Progreso', 'En la zona cultural', 'http://example.com/libreria.jpg', "ksnewnduwwd", 1);
INSERT INTO tiendas (sede_id, descripcion, nombre_tienda, ubicacion_mapa, imagen, qr_imagen, usuario_id) VALUES (2, 'Tienda de juguetes', 'Juguetec', 'Al lado del cine', 'http://example.com/juguetec.jpg', "ksnewnduwwd", 1);
INSERT INTO tiendas (sede_id, descripcion, nombre_tienda, ubicacion_mapa, imagen, qr_imagen, usuario_id) VALUES (3, 'Tienda de electrodomésticos', 'ElectroPlus', 'Cerca del centro comercial', 'http://example.com/electroplus.jpg', "ksnewnduwwd", 1);
INSERT INTO tiendas (sede_id, descripcion, nombre_tienda, ubicacion_mapa, imagen, qr_imagen, usuario_id) VALUES (1, 'Tienda de vinos', 'VinoCasa', 'En la zona gourmet', 'http://example.com/vinocasa.jpg', "ksnewnduwwd", 1);
INSERT INTO tiendas (sede_id, descripcion, nombre_tienda, ubicacion_mapa, imagen, qr_imagen, usuario_id) VALUES (2, 'Tienda de instrumentos musicales', 'MusicStore', 'En la calle principal', 'http://example.com/musicstore.jpg', "ksnewnduwwd", 1);
INSERT INTO tiendas (sede_id, descripcion, nombre_tienda, ubicacion_mapa, imagen, qr_imagen, usuario_id) VALUES (3, 'Tienda de muebles', 'Muebles El Arte', 'En el distrito comercial', 'http://example.com/mueblesarte.jpg', "ksnewnduwwd", 1);
INSERT INTO tiendas (sede_id, descripcion, nombre_tienda, ubicacion_mapa, imagen, qr_imagen, usuario_id) VALUES (1, 'Tienda de perfumes', 'Perfumería Lux', 'En el centro de la ciudad', 'http://example.com/perfumeria.jpg', "ksnewnduwwd", 1);


INSERT INTO `horarios_tienda` (`hora_apertura`, `hora_cierre`, `id_horario`, `tienda_id`, `estado`) VALUES ('00:00:00.000000', '06:00:00.000000', NULL, '1', NULL), ('01:00:00.000000', '07:00:00.000000', NULL, '7', NULL), ('06:00:00.000000', '12:00:00.000000', NULL, '4', NULL), ('07:00:00.000000', '11:30:00.000000', NULL, '8', NULL), ('13:00:00.000000', '19:00:00.000000', NULL, '2', NULL), ('14:00:00.000000', '20:00:00.000000', NULL, '9', NULL), ('08:00:00.000000', '18:00:00.000000', NULL, '3', NULL), ('09:00:00.000000', '17:00:00.000000', NULL, '6', NULL), ('16:00:00.000000', '23:00:00.000000', NULL, '5', NULL), ('17:00:00.000000', '00:00:00.000000', NULL, '10', NULL)

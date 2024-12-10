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

INSERT INTO `usuarios` (`carrera_id`, `departamento_id`, `enable`, `id`, `rol_id`, `sede_id`, `register_date`, `number`, `email`, `name`, `username`, `password`, `token`) VALUES ('1', '1', b'1', NULL, '1', '1', '2024-11-22 15:52:31.000000', '1234567890', 'paulo.garcia@tecsup.edu.pe', 'Paulo Garcia', 'paulozzq1', '$2a$10$004cnzqeWonlQ3TKZ6prl.HWdSlww7uGp3V0iG9wAzPK7r6omLuyu', '7368e3ec-7ae2-4e41-8e55-37424cf71644');

INSERT INTO tiendas (sede_id, descripcion, nombre_tienda, ubicacion_mapa, imagen, qr_imagen, usuario_id) VALUES (1, 'Tienda de deportes', 'Deportec', 'En el centro comercial', "https://res.cloudinary.com/dijr92ntz/image/upload/v1718683405/avatars/i3qpxfcrmeajasjmcoj3.jpg", "ksnewnduwwd", 1);
INSERT INTO tiendas (sede_id, descripcion, nombre_tienda, ubicacion_mapa, imagen, qr_imagen, usuario_id) VALUES (2, 'Tienda de ropa', 'ModaMax', 'Cerca de la plaza principal', "https://res.cloudinary.com/dijr92ntz/image/upload/v1718683405/avatars/i3qpxfcrmeajasjmcoj3.jpg", "ksnewnduwwd", 1);
INSERT INTO tiendas (sede_id, descripcion, nombre_tienda, ubicacion_mapa, imagen, qr_imagen, usuario_id) VALUES (3, 'Tienda de tecnología', 'TecnoShop', 'Frente al parque tecnológico', "https://res.cloudinary.com/dijr92ntz/image/upload/v1718683405/avatars/i3qpxfcrmeajasjmcoj3.jpg", "ksnewnduwwd", 1);
INSERT INTO tiendas (sede_id, descripcion, nombre_tienda, ubicacion_mapa, imagen, qr_imagen, usuario_id) VALUES (1, 'Tienda de libros', 'Librerías Progreso', 'En la zona cultural', "https://res.cloudinary.com/dijr92ntz/image/upload/v1718683405/avatars/i3qpxfcrmeajasjmcoj3.jpg", "ksnewnduwwd", 1);
INSERT INTO tiendas (sede_id, descripcion, nombre_tienda, ubicacion_mapa, imagen, qr_imagen, usuario_id) VALUES (2, 'Tienda de juguetes', 'Juguetec', 'Al lado del cine', "https://res.cloudinary.com/dijr92ntz/image/upload/v1718683405/avatars/i3qpxfcrmeajasjmcoj3.jpg", "ksnewnduwwd", 1);
INSERT INTO tiendas (sede_id, descripcion, nombre_tienda, ubicacion_mapa, imagen, qr_imagen, usuario_id) VALUES (3, 'Tienda de electrodomésticos', 'ElectroPlus', 'Cerca del centro comercial', "https://res.cloudinary.com/dijr92ntz/image/upload/v1718683405/avatars/i3qpxfcrmeajasjmcoj3.jpg", "ksnewnduwwd", 1);
INSERT INTO tiendas (sede_id, descripcion, nombre_tienda, ubicacion_mapa, imagen, qr_imagen, usuario_id) VALUES (1, 'Tienda de vinos', 'VinoCasa', 'En la zona gourmet', "https://res.cloudinary.com/dijr92ntz/image/upload/v1718683405/avatars/i3qpxfcrmeajasjmcoj3.jpg", "ksnewnduwwd", 1);
INSERT INTO tiendas (sede_id, descripcion, nombre_tienda, ubicacion_mapa, imagen, qr_imagen, usuario_id) VALUES (2, 'Tienda de instrumentos musicales', 'MusicStore', 'En la calle principal', "https://res.cloudinary.com/dijr92ntz/image/upload/v1718683405/avatars/i3qpxfcrmeajasjmcoj3.jpg", "ksnewnduwwd", 1);
INSERT INTO tiendas (sede_id, descripcion, nombre_tienda, ubicacion_mapa, imagen, qr_imagen, usuario_id) VALUES (3, 'Tienda de muebles', 'Muebles El Arte', 'En el distrito comercial', "https://res.cloudinary.com/dijr92ntz/image/upload/v1718683405/avatars/i3qpxfcrmeajasjmcoj3.jpg", "ksnewnduwwd", 1);
INSERT INTO tiendas (sede_id, descripcion, nombre_tienda, ubicacion_mapa, imagen, qr_imagen, usuario_id) VALUES (1, 'Tienda de perfumes', 'Perfumería Lux', 'En el centro de la ciudad', "https://res.cloudinary.com/dijr92ntz/image/upload/v1718683405/avatars/i3qpxfcrmeajasjmcoj3.jpg", "ksnewnduwwd", 1);

INSERT INTO `horarios_tienda` (`hora_apertura`, `hora_cierre`, `id_horario`, `tienda_id`, `estado`) VALUES ('00:00:00.000000', '06:00:00.000000', NULL, '1', NULL), ('01:00:00.000000', '07:00:00.000000', NULL, '7', NULL), ('06:00:00.000000', '12:00:00.000000', NULL, '4', NULL), ('07:00:00.000000', '11:30:00.000000', NULL, '8', NULL), ('13:00:00.000000', '19:00:00.000000', NULL, '2', NULL), ('14:00:00.000000', '20:00:00.000000', NULL, '9', NULL), ('08:00:00.000000', '18:00:00.000000', NULL, '3', NULL), ('09:00:00.000000', '17:00:00.000000', NULL, '6', NULL), ('16:00:00.000000', '23:00:00.000000', NULL, '5', NULL), ('17:00:00.000000', '00:00:00.000000', NULL, '10', NULL);

INSERT INTO categorias (nombre_categoria, descripcion_categoria, fecha_creacion) VALUES ('Deportes', 'Artículos y ropa deportiva', CURRENT_TIMESTAMP);
INSERT INTO categorias (nombre_categoria, descripcion_categoria, fecha_creacion) VALUES ('Tecnología', 'Productos electrónicos y gadgets', CURRENT_TIMESTAMP);
INSERT INTO categorias (nombre_categoria, descripcion_categoria, fecha_creacion) VALUES ('Ropa', 'Moda para hombres, mujeres y niños', CURRENT_TIMESTAMP);
INSERT INTO categorias (nombre_categoria, descripcion_categoria, fecha_creacion) VALUES ('Libros', 'Libros y material educativo', CURRENT_TIMESTAMP);
INSERT INTO categorias (nombre_categoria, descripcion_categoria, fecha_creacion) VALUES ('Juguetes', 'Juguetes para todas las edades', CURRENT_TIMESTAMP);
INSERT INTO categorias (nombre_categoria, descripcion_categoria, fecha_creacion) VALUES ('Electrodomésticos', 'Artículos para el hogar', CURRENT_TIMESTAMP);
INSERT INTO categorias (nombre_categoria, descripcion_categoria, fecha_creacion) VALUES ('Vinos', 'Vinos nacionales e internacionales', CURRENT_TIMESTAMP);
INSERT INTO categorias (nombre_categoria, descripcion_categoria, fecha_creacion) VALUES ('Instrumentos', 'Instrumentos musicales de calidad', CURRENT_TIMESTAMP);
INSERT INTO categorias (nombre_categoria, descripcion_categoria, fecha_creacion) VALUES ('Muebles', 'Muebles modernos y clásicos', CURRENT_TIMESTAMP);
INSERT INTO categorias (nombre_categoria, descripcion_categoria, fecha_creacion) VALUES ('Perfumería', 'Perfumes de alta gama', CURRENT_TIMESTAMP);

INSERT INTO productos (nombre, descripcion, precio, stock, fecha_creacion, categoria_id, tienda_id, imagen) VALUES ('Balón de Fútbol', 'Balón profesional FIFA', 50.00, 100, CURRENT_TIMESTAMP, 1, 1, "https://res.cloudinary.com/dijr92ntz/image/upload/v1718683405/avatars/i3qpxfcrmeajasjmcoj3.jpg");
INSERT INTO productos (nombre, descripcion, precio, stock, fecha_creacion, categoria_id, tienda_id, imagen) VALUES ('Auriculares Bluetooth', 'Auriculares inalámbricos con cancelación de ruido', 120.00, 50, CURRENT_TIMESTAMP, 2, 3, "https://res.cloudinary.com/dijr92ntz/image/upload/v1718683405/avatars/i3qpxfcrmeajasjmcoj3.jpg");
INSERT INTO productos (nombre, descripcion, precio, stock, fecha_creacion, categoria_id, tienda_id, imagen) VALUES ('Camiseta Casual', 'Camiseta de algodón para hombre', 20.00, 200, CURRENT_TIMESTAMP, 3, 2, "https://res.cloudinary.com/dijr92ntz/image/upload/v1718683405/avatars/i3qpxfcrmeajasjmcoj3.jpg");
INSERT INTO productos (nombre, descripcion, precio, stock, fecha_creacion, categoria_id, tienda_id, imagen) VALUES ('Libro: El Principito', 'Edición especial ilustrada', 15.00, 150, CURRENT_TIMESTAMP, 4, 4, "https://res.cloudinary.com/dijr92ntz/image/upload/v1718683405/avatars/i3qpxfcrmeajasjmcoj3.jpg");
INSERT INTO productos (nombre, descripcion, precio, stock, fecha_creacion, categoria_id, tienda_id, imagen) VALUES ('Muñeca Barbie', 'Barbie edición limitada', 35.00, 75, CURRENT_TIMESTAMP, 5, 5, "https://res.cloudinary.com/dijr92ntz/image/upload/v1718683405/avatars/i3qpxfcrmeajasjmcoj3.jpg");
INSERT INTO productos (nombre, descripcion, precio, stock, fecha_creacion, categoria_id, tienda_id, imagen) VALUES ('Refrigerador', 'Refrigerador Samsung de última generación', 800.00, 10, CURRENT_TIMESTAMP, 6, 6, "https://res.cloudinary.com/dijr92ntz/image/upload/v1718683405/avatars/i3qpxfcrmeajasjmcoj3.jpg");
INSERT INTO productos (nombre, descripcion, precio, stock, fecha_creacion, categoria_id, tienda_id, imagen) VALUES ('Vino Tinto Reserva', 'Vino tinto reserva especial', 25.00, 120, CURRENT_TIMESTAMP, 7, 7, "https://res.cloudinary.com/dijr92ntz/image/upload/v1718683405/avatars/i3qpxfcrmeajasjmcoj3.jpg");
INSERT INTO productos (nombre, descripcion, precio, stock, fecha_creacion, categoria_id, tienda_id, imagen) VALUES ('Guitarra Acústica', 'Guitarra acústica Yamaha', 150.00, 30, CURRENT_TIMESTAMP, 8, 8, "https://res.cloudinary.com/dijr92ntz/image/upload/v1718683405/avatars/i3qpxfcrmeajasjmcoj3.jpg");
INSERT INTO productos (nombre, descripcion, precio, stock, fecha_creacion, categoria_id, tienda_id, imagen) VALUES ('Sofá Moderno', 'Sofá de 3 plazas, estilo moderno', 300.00, 20, CURRENT_TIMESTAMP, 9, 9, "https://res.cloudinary.com/dijr92ntz/image/upload/v1718683405/avatars/i3qpxfcrmeajasjmcoj3.jpg");
INSERT INTO productos (nombre, descripcion, precio, stock, fecha_creacion, categoria_id, tienda_id, imagen) VALUES ('Perfume Chanel', 'Perfume para mujer Chanel Nº5', 95.00, 60, CURRENT_TIMESTAMP, 10, 10, "https://res.cloudinary.com/dijr92ntz/image/upload/v1718683405/avatars/i3qpxfcrmeajasjmcoj3.jpg");

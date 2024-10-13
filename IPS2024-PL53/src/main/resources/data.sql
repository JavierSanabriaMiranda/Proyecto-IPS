--Datos para carga inicial de la base de datos


DELETE FROM EMPLEADO_NO_DEPORTIVO;
-- Inserciones válidas para la tabla EMPLEADO_NO_DEPORTIVO
INSERT INTO EMPLEADO_NO_DEPORTIVO (ID_EMPLEADO_NO_DEP, DNI, NOMBRE, APELLIDO, FECHA_NACIMIENTO, TELEFONO, POSICION, SALARIO_ANUAL)
VALUES
    ('E0000001', '12345678A', 'Carlos', 'García', '1985-01-15', '600123456', 'gerente', 45000.50),
    ('E0000002', '23456789B', 'Laura', 'Pérez', '1990-06-20', '600234567', 'vendedor de entradas/abonos', 30000.00),
    ('E0000003', '34567890C', 'Miguel', 'López', '1988-03-10', '600345678', 'encargado de tienda', 32000.75),
    ('E0000004', '45678901D', 'Ana', 'Martínez', '1995-11-25', '600456789', 'gestor de instalaciones', 38000.80),
    ('E0000005', '56789012E', 'Javier', 'Sánchez', '1982-05-05', '600567890', 'empleado de tienda', 28000.40),
    ('E0000006', '67890123F', 'Clara', 'Hernández', '1993-08-15', '600678901', 'empleado de jardineria', 27000.60),
    ('E0000007', '78901234G', 'Sofia', 'Torres', '1997-02-28', '600789012', 'empleado de cocina', 26000.30),
    ('E0000008', '89012345H', 'Pedro', 'González', '1984-09-17', '600890123', 'director de comunicaciones', 50000.00);



-- Inserción de registros en la tabla INSTALACION
DELETE FROM INSTALACION;
INSERT INTO INSTALACION (COD_INSTALACION) VALUES ('ZONA_ENTRENAMIENTO_1');
INSERT INTO INSTALACION (COD_INSTALACION) VALUES ('ZONA_ENTRENAMIENTO_2');
INSERT INTO INSTALACION (COD_INSTALACION) VALUES ('GIMNASIO_PRINCIPAL');
INSERT INTO INSTALACION (COD_INSTALACION) VALUES ('CAMPO_JUEGO_1');
INSERT INTO INSTALACION (COD_INSTALACION) VALUES ('CAMPO_JUEGO_2');

-- Insertar datos en la tabla CLIENTE
DELETE FROM CLIENTE;
INSERT INTO CLIENTE (DNI, NOMBRE) VALUES
('12345678A', 'Juan Perez'),
('87654321B', 'Maria Lopez'),
('45678912C', 'Carlos Ramirez'),
('78965432D', 'Laura Martinez'),
('15975328E', 'Ana Garcia');

-- Insertar datos en la tabla VENTAS (relacionados con los clientes)
DELETE FROM VENTAS;
INSERT INTO VENTAS (ID_VENTAS, DNI, FECHA, COSTE) VALUES
('V001', '12345678A', '2024-10-09', 150.00),
('V002', '87654321B', '2024-10-10', 200.50),
('V003', '45678912C', '2024-10-12', 175.75),
('V004', '78965432D', '2024-10-09', 180.00),
('V005', '15975328E', '2024-10-12', 220.00);

-- Insertar datos en la tabla RESERVA (relacionados con las ventas e instalaciones)
DELETE FROM RESERVA;
INSERT INTO RESERVA (COD_RESERVA, HORA_FIN, HORA_INICIO, COD_INSTALACION, N_TARJETA) VALUES
('V001', '14:00:00', '12:00:00',  'ZONA_ENTRENAMIENTO_1', '123456789012345678901234'),
('V002', '16:00:00', '14:00:00', 'ZONA_ENTRENAMIENTO_2', '123456789012345678901235'),
('V003', '18:00:00', '16:00:00',  'GIMNASIO_PRINCIPAL', '123456789012345678901236'),
('V004', '10:00:00', '08:00:00',  'CAMPO_JUEGO_1', '123456789012345678901237'),
('V005', '14:00:00', '13:00:00',  'CAMPO_JUEGO_2', '123456789012345678901238');

INSERT INTO EQUIPO (ID_EQUIPO)
VALUES
('EQUIPO001'),
('EQUIPO002'),
('EQUIPO003'),
('EQUIPO004'),
('EQUIPO005');

--Insercion de registros en la tabla PARTIDO
DELETE FROM PARTIDO;
INSERT INTO PARTIDO(ID_PARTIDO, HORA_FIN, HORA_INICIO, FECHA, ID_EQUIPO)
VALUES
	('P000000001','10:00:00','09:00:00','2024-04-10','EQUIPO001'),
	('P000000002','11:00:00','10:00:00','2024-04-10','EQUIPO002'),
	('P000000003','12:00:00','10:00:00','2024-04-10','EQUIPO003');



-- Insertar en la tabla ENTRENAMIENTO (relacionados con las instalaciones y el equipo)
INSERT INTO ENTRENAMIENTO (ID_ENTRENAMIENTO, FECHA, HORA_INICIO, HORA_FIN, COD_INSTALACION, ID_EQUIPO)
VALUES
('ENT001', '2024-10-10', '10:00:00', '12:00:00', 'ZONA_ENTRENAMIENTO_1', 'EQUIPO001'),
('ENT002', '2024-10-11', '14:00:00', '16:00:00', 'GIMNASIO_PRINCIPAL', 'EQUIPO002'),
('ENT003', '2024-10-12', '09:00:00', '11:00:00', 'CAMPO_JUEGO_2', 'EQUIPO003'),
('ENT004', '2024-10-12', '17:00:00', '19:00:00', 'CAMPO_JUEGO_2', 'EQUIPO004'),
('ENT005', '2024-10-14', '08:00:00', '10:00:00', 'ZONA_ENTRENAMIENTO_2', 'EQUIPO005');


--Insercion de registros en la tabla
--DELETE FROM PRODUCTO;
--INSERT INTO PRODUCTO(CODPRODUCTO, TIPO, NOMBRE, PRECIO, UNIDADES, CODCOMPRA)
--VALUES
--    ('EQ01','equipacion','Camiseta Primera Equipacion',64.95,0,NULL),
--    ('EQ02','equipacion','Camiseta Segunda Equipacion',64.95,0,NULL),
--    ('EQ03','equipacion','Camiseta Tercera Equipacion',64.95,0,NULL),
--    ('EQ04','equipacion','Camiseta Personalizada',20.00,0,NULL),
--    ('MO01','moda textil','Calcertines',9.95,0,NULL),
--    ('MO02','moda textil','Camiseta de Calle',25.00,0,NULL),
----    ('MO03','moda textil','Camiseta de Entrenamiento',29.95,0,NULL),
--    ('MO04','moda textil','Sudadera',45.00,0,NULL),
--    ('MO05','moda textil','Plumas',59.00,0,NULL),
--    ('MO06','moda textil','Chubasquero',39.00,0,NULL),
--    ('MO07','moda textil','Sudadera de Entrenamiento',55.00,0,NULL),
--    ('MO08','moda textil','Polo',44.95,0,NULL),
--    ('AC01','accesorio','Balon de Futbol',22.50,0,NULL),
--    ('AC02','accesorio','Bolsa de Tela',9.90,0,NULL),
--    ('AC03','accesorio','Braga de Cuello',11.50,0,NULL),
----    ('AC04','accesorio','Bufanda Blanqui-Negra',12.00,0,NULL),
--    ('AC05','accesorio','Bufanda Rosa',12.00,0,NULL),
--    ('AC06','accesorio','Gorro de Lana',18.00,0,NULL),
--    ('AC07','accesorio','Guantes de Lana',12.50,0,NULL),
--    ('AC08','accesorio','Llavero',5.00,0,NULL),
--    ('AC09','accesorio','Zapatillas de Casa',22.50,0,NULL);
--

-- Insertar en la tabla EQUIPO
INSERT INTO EQUIPO (ID_EQUIPO)
VALUES ('EQ001'),
       ('EQ002'),
       ('EQ003'),
	   ('EQ004'),
       ('EQ005'),
       ('EQ006'),
       ('EQ007'),
       ('EQ008'),
       ('EQ009');
       
-- Insertar equipos profesionales
INSERT INTO EQUIPO_PROFESIONAL (ID_EQUIPO, ID_PROFESIONAL)
VALUES ('EQ001', NULL),
       ('EQ002', 'EQ001'),
       ('EQ003', NULL);
       
-- Insertar equipos de formación
INSERT INTO EQUIPO_FORMACION (ID_EQUIPO, CATEGORIA)
VALUES ('EQ004', 'juvenil'),
       ('EQ005', 'cadete'),
       ('EQ006', 'infantil'),
       ('EQ007', 'alevin'),
       ('EQ008', 'benjamin'),
       ('EQ009', 'pre_benjamin');


-- INSERCION DE JUGADORES CON EQUIPO


-- Insertar en la tabla EMPLEADO_DEPORTIVO
INSERT INTO EMPLEADO_DEPORTIVO (ID_EMPLEADO_DEP, DNI, NOMBRE, APELLIDO, FECHA_NACIMIENTO, TELEFONO, SALARIO_ANUAL)
VALUES ('EMP001', '12345678A', 'Juan', 'Pérez', '1990-01-15', '600123456', 30000.00),
       ('EMP002', '87654321B', 'Carlos', 'López', '1985-07-22', '600654321', 32000.00),
       ('EMP003', '11223344C', 'María', 'Martínez', '1992-05-30', '600789012', 31000.00);

-- Insertar en la tabla JUGADOR, relacionando a los empleados con equipos
INSERT INTO JUGADOR (ID_JUGADOR, ID_EQUIPO)
VALUES ('EMP001', 'EQ001'),
       ('EMP002', 'EQ002'),
       ('EMP003', 'EQ003');
       
       
-- INSERCION DE JUGADORES SIN EQUIPO


-- Insertar en la tabla EMPLEADO_DEPORTIVO
INSERT INTO EMPLEADO_DEPORTIVO (ID_EMPLEADO_DEP, DNI, NOMBRE, APELLIDO, FECHA_NACIMIENTO, TELEFONO, SALARIO_ANUAL)
VALUES ('EMP004', '33445566D', 'Ana', 'Gómez', '1988-03-20', '600345678', 28000.00),
       ('EMP005', '55667788E', 'Luis', 'Fernández', '1991-09-10', '600567890', 29000.00),
       ('EMP006', '77889900F', 'Sofía', 'Díaz', '1993-12-15', '600987654', 27000.00),
       ('EMP007', '11112222A', 'Carlos', 'Martínez', '1987-01-05', '600123456', 30000.00),
	   ('EMP008', '22223333B', 'Elena', 'López', '1990-02-14', '600234567', 31000.00),
	   ('EMP009', '33334444C', 'Jorge', 'Pérez', '1992-03-25', '600345678', 32000.00),
	   ('EMP010', '44445555D', 'Marta', 'Hernández', '1994-04-16', '600456789', 33000.00),
	   ('EMP011', '55556666E', 'David', 'García', '1989-05-10', '600567890', 34000.00),
	   ('EMP012', '66667777F', 'Laura', 'Alonso', '1991-06-20', '600678901', 35000.00),
	   ('EMP013', '77778888G', 'Sergio', 'Ramírez', '1993-07-15', '600789012', 36000.00);

-- Insertar en la tabla JUGADOR, dejando ID_EQUIPO como NULL
INSERT INTO JUGADOR (ID_JUGADOR, ID_EQUIPO)
VALUES ('EMP004', NULL),
       ('EMP005', NULL),
       ('EMP006', NULL),
       ('EMP007', NULL),
	   ('EMP008', NULL),
	   ('EMP009', NULL),
	   ('EMP010', NULL),
	   ('EMP011', NULL),
	   ('EMP012', NULL),
	   ('EMP013', NULL);


-- INSERCION DE ENTRENADORES CON EQUIPO

-- Insertar en la tabla EMPLEADO_DEPORTIVO
INSERT INTO EMPLEADO_DEPORTIVO (ID_EMPLEADO_DEP, DNI, NOMBRE, APELLIDO, FECHA_NACIMIENTO, TELEFONO, SALARIO_ANUAL)
VALUES ('EMP024', '99887766G', 'Pedro', 'Ramírez', '1975-04-10', '601234567', 45000.00),
       ('EMP025', '66554433H', 'Jorge', 'Santos', '1980-11-25', '601345678', 47000.00),
       ('EMP026', '44332211I', 'Lucía', 'Blanco', '1982-02-18', '601456789', 46000.00);

-- Insertar en la tabla ENTRENADOR, relacionando a los empleados con equipos y estableciendo su posición
INSERT INTO ENTRENADOR (ID_ENTRENADOR, ID_EQUIPO, POSICION_ENTRENADOR)
VALUES ('EMP024', 'EQ004', 1),
       ('EMP025', 'EQ005', 2),
       ('EMP026', 'EQ006', 1);


-- INSERCION DE ENTRENADORES SIN EQUIPO

-- Insertar en la tabla EMPLEADO_DEPORTIVO
INSERT INTO EMPLEADO_DEPORTIVO (ID_EMPLEADO_DEP, DNI, NOMBRE, APELLIDO, FECHA_NACIMIENTO, TELEFONO, SALARIO_ANUAL)
VALUES ('EMP014', '12344321J', 'Andrea', 'García', '1978-08-30', '601567890', 44000.00),
       ('EMP015', '56781234K', 'Roberto', 'Luna', '1983-06-12', '601678901', 43000.00),
       ('EMP016', '87654321L', 'Isabel', 'Moreno', '1976-03-05', '601789012', 42000.00),
       ('EMP017', '11111111M', 'Carlos', 'Martínez', '1980-01-10', '601123456', 41000.00),
	   ('EMP018', '22222222N', 'Elena', 'Rodríguez', '1975-05-15', '601234567', 40000.00),
	   ('EMP019', '33333333O', 'Mario', 'Sánchez', '1982-09-20', '601345678', 45000.00),
	   ('EMP020', '44444444P', 'Lucía', 'Gómez', '1988-11-02', '601456789', 46000.00),
	   ('EMP021', '55555555Q', 'José', 'Díaz', '1979-07-23', '601567890', 47000.00),
	   ('EMP022', '66666666R', 'Marta', 'Ruiz', '1985-03-08', '601678901', 48000.00),
	   ('EMP023', '77777777S', 'David', 'Vega', '1983-12-25', '601789012', 49000.00);

-- Insertar en la tabla ENTRENADOR, dejando ID_EQUIPO como NULL y asignando la posición
INSERT INTO ENTRENADOR (ID_ENTRENADOR, ID_EQUIPO, POSICION_ENTRENADOR)
VALUES ('EMP014', NULL, 1),
       ('EMP015', NULL, 2),
       ('EMP016', NULL, 1),
       ('EMP017', NULL, 1),
	   ('EMP018', NULL, 2),
	   ('EMP019', NULL, 1),
	   ('EMP020', NULL, 2),
	   ('EMP021', NULL, 1),
	   ('EMP022', NULL, 2),
	   ('EMP023', NULL, 1);





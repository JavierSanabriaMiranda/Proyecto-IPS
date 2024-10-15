
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
DELETE FROM PRODUCTO;
INSERT INTO PRODUCTO(CODPRODUCTO, TIPO, NOMBRE, PRECIO)
VALUES
    ('EQ01','equipacion','Camiseta Primera Equipacion',64.95),
    ('EQ02','equipacion','Camiseta Segunda Equipacion',64.95),
    ('EQ03','equipacion','Camiseta Tercera Equipacion',64.95),
    ('EQ04','equipacion','Camiseta Personalizada',20.00),
    ('MO01','moda textil','Calcetines',9.95),
    ('MO02','moda textil','Camiseta de Calle',25.00),
    ('MO03','moda textil','Camiseta de Entrenamiento',29.95),
    ('MO04','moda textil','Sudadera',45.00),
    ('MO05','moda textil','Plumas',59.00),
    ('MO06','moda textil','Chubasquero',39.00),
    ('MO07','moda textil','Sudadera de Entrenamiento',55.00),
    ('MO08','moda textil','Polo',44.95),
    ('AC01','accesorio','Balon de Futbol',22.50),
    ('AC02','accesorio','Bolsa de Tela',9.90),
    ('AC03','accesorio','Braga de Cuello',11.50),
    ('AC04','accesorio','Bufanda Blanqui-Negra',12.00),
    ('AC05','accesorio','Bufanda Rosa',12.00),
    ('AC06','accesorio','Gorro de Lana',18.00),
    ('AC07','accesorio','Guantes de Lana',12.50),
    ('AC08','accesorio','Llavero',5.00),
    ('AC09','accesorio','Zapatillas de Casa',22.50);

-- Insertar turnos en la tabla TURNO (estos IDs coinciden con los de las otras tablas)
DELETE FROM TURNO;
INSERT INTO TURNO (ID_TURNO, ID_EMPLEADO, HORA_INICIO, HORA_FIN)
VALUES
    ('T001', 'E0000001', '09:00:00', '13:00:00'),
    ('T002', 'E0000001', '14:00:00', '18:00:00'),
    ('T003', 'E0000002', '09:00:00', '13:00:00'),
    ('T004', 'E0000002', '14:00:00', '18:00:00'),
    ('T005', 'E0000003', '09:00:00', '13:00:00'),
    ('T006', 'E0000003', '14:00:00', '18:00:00'),
    ('T007', 'E0000004', '09:00:00', '13:00:00'),
    ('T008', 'E0000004', '14:00:00', '18:00:00');

-- Turnos semanales, asegurando que los IDs coincidan con la tabla TURNO
DELETE FROM TURNO_SEMANAL;
INSERT INTO TURNO_SEMANAL (ID_TURNO, ID_EMPLEADO, DIA_SEMANA)
VALUES
    ('T001', 'E0000001', 1),
    ('T003', 'E0000002', 1),
    ('T005', 'E0000003', 3),
    ('T007', 'E0000004', 3);


-- Turnos puntuales, asegurando que los IDs coincidan con la tabla TURNO
DELETE FROM TURNO_PUNTUAL;
INSERT INTO TURNO_PUNTUAL (ID_TURNO, ID_EMPLEADO, DIA)
VALUES
    ('T002', 'E0000001', '2024-10-14'),
    ('T004', 'E0000002', '2024-10-15'),
    ('T006', 'E0000003', '2024-10-17'),
    ('T008', 'E0000004', '2024-10-17');


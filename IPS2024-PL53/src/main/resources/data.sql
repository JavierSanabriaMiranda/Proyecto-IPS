
--Datos para carga inicial de la base de datos

-- Inserciones válidas para la tabla USUARIO
DELETE FROM USUARIO;
INSERT INTO USUARIO (ID_USUARIO, NOMBRE_USUARIO, CONTRASEÑA) 
VALUES 
    ('E0000001', 'cgarcia', 'password1'),
    ('E0000002', 'lperez', 'password2'),
    ('E0000003', 'mlopez', 'password3'),
    ('E0000004', 'amartinez', 'password4'),
    ('E0000005', 'jsanchez', 'password5'),
    ('E0000006', 'chernandez', 'password6'),
    ('E0000007', 'storres', 'password7'),
    ('E0000008', 'pgonzalez', 'password8'),
    ('E1000009', 'mgarcia', 'password9'),
    ('EMP001', 'juan.perez', 'password123'),
    ('EMP002', 'carlos.lopez', 'password123'),
    ('EMP003', 'maria.martinez1', 'password123'),
    ('EMP100', 'maria.martinez2', 'password123'),
    ('EMP101', 'maria.martinez3', 'password123'),
    ('EMP102', 'maria.martinez4', 'password123'),
    ('EMP004', 'ana.gomez', 'password123'),
	('EMP005', 'luis.fernandez', 'password123'),
    ('EMP006', 'sofia.diaz', 'password123'),
    ('EMP007', 'carlos.martinez', 'password123'),
    ('EMP008', 'elena.lopez', 'password123'),
    ('EMP009', 'jorge.perez', 'password123'),
    ('EMP010', 'marta.hernandez', 'password123'),
    ('EMP011', 'david.garcia', 'password123'),
    ('EMP012', 'laura.alonso', 'password123'),
    ('EMP013', 'sergio.ramirez', 'password123'),
    ('EMP024', 'pedro.ramirez', 'password123'),
    ('EMP025', 'jorge.santos', 'password123'),
    ('EMP026', 'lucia.blanco', 'password123'),
    ('EMP014', 'andrea.garcia', 'password123'),
    ('EMP015', 'roberto.luna', 'password123'),
    ('EMP016', 'isabel.moreno', 'password123'),
    ('EMP017', 'carlos.martinez2', 'password123'),
    ('EMP018', 'elena.rodriguez', 'password123'),
    ('EMP019', 'mario.sanchez', 'password123'),
    ('EMP020', 'lucia.gomez', 'password123'),
    ('EMP021', 'jose.diaz', 'password123'),
    ('EMP022', 'marta.ruiz', 'password123'),
    ('EMP023', 'david.vega', 'password123'),
    ('EMP030', 'raul.gimenez', 'password123'),
    ('EMP031', 'alberto.nunez', 'password123'),
    ('EMP032', 'sergio.cruz', 'password123'),
    ('EMP033', 'pablo.morales', 'password123'),
    ('EMP034', 'marcos.garcia', 'password123'),
    ('EMP035', 'diego.sanchez', 'password123'),
    ('EMP036', 'ivan.perez', 'password123'),
    ('EMP037', 'lucas.martinez', 'password123'),
    ('EMP038', 'fernando.hernandez', 'password123'),
    ('EMP039', 'andres.jimenez', 'password123'),
    ('EMP040', 'jorge.lopez', 'password123'),
    ('EMP041', 'cesar.gomez', 'password123'),
    ('EMP042', 'tomas.sanz', 'password123'),
    ('EMP043', 'emilio.santos', 'password123'),
    ('EMP044', 'adrian.romero', 'password123'),
    ('EMP045', 'alejandro.vega', 'password123'),
    ('EMP046', 'manuel.duarte', 'password123'),
    ('EMP047', 'francisco.blanco', 'password123'),
    ('EMP048', 'hugo.castro', 'password123'),
    ('EMP049', 'mario.alonso', 'password123'),
    ('EMP050', 'rodrigo.bautista', 'password123'),
    ('EMP051', 'raul.reyes', 'password123'),
    ('EMP052', 'daniel.montero', 'password123'),
    ('EMP053', 'carlos.ortiz', 'password123'),
    ('EMP054', 'jose.nieto', 'password123'),
    ('EMP055', 'santiago.fernandez', 'password123'),
    ('EMP056', 'martin.herrera', 'password123'),
    ('EMP057', 'alonso.bravo', 'password123'),
    ('EMP058', 'samuel.navarro', 'password123'),
    ('EMP059', 'gonzalo.diaz', 'password123'),
    ('EMP060', 'david.benitez', 'password123'),
    ('EMP061', 'eric.castilla', 'password123'),
    ('EMP062', 'alvaro.aguilar', 'password123'),
    ('EMP063', 'miguel.torres', 'password123'),
    ('EMP064', 'ivan.mendez', 'password123'),
    ('EMP065', 'pablo.perez', 'password123'),
    ('EMP066', 'lucas.rey', 'password123'),
    ('EMP067', 'diego.silva', 'password123'),
    ('EMP068', 'victor.gutierrez', 'password123'),
    ('EMP069', 'jaime.campos', 'password123'),
    ('EMP070', 'oscar.gil', 'password123'),
    ('EMP071', 'adrian.pascual', 'password123'),
    ('EMP072', 'rafael.quintana', 'password123'),
    ('EMP073', 'hector.garcia', 'password123'),
    ('EMP074', 'felipe.cabrera', 'password123'),
    ('EMP075', 'nicolas.pena', 'password123'),
    ('EMP076', 'eduardo.lara', 'password123'),
    ('EMP077', 'martin.ortega', 'password123'),
    ('EMP078', 'jose.ruiz', 'password123'),
    ('EMP079', 'bruno.hernandez', 'password123'),
    ('EMP080', 'julio.castro', 'password123'),
    ('EMP081', 'antonio.vargas', 'password123'),
    ('EMP082', 'ismael.lopez', 'password123'),
    ('EMP083', 'gabriel.davila', 'password123'),
    ('01', 'juan.jose2', 'password123');
    


-- Inserciones válidas para la tabla EMPLEADO_NO_DEPORTIVO
DELETE FROM EMPLEADO_NO_DEPORTIVO;
INSERT INTO EMPLEADO_NO_DEPORTIVO (ID_EMPLEADO_NO_DEP, DNI, NOMBRE, APELLIDO, FECHA_NACIMIENTO, TELEFONO, POSICION, SALARIO_ANUAL)
VALUES
    ('E0000001', '12345678A', 'Carlos', 'García', '1985-01-15', '600123456', 'gerente', 45000.50),
    ('E0000002', '23456789B', 'Laura', 'Pérez', '1990-06-20', '600234567', 'vendedor de entradas/abonos', 30000.00),
    ('E0000003', '34567890C', 'Miguel', 'López', '1988-03-10', '600345678', 'encargado de tienda', 32000.75),
    ('E0000004', '45678901D', 'Ana', 'Martínez', '1995-11-25', '600456789', 'gestor de instalaciones', 38000.80),
    ('E0000005', '56789012E', 'Javier', 'Sánchez', '1982-05-05', '600567890', 'empleado de tienda', 28000.40),
    ('E0000006', '67890123F', 'Clara', 'Hernández', '1993-08-15', '600678901', 'empleado de jardineria', 27000.60),
    ('E0000007', '78901234G', 'Sofia', 'Torres', '1997-02-28', '600789012', 'empleado de cocina', 26000.30),
    ('E0000008', '89012345H', 'Pedro', 'González', '1984-09-17', '600890123', 'director de comunicaciones', 50000.00),
    ('E1000009', '27394280J', 'Marcos', 'García', '1995-04-10', '600236743', 'empleado de jardineria', 27000.60);



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
('15975328E', 'Ana Garcia'),
('15975338E', 'Pepe Cosmen');

-- Insertar datos en la tabla VENTAS (relacionados con los clientes)
DELETE FROM VENTAS;
INSERT INTO VENTAS (ID_VENTAS, DNI, FECHA, COSTE) VALUES
('V001', '12345678A', '2024-10-20', 150.00),
('V002', '87654321B', '2024-10-21', 200.50),
('V003', '45678912C', '2024-10-22', 175.75),
('V004', '78965432D', '2024-10-23', 180.00),
('V005', '15975328E', '2024-10-24', 220.00),
('V006', '15975338E', '2024-10-20', 20.00);


-- Insertar datos en la tabla RESERVA (relacionados con las ventas e instalaciones)
DELETE FROM RESERVA;
INSERT INTO RESERVA (COD_RESERVA, HORA_FIN, HORA_INICIO, COD_INSTALACION, FECHA_RESERVA, N_TARJETA) VALUES
('V001', '14:00:00', '12:00:00',  'ZONA_ENTRENAMIENTO_1', '2024-11-07', '123456789012345678901234'),
('V002', '16:00:00', '14:00:00', 'ZONA_ENTRENAMIENTO_2', '2024-10-20', '123456789012345678901235'),
('V003', '18:00:00', '16:00:00',  'GIMNASIO_PRINCIPAL','2024-11-07', '123456789012345678901236'),
('V004', '10:00:00', '08:00:00',  'CAMPO_JUEGO_1', '2024-10-23', '123456789012345678901237'),
('V005', '14:00:00', '13:00:00',  'CAMPO_JUEGO_2', '2024-10-24', '123456789012345678901238');

DELETE FROM EQUIPO;
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

--Insercion de registros en la tabla ASIENTO
DELETE FROM ASIENTO;
INSERT INTO ASIENTO VALUES 
	('A0001', 'A', 'A', 0, 0);

-- Insertar datos en la tabla ENTRADA (relacionadas con las ventas)
DELETE FROM ENTRADA;
INSERT INTO ENTRADA VALUES
    ('V006',  'P000000001', 'A0001');
  


-- Insertar en la tabla ENTRENAMIENTO (relacionados con las instalaciones y el equipo)
INSERT INTO ENTRENAMIENTO (ID_ENTRENAMIENTO, FECHA, HORA_INICIO, HORA_FIN, COD_INSTALACION, ID_EQUIPO)
VALUES
('ENT001', '2024-10-20', '09:00:00', '10:00:00', 'ZONA_ENTRENAMIENTO_1', 'EQUIPO001'),
('ENT002', '2024-10-31', '14:00:00', '16:00:00', 'GIMNASIO_PRINCIPAL', 'EQUIPO002'),
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
    ('T008', 'E0000004', '14:00:00', '18:00:00'),
    ('T009', 'E0000006', '09:00:00', '14:00:00'),
    ('T010', 'E1000009', '09:00:00', '14:00:00');

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
    ('T008', 'E0000004', '2024-10-17'),
	('T009', 'E0000006', '2024-11-07'),
	('T010', 'E1000009', '2024-11-07');

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
       ('EQ009', 'prebenjamin');


-- INSERCION DE JUGADORES CON EQUIPO


-- Insertar en la tabla EMPLEADO_DEPORTIVO
DELETE FROM EMPLEADO_DEPORTIVO;
INSERT INTO EMPLEADO_DEPORTIVO (ID_EMPLEADO_DEP, DNI, NOMBRE, APELLIDO, FECHA_NACIMIENTO, TELEFONO, SALARIO_ANUAL)
VALUES ('EMP001', '12345678A', 'Juan', 'Pérez', '1990-01-15', '600123456', 30000.00),
       ('EMP002', '87654321B', 'Carlos', 'López', '1985-07-22', '600654321', 32000.00),
       ('EMP003', '11223344C', 'María', 'Martínez', '1992-05-30', '600789012', 31000.00),
       ('EMP100', '22334455C', 'María', 'Martínez', '1992-05-30', '600789012', 31000.00),
       ('EMP101', '33445566C', 'María', 'Martínez', '1992-05-30', '600789012', 31000.00),
       ('EMP102', '44556677C', 'María', 'Martínez', '1992-05-30', '600789012', 31000.00);

-- Insertar en la tabla JUGADOR, relacionando a los empleados con equipos
DELETE FROM JUGADOR;
INSERT INTO JUGADOR (ID_JUGADOR, ID_EQUIPO)
VALUES ('EMP001', 'EQ001'),
       ('EMP002', 'EQ002'),
       ('EMP003', 'EQ003'),
       ('EMP100', 'EQUIPO001'),
       ('EMP101', 'EQUIPO002'),
       ('EMP102', 'EQUIPO003');


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
VALUES ('EMP024', 'EQ001', 1),
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
VALUES ('EMP014', NULL, NULL),
       ('EMP015', NULL, NULL),
       ('EMP016', NULL, NULL),
       ('EMP017', NULL, NULL),
	   ('EMP018', NULL, NULL),
	   ('EMP019', NULL, NULL),
	   ('EMP020', NULL, NULL),
	   ('EMP021', NULL, NULL),
	   ('EMP022', NULL, NULL),
	   ('EMP023', NULL, NULL);


-- INSERCION DE JUGADORES PARA CADA CATEGORIA

-- Jugadores categoría Juvenil
INSERT INTO EMPLEADO_DEPORTIVO (ID_EMPLEADO_DEP, DNI, NOMBRE, APELLIDO, FECHA_NACIMIENTO, TELEFONO, SALARIO_ANUAL)
VALUES ('EMP030', '10000001A', 'Raúl', 'Giménez', '2006-05-11', '601111111', 25000.00),
       ('EMP031', '10000002B', 'Alberto', 'Núñez', '2007-08-19', '601222222', 24000.00),
       ('EMP032', '10000003C', 'Sergio', 'Cruz', '2008-03-25', '601333333', 23000.00),
       ('EMP033', '10000004D', 'Pablo', 'Morales', '2006-11-30', '601444444', 26000.00),
       ('EMP034', '10000005E', 'Marcos', 'García', '2008-07-04', '601555555', 24000.00),
       ('EMP035', '10000006F', 'Diego', 'Sánchez', '2007-01-15', '601666666', 24500.00),
       ('EMP036', '10000007G', 'Iván', 'Pérez', '2006-02-20', '601777777', 25000.00),
       ('EMP037', '10000008H', 'Lucas', 'Martínez', '2007-06-18', '601888888', 24000.00),
       ('EMP038', '10000009I', 'Fernando', 'Hernández', '2008-10-22', '601999999', 23500.00);

-- Jugadores categoría Cadete
INSERT INTO EMPLEADO_DEPORTIVO (ID_EMPLEADO_DEP, DNI, NOMBRE, APELLIDO, FECHA_NACIMIENTO, TELEFONO, SALARIO_ANUAL)
VALUES ('EMP039', '20000001J', 'Andrés', 'Jiménez', '2009-03-12', '602111111', 23000.00),
       ('EMP040', '20000002K', 'Jorge', 'López', '2010-08-25', '602222222', 22000.00),
       ('EMP041', '20000003L', 'César', 'Gómez', '2009-06-14', '602333333', 21000.00),
       ('EMP042', '20000004M', 'Tomás', 'Sanz', '2010-02-18', '602444444', 21500.00),
       ('EMP043', '20000005N', 'Emilio', 'Santos', '2009-09-23', '602555555', 20500.00),
       ('EMP044', '20000006O', 'Adrián', 'Romero', '2009-04-07', '602666666', 22000.00),
       ('EMP045', '20000007P', 'Alejandro', 'Vega', '2010-11-19', '602777777', 21000.00),
       ('EMP046', '20000008Q', 'Manuel', 'Duarte', '2009-12-30', '602888888', 21500.00),
       ('EMP047', '20000009R', 'Francisco', 'Blanco', '2010-07-05', '602999999', 22000.00);

-- Jugadores categoría Infantil
INSERT INTO EMPLEADO_DEPORTIVO (ID_EMPLEADO_DEP, DNI, NOMBRE, APELLIDO, FECHA_NACIMIENTO, TELEFONO, SALARIO_ANUAL)
VALUES ('EMP048', '30000001S', 'Hugo', 'Castro', '2011-01-10', '603111111', 20000.00),
       ('EMP049', '30000002T', 'Mario', 'Alonso', '2012-06-25', '603222222', 19500.00),
       ('EMP050', '30000003U', 'Rodrigo', 'Bautista', '2011-03-14', '603333333', 20500.00),
       ('EMP051', '30000004V', 'Raúl', 'Reyes', '2012-10-29', '603444444', 19000.00),
       ('EMP052', '30000005W', 'Daniel', 'Montero', '2011-12-18', '603555555', 20000.00),
       ('EMP053', '30000006X', 'Carlos', 'Ortiz', '2011-04-23', '603666666', 19500.00),
       ('EMP054', '30000007Y', 'José', 'Nieto', '2012-07-17', '603777777', 20500.00),
       ('EMP055', '30000008Z', 'Santiago', 'Fernández', '2011-09-09', '603888888', 19500.00),
       ('EMP056', '30000009A', 'Martín', 'Herrera', '2012-08-05', '603999999', 20000.00);

-- Jugadores categoría Alevín
INSERT INTO EMPLEADO_DEPORTIVO (ID_EMPLEADO_DEP, DNI, NOMBRE, APELLIDO, FECHA_NACIMIENTO, TELEFONO, SALARIO_ANUAL)
VALUES ('EMP057', '40000001B', 'Alonso', 'Bravo', '2013-01-25', '604111111', 18000.00),
       ('EMP058', '40000002C', 'Samuel', 'Navarro', '2014-05-30', '604222222', 17500.00),
       ('EMP059', '40000003D', 'Gonzalo', 'Díaz', '2013-07-18', '604333333', 18000.00),
       ('EMP060', '40000004E', 'David', 'Benítez', '2014-02-27', '604444444', 17000.00),
       ('EMP061', '40000005F', 'Eric', 'Castilla', '2013-03-22', '604555555', 17500.00),
       ('EMP062', '40000006G', 'Álvaro', 'Aguilar', '2014-08-12', '604666666', 18000.00),
       ('EMP063', '40000007H', 'Miguel', 'Torres', '2013-06-04', '604777777', 17000.00),
       ('EMP064', '40000008I', 'Iván', 'Méndez', '2014-11-03', '604888888', 17500.00),
       ('EMP065', '40000009J', 'Pablo', 'Pérez', '2013-12-15', '604999999', 18000.00);

-- Jugadores categoría Benjamín
INSERT INTO EMPLEADO_DEPORTIVO (ID_EMPLEADO_DEP, DNI, NOMBRE, APELLIDO, FECHA_NACIMIENTO, TELEFONO, SALARIO_ANUAL)
VALUES ('EMP066', '50000001K', 'Lucas', 'Rey', '2015-01-08', '605111111', 16000.00),
       ('EMP067', '50000002L', 'Diego', 'Silva', '2016-09-24', '605222222', 15000.00),
       ('EMP068', '50000003M', 'Victor', 'Gutiérrez', '2015-03-20', '605333333', 16000.00),
       ('EMP069', '50000004N', 'Jaime', 'Campos', '2016-04-13', '605444444', 15000.00),
       ('EMP070', '50000005O', 'Óscar', 'Gil', '2015-11-21', '605555555', 15500.00),
       ('EMP071', '50000006P', 'Adrián', 'Pascual', '2016-05-06', '605666666', 15000.00),
       ('EMP072', '50000007Q', 'Rafael', 'Quintana', '2015-07-14', '605777777', 16000.00),
       ('EMP073', '50000008R', 'Héctor', 'García', '2016-02-22', '605888888', 15500.00),
       ('EMP074', '50000009S', 'Felipe', 'Cabrera', '2015-06-18', '605999999', 15000.00);

-- Jugadores categoría Pre-benjamín
INSERT INTO EMPLEADO_DEPORTIVO (ID_EMPLEADO_DEP, DNI, NOMBRE, APELLIDO, FECHA_NACIMIENTO, TELEFONO, SALARIO_ANUAL)
VALUES ('EMP075', '60000001T', 'Nicolás', 'Peña', '2017-01-09', '606111111', 14000.00),
       ('EMP076', '60000002U', 'Eduardo', 'Lara', '2018-04-29', '606222222', 13500.00),
       ('EMP077', '60000003V', 'Martín', 'Ortega', '2017-03-17', '606333333', 14000.00),
       ('EMP078', '60000004W', 'José', 'Ruiz', '2018-11-14', '606444444', 13000.00),
       ('EMP079', '60000005X', 'Bruno', 'Hernández', '2017-09-05', '606555555', 13500.00),
       ('EMP080', '60000006Y', 'Julio', 'Castro', '2018-06-23', '606666666', 14000.00),
       ('EMP081', '60000007Z', 'Antonio', 'Vargas', '2017-02-19', '606777777', 13500.00),
       ('EMP082', '60000008A', 'Ismael', 'López', '2018-08-16', '606888888', 14000.00),
       ('EMP083', '60000009B', 'Gabriel', 'Dávila', '2017-12-03', '606999999', 13000.00);

-- Insertar los jugadores en la tabla JUGADOR, sin equipo (ID_EQUIPO será NULL)
INSERT INTO JUGADOR (ID_JUGADOR, ID_EQUIPO)
VALUES ('EMP030', NULL),
       ('EMP031', NULL),
       ('EMP032', NULL),
       ('EMP033', NULL),
       ('EMP034', NULL),
       ('EMP035', NULL),
       ('EMP036', NULL),
       ('EMP037', NULL),
       ('EMP038', NULL),
       ('EMP039', NULL),
       ('EMP040', NULL),
       ('EMP041', NULL),
       ('EMP042', NULL),
       ('EMP043', NULL),
       ('EMP044', NULL),
       ('EMP045', NULL),
       ('EMP046', NULL),
       ('EMP047', NULL),
       ('EMP048', NULL),
       ('EMP049', NULL),
       ('EMP050', NULL),
       ('EMP051', NULL),
       ('EMP052', NULL),
       ('EMP053', NULL),
       ('EMP054', NULL),
       ('EMP055', NULL),
       ('EMP056', NULL),
       ('EMP057', NULL),
       ('EMP058', NULL),
       ('EMP059', NULL),
       ('EMP060', NULL),
       ('EMP061', NULL),
       ('EMP062', NULL),
       ('EMP063', NULL),
       ('EMP064', NULL),
       ('EMP065', NULL),
       ('EMP066', NULL),
       ('EMP067', NULL),
       ('EMP068', NULL),
       ('EMP069', NULL),
       ('EMP070', NULL),
       ('EMP071', NULL),
       ('EMP072', NULL),
       ('EMP073', NULL),
       ('EMP074', NULL),
       ('EMP075', NULL),
       ('EMP076', NULL),
       ('EMP077', NULL),
       ('EMP078', NULL),
       ('EMP079', NULL),
       ('EMP080', NULL),
       ('EMP081', NULL),
       ('EMP082', NULL),
       ('EMP083', NULL);


INSERT INTO RESERVA_JARDINERIA (COD_RESERVA_JARDINERIA, ID_JARDINERO, COD_INSTALACION, FECHA, HORA_INICIO, HORA_FIN) 
VALUES 
	('R000001', 'E0000006', 'GIMNASIO_PRINCIPAL', '2024-11-07', '09:00:00', '11:00:00');



INSERT INTO FRANJA_ENTREVISTA (ID_JUGADOR, FECHA, HORA_INICIO, HORA_FIN) VALUES
('EMP001', '2024-11-28', '09:00:00', '10:00:00'),
('EMP002', '2024-11-28', '10:30:00', '11:30:00'),
('EMP003', '2024-11-29', '09:30:00', '10:30:00'),
('EMP100', '2024-11-29', '14:00:00', '15:00:00');


INSERT INTO ENTREVISTA (COD_ENTREVISTA, ID_JUGADOR, FECHA, HORA_INICIO, HORA_FIN, MEDIO_COMUNICACION) VALUES
('E001', 'EMP001', '2024-11-28','09:00:00', '10:00:00', 'Teléfono'),
('E002', 'EMP002', '2024-11-28','10:30:00', '11:30:00', 'Email'),
('E003', 'EMP003', '2024-11-29', '09:30:00', '10:30:00', 'Videoconferencia');




INSERT INTO ACCIONISTA (ID_ACCIONISTA, DNI, NOMBRE) VALUES
    ('01', '1', 'Juan');


INSERT INTO ACCION (ID_ACCION, ID_ACCIONISTA, PRECIO, ISENVENTA) VALUES
('A001', '01', 100.50, TRUE),
('A002', '01', 150.75, FALSE),
('A003', '01', 200.00, TRUE),
('A004', '01', 250.25, FALSE),
('A005', '01', 300.00, TRUE),
('A006', '01', 300.00, TRUE),
('A007', '01', 300.00, TRUE),
('A008', '01', 300.00, FALSE),
('A009', '01', 300.00, TRUE),
('A010', '01', 300.00, FALSE);


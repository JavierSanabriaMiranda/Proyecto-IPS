
--Datos para carga inicial de la base de datos

--Para giis.demo.tkrun:
--delete from carreras;
--insert into carreras(id,inicio,fin,fecha,descr) values 
--	(100,'2016-10-05','2016-10-25','2016-11-09','finalizada'),
--	(101,'2016-10-05','2016-10-25','2016-11-10','en fase 3'),
--	(102,'2016-11-05','2016-11-09','2016-11-20','en fase 2'),
--	(103,'2016-11-10','2016-11-15','2016-11-21','en fase 1'),
--	(104,'2016-11-11','2016-11-15','2016-11-22','antes inscripcion');


DELETE FROM EMPLEADO_NO_DEPORTIVO;
-- Inserciones válidas para la tabla EMPLEADO_NO_DEPORTIVO
INSERT INTO EMPLEADO_NO_DEPORTIVO (ID_EMPLEADO_NO_DEP, DNI, NOMBRE, APELLIDO, FECHA_NACIMIENTO, TELEFONO, POSICION, SALARIO_ANUAL)
VALUES 
    ('E0000001', '12345678A', 'Carlos', 'García', '1985-01-15', '600123456', 'gerente', 45000.50),
    ('E0000002', '23456789B', 'Laura', 'Pérez', '1990-06-20', '600234567', 'vendedor de entradas/abonos', 30000.00),
    ('E0000003', '34567890C', 'Miguel', 'López', '1988-03-10', '600345678', 'encargado de tienda', 32000.75),
    ('E0000004', '45678901D', 'Ana', 'Martínez', '1995-11-25', '600456789', 'gestor de instalaciones', 38000.80),
    ('E0000005', '56789012E', 'Javier', 'Sánchez', '1982-05-05', '600567890', 'empleado de tienda', 28000.40),
    ('E0000006', '67890123F', 'Clara', 'Hernández', '1993-08-15', '600678901', 'empleado de jardinería', 27000.60),
    ('E0000007', '78901234G', 'Sofia', 'Torres', '1997-02-28', '600789012', 'empleado de cocina', 26000.30),
    ('E0000008', '89012345H', 'Pedro', 'González', '1984-09-17', '600890123', 'director de comunicaciones', 50000.00);



-- Inserción de registros en la tabla INSTALACION
DELETE FROM INSTALACION;
INSERT INTO INSTALACION (COD_INSTALACION) VALUES ('ZONA_ENTRENAMIENTO_1');
INSERT INTO INSTALACION (COD_INSTALACION) VALUES ('ZONA_ENTRENAMIENTO_2');
INSERT INTO INSTALACION (COD_INSTALACION) VALUES ('GIMNASIO_PRINCIPAL');
INSERT INTO INSTALACION (COD_INSTALACION) VALUES ('CAMPO_JUEGO_1');
INSERT INTO INSTALACION (COD_INSTALACION) VALUES ('CAMPO_JUEGO_2');


--Insercion de registros en la tabla EQUIPO
DELETE FROM EQUIPO;
INSERT INTO EQUIPO (ID_EQUIPO) VALUES ('EQ00000001');
INSERT INTO EQUIPO (ID_EQUIPO) VALUES ('EQ00000002');
INSERT INTO EQUIPO (ID_EQUIPO) VALUES ('EQ00000003');


--Insercion de registros en la tabla PARTIDO
DELETE FROM PARTIDO;
INSERT INTO PARTIDO(ID_PARTIDO, HORA_FIN, HORA_INICIO, FECHA, ID_EQUIPO) 
VALUES
	('P000000001','10:00:00','09:00:00','2024-04-10','EQ00000001'),
	('P000000002','11:00:00','10:00:00','2024-04-10','EQ00000002'),
	('P000000003','12:00:00','10:00:00','2024-04-10','EQ00000003');


--Insercion de registros en la tabla PRODUCTO
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





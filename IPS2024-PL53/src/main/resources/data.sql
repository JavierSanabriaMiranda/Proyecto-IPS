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
INSERT INTO EMPLEADO_NO_DEPORTIVO (ID_EMPLEADO_NO_DEP, DNI, NOMBRE, APELLIDO, FECHA_NACIMIENTO, TELEFONO, POSICION, SALARIO_ANUAL) VALUES
('E001', '12345678A', 'Juan', 'Pérez', '1985-05-10', '612345678', 'gerente', 30000.00),
('E002', '23456789B', 'María', 'García', '1990-07-15', '623456789', 'vendedor de entradas/abonos', 20000.00),
('E003', '34567890C', 'Carlos', 'López', '1982-12-20', '634567890', 'encargados de tienda', 22000.00),
('E004', '45678901D', 'Ana', 'Martínez', '1995-03-25', '645678901', 'gestor de instalaciones', 25000.00),
('E005', '56789012E', 'Luis', 'Hernández', '1988-11-30', '656789012', 'empleados de tienda', 18000.00),
('E006', '67890123F', 'Laura', 'Sánchez', '1992-08-05', '667890123', 'jardinería', 17000.00),
('E007', '78901234G', 'Pedro', 'Ramírez', '1979-02-18', '678901234', 'cocina', 19000.00),
('E008', '89012345H', 'Sofía', 'Torres', '1986-04-22', '689012345', 'director de comunicaciones', 35000.00);

-- Inserción de registros en la tabla INSTALACION
DELETE FROM INSTALACION;
INSERT INTO INSTALACION (COD_INSTALACION) VALUES ('ZONA_ENTRENAMIENTO_1');
INSERT INTO INSTALACION (COD_INSTALACION) VALUES ('ZONA_ENTRENAMIENTO_2');
INSERT INTO INSTALACION (COD_INSTALACION) VALUES ('GIMNASIO_PRINCIPAL');
INSERT INTO INSTALACION (COD_INSTALACION) VALUES ('CAMPO_JUEGO_1');
INSERT INTO INSTALACION (COD_INSTALACION) VALUES ('CAMPO_JUEGO_2');

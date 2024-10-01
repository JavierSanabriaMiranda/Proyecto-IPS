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
INSERT INTO EMPLEADO_NO_DEPORTIVO (DNI, NOMBRE, APELLIDO, FECHA_NACIMIENTO, TELEFONO, POSICION, SALARIO_ANUAL) 
VALUES
('12345678A', 'Juan', 'Pérez', '1985-07-15', '600123456', 'gerente', 45000.00),
('87654321B', 'Ana', 'García', '1990-11-25', '600654321', 'vendedor de entradas/abonos', 32000.00),
('45678912C', 'Carlos', 'López', '1978-02-10', '600789123', 'gestor de instalaciones', 38000.00),
('65432187D', 'María', 'Fernández', '1982-05-05', '600321654', 'encargados de tienda', 30000.00),
('32165498E', 'Lucía', 'Martínez', '1995-08-30', '600654987', 'jardinería', 27000.00),
('78945612F', 'Pablo', 'Sánchez', '1987-12-22', '600987654', 'cocina', 28000.00),
('95175384G', 'Laura', 'Hernández', '1992-03-18', '600753951', 'empleados de tienda', 25000.00),
('85236974H', 'Pedro', 'Gómez', '1989-09-09', '600369852', 'director de comunicaciones', 50000.00);

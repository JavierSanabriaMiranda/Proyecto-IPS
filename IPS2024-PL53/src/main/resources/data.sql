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


--Insercion de registros en la tabla 
DELETE FROM PRODUCTO;
INSERT INTO PRODUCTO(COD_PRODUCTO, TIPO, NOMBRE, PRECIO, UNIDADES, COD_COMPRA)
VALUES
    ('EQ01','equipacion','Camiseta Primera Equipacion',64.95,0,NULL),
    ('EQ02','equipacion','Camiseta Segunda Equipacion',64.95,0,NULL),
    ('EQ03','equipacion','Camiseta Tercera Equipacion',64.95,0,NULL),
    ('EQ04','equipacion','Camiseta Personalizada',20.00,0,NULL),
    ('MO01','moda textil','Calcertines',9.95,0,NULL),
    ('MO02','moda textil','Camiseta de Calle',25.00,0,NULL),
    ('MO03','moda textil','Camiseta de Entrenamiento',29.95,0,NULL),
    ('MO04','moda textil','Sudadera',45.00,0,NULL),
    ('MO05','moda textil','Plumas',59.00,0,NULL),
    ('MO06','moda textil','Chubasquero',39.00,0,NULL),
    ('MO07','moda textil','Sudadera de Entrenamiento',55.00,0,NULL),
    ('MO08','moda textil','Polo',44.95,0,NULL),
    ('AC01','accesorio','Balon de Futbol',22.50,0,NULL),
    ('AC02','accesorio','Bolsa de Tela',9.90,0,NULL),
    ('AC03','accesorio','Braga de Cuello',11.50,0,NULL),
    ('AC04','accesorio','Bufanda Blanqui-Negra',12.00,0,NULL),
    ('AC05','accesorio','Bufanda Rosa',12.00,0,NULL),
    ('AC06','accesorio','Gorro de Lana',18.00,0,NULL),
    ('AC07','accesorio','Guantes de Lana',12.50,0,NULL),
    ('AC08','accesorio','Llavero',5.00,0,NULL),
    ('AC09','accesorio','Zapatillas de Casa',22.50,0,NULL);


--Primero se deben borrar todas las tablas (de detalle a maestro) y lugo anyadirlas (de maestro a detalle)
--(en este caso en cada aplicacion se usa solo una tabla, por lo que no hace falta)

--Para giis.demo.tkrun:
--drop table Carreras;
--create table Carreras (id int primary key not null, inicio date not null, fin date not null, fecha date not null, descr varchar(32), check(inicio<=fin), check(fin<fecha));


-- ¡¡¡IMPORTANTE!!!
-- Se han de hacer los drops a la inversa de los create para evitar 
-- fallos SQL por borrado de tablas que estan referenciadas en otras tablas

------- ZONA DE DROPS ------- 

DROP TABLE ENTRENADOR;
DROP TABLE JUGADOR;
DROP TABLE EQUIPO;
DROP TABLE EMPLEADO_DEPORTIVO;
DROP TABLE TURNO;
DROP TABLE HORARIO;
DROP TABLE EMPLEADO_NO_DEPORTIVO;


------- ZONA DE CREATES ------- 

CREATE TABLE EMPLEADO_NO_DEPORTIVO (
    DNI varchar(9),
    NOMBRE varchar (15),
    APELLIDO varchar(15),
    FECHA_NACIMIENTO date,
    TELEFONO varchar(9),
    POSICION varchar(40),
    SALARIO_ANUAL decimal(8,2),
    CONSTRAINT PK_EMP_NO_DEP PRIMARY KEY (DNI),
    CONSTRAINT CK_POSICION CHECK (POSICION IN ('gerente', 
        'vendedor de entradas/abonos', 'encargados de tienda', 
        'gestor de instalaciones', 'empleados de tienda', 'jardinería', 
        'cocina', 'director de comunicaciones')),
);

CREATE TABLE HORARIO (
    DNI varchar(9),
    COD_HORARIO varchar(10),
    CONSTRAINT PK_HORARIO PRIMARY KEY (COD_HORARIO, DNI),
    CONSTRAINT FK_HORARIO FOREIGN KEY (DNI) 
        REFERENCES EMPLEADO_NO_DEPORTIVO (DNI)
);

CREATE TABLE TURNO (
    HORA_INICIO TIME,
    HORA_FIN TIME,
    DIA_SEMANA INT,
    DNI varchar(9),
    COD_HORARIO varchar(10),
    CONSTRAINT CK_DIA_SEMANA CHECK(DIA_SEMANA BETWEEN 1 AND 7),
    CONSTRAINT FK_TURNO FOREIGN KEY (DNI, COD_HORARIO) 
        REFERENCES HORARIO (DNI, COD_HORARIO)
);

CREATE TABLE EMPLEADO_DEPORTIVO (
    DNI varchar(9),
    NOMBRE varchar (15),
    APELLIDO varchar(15),
    FECHA_NACIMIENTO date,
    TELEFONO varchar(9),
    POSICION varchar(40),
    SALARIO_ANUAL decimal(8,2),
    CONSTRAINT PK_EMP_DEP PRIMARY KEY (DNI),
    CONSTRAINT CK_POSICION_DEP CHECK (POSICION IN ('jugador', 
                'entrenador')),
);

CREATE TABLE EQUIPO (
    ID_EQUIPO varchar(10),
    DNI_PRIMER_ENTRENADOR varchar(9),
    DNI_SEGUNDO_ENTRENADOR varchar(9),
    CONSTRAINT PK_EQUIPO PRIMARY KEY (ID_EQUIPO)
);

CREATE TABLE JUGADOR (
    DNI varchar(9),
    ID_EQUIPO varchar(10),
    CONSTRAINT PK_JUGADOR PRIMARY KEY (DNI),
    CONSTRAINT FK_JUGADOR FOREIGN KEY (DNI) 
        REFERENCES EMPLEADO_DEPORTIVO (DNI),
    CONSTRAINT FK_JUGADOR_EQUIPO FOREIGN KEY (ID_EQUIPO)
        REFERENCES EQUIPO (ID_EQUIPO)
);

CREATE TABLE ENTRENADOR (
    DNI varchar(9),
    ID_EQUIPO varchar(10),
    CONSTRAINT PK_ENTRENADOR PRIMARY KEY (DNI),
    CONSTRAINT FK_ENTRENADOR FOREIGN KEY (DNI) 
        REFERENCES EMPLEADO_DEPORTIVO (DNI),
    CONSTRAINT FK_ENTRENADOR_EQUIPO FOREIGN KEY (ID_EQUIPO)
        REFERENCES EQUIPO (ID_EQUIPO)
);
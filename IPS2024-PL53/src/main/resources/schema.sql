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
DROP TABLE TURNO_SEMANAL;
DROP TABLE TURNO_PUNTUAL;
DROP TABLE TURNO;
DROP TABLE HORARIO;
DROP TABLE EMPLEADO_NO_DEPORTIVO;


------- ZONA DE CREATES ------- 

CREATE TABLE EMPLEADO_NO_DEPORTIVO (
	ID_EMPLEADO_NO_DEP varchar(10),
    DNI varchar(9),
    NOMBRE varchar (15),
    APELLIDO varchar(15),
    FECHA_NACIMIENTO date,
    TELEFONO varchar(9),
    POSICION varchar(40),
    SALARIO_ANUAL decimal(8,2),
    CONSTRAINT PK_EMP_NO_DEP PRIMARY KEY (ID_EMPLEADO_NO_DEP),
    CONSTRAINT CK_POSICION CHECK (POSICION IN ('gerente', 
        'vendedor de entradas/abonos', 'encargados de tienda', 
        'gestor de instalaciones', 'empleados de tienda', 'jardinería', 
        'cocina', 'director de comunicaciones')),
);

CREATE TABLE HORARIO (
    ID_EMP varchar(10),
    COD_HORARIO varchar(10),
    CONSTRAINT PK_HORARIO PRIMARY KEY (COD_HORARIO, ID_EMP),
    CONSTRAINT FK_HORARIO FOREIGN KEY (ID_EMP) 
        REFERENCES EMPLEADO_NO_DEPORTIVO (ID_EMPLEADO_NO_DEP)
);

CREATE TABLE TURNO (
	ID_TURNO varchar(10),
    HORA_INICIO time,
    HORA_FIN time,
    ID_EMP varchar(10),
    COD_HORARIO varchar(10),
    CONSTRAINT PK_TURNO PRIMARY KEY (ID_TURNO),
    CONSTRAINT FK_TURNO FOREIGN KEY (ID_EMP, COD_HORARIO) 
        REFERENCES HORARIO (ID_EMP, COD_HORARIO)
);

CREATE TABLE TURNO_SEMANAL (
	ID_TURNO varchar(10),
	DIA_SEMANA int,
	CONSTRAINT PK_TURNO_SEM PRIMARY KEY (ID_TURNO),
	CONSTRAINT FK_TURNO_SEM FOREIGN KEY (ID_TURNO)
		REFERENCES TURNO (ID_TURNO),
	CONSTRAINT CK_DIA_SEMANA CHECK(DIA_SEMANA BETWEEN 1 AND 7)
);

CREATE TABLE TURNO_PUNTUAL (
	ID_TURNO varchar(10),
	DIA date,
	CONSTRAINT PK_TURNO_PUN PRIMARY KEY (ID_TURNO),
	CONSTRAINT FK_TURNO_PUN FOREIGN KEY (ID_TURNO)
		REFERENCES TURNO (ID_TURNO),
);


CREATE TABLE EMPLEADO_DEPORTIVO (
	ID_EMPLEADO_DEP varchar(10),
    DNI varchar(9),
    NOMBRE varchar (15),
    APELLIDO varchar(15),
    FECHA_NACIMIENTO date,
    TELEFONO varchar(9),
    SALARIO_ANUAL decimal(8,2),
    CONSTRAINT PK_EMP_DEP PRIMARY KEY (ID_EMPLEADO_DEP)
);

CREATE TABLE EQUIPO (
    ID_EQUIPO varchar(10),
    CONSTRAINT PK_EQUIPO PRIMARY KEY (ID_EQUIPO)
);

CREATE TABLE JUGADOR (
	ID_JUGADOR varchar(10),
    ID_EQUIPO varchar(10),
    CONSTRAINT PK_JUGADOR PRIMARY KEY (ID_JUGADOR),
    CONSTRAINT FK_JUGADOR FOREIGN KEY (ID_JUGADOR) 
        REFERENCES EMPLEADO_DEPORTIVO (ID_EMPLEADO_DEP),
    CONSTRAINT FK_JUGADOR_EQUIPO FOREIGN KEY (ID_EQUIPO)
        REFERENCES EQUIPO (ID_EQUIPO)
);

CREATE TABLE ENTRENADOR (
	ID_ENTRENADOR varchar(10),
    ID_EQUIPO varchar(10),
    POSICION_ENTRENADOR INT,
    CONSTRAINT PK_ENTRENADOR PRIMARY KEY (ID_ENTRENADOR),
    CONSTRAINT FK_ENTRENADOR FOREIGN KEY (ID_ENTRENADOR)
        REFERENCES EMPLEADO_DEPORTIVO (ID_EMPLEADO_DEP),
    CONSTRAINT FK_ENTRENADOR_EQUIPO FOREIGN KEY (ID_EQUIPO)
        REFERENCES EQUIPO (ID_EQUIPO),
    CONSTRAINT CK_ENTRENADOR CHECK (POSICION_ENTRENADOR BETWEEN 1 AND 2)
);



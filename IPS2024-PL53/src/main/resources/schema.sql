--Primero se deben borrar todas las tablas (de detalle a maestro) y lugo anyadirlas (de maestro a detalle)
--(en este caso en cada aplicacion se usa solo una tabla, por lo que no hace falta)

--Para giis.demo.tkrun:
--drop table Carreras;
--create table Carreras (id int primary key not null, inicio date not null, fin date not null, fecha date not null, descr varchar(32), check(inicio<=fin), check(fin<fecha));


-- ¡¡¡IMPORTANTE!!!
-- Se han de hacer los drops a la inversa de los create para evitar 
-- fallos SQL por borrado de tablas que estan referenciadas en otras tablas

------- ZONA DE DROPS ------- 

DROP TABLE ENTREVISTA;
DROP TABLE FRANJA_ENTREVISTA;
DROP TABLE ENTRADA;
DROP TABLE PARTIDO;
DROP TABLE ABONO_TEMPORADA;
DROP TABLE CAMPAÑA_ACCIONISTA;
DROP TABLE COMPRA_PRODUCTO;
DROP TABLE PRODUCTO;
DROP TABLE COMPRA_MERCHANDISING;
DROP TABLE RESERVA;
DROP TABLE EQUIPO_FORMACION;
DROP TABLE EQUIPO_PROFESIONAL;
DROP TABLE ENTRENAMIENTO;
DROP TABLE INSTALACION;
DROP TABLE ENTRENADOR;
DROP TABLE JUGADOR;
DROP TABLE EQUIPO;
DROP TABLE EMPLEADO_DEPORTIVO;
DROP TABLE TURNO_PUNTUAL;
DROP TABLE TURNO_SEMANAL;
DROP TABLE TURNO;
DROP TABLE HORARIO;
DROP TABLE EMPLEADO_NO_DEPORTIVO;
DROP TABLE VENTAS;
DROP TABLE CLIENTE;



------- ZONA DE CREATES ------- 
CREATE TABLE CLIENTE (
    DNI varchar(9),                      
    NOMBRE varchar(50),                  
    CONSTRAINT PK_CLIENTE PRIMARY KEY (DNI)  
);
CREATE TABLE VENTAS (
    ID_VENTAS varchar(10),
    DNI varchar(9),                                    
    FECHA date,                                       
    COSTE decimal(8, 2),                             
    CONSTRAINT PK_VENTAS PRIMARY KEY (ID_VENTAS),  
    CONSTRAINT FK_VENTAS_CLIENTE FOREIGN KEY (DNI)  
        REFERENCES CLIENTE (DNI) 
        ON DELETE CASCADE                            
);

CREATE TABLE EMPLEADO_NO_DEPORTIVO (
	ID_EMPLEADO_NO_DEP varchar(10),
    DNI varchar(9),
    NOMBRE varchar (15),
    APELLIDO varchar(15),
    FECHA_NACIMIENTO date,
    TELEFONO varchar(9),
    POSICION varchar(40),
    SALARIO_ANUAL decimal(20,2),
    CONSTRAINT PK_EMP_NO_DEP PRIMARY KEY (ID_EMPLEADO_NO_DEP),
    CONSTRAINT CK_POSICION CHECK (POSICION IN ('gerente', 
        'vendedor de entradas/abonos', 'encargado de tienda', 
        'gestor de instalaciones', 'empleado de tienda', 'empleado de jardineria', 
        'empleado de cocina', 'director de comunicaciones'))
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
		REFERENCES TURNO (ID_TURNO)
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

CREATE TABLE INSTALACION (
    COD_INSTALACION varchar(30),
    CONSTRAINT PK_INSTALACION PRIMARY KEY (COD_INSTALACION)
);
CREATE TABLE ENTRENAMIENTO(
    ID_ENTRENAMIENTO varchar(10),
    FECHA DATE,
    HORA_INICIO TIME,
    HORA_FIN TIME,
    COD_INSTALACION varchar(10),
    ID_EQUIPO varchar(10),
    CONSTRAINT PK_ID_ENTRENAMIENTO PRIMARY KEY (ID_ENTRENAMIENTO),
    CONSTRAINT FK_COD_INSTALACION FOREIGN KEY (COD_INSTALACION) REFERENCES INSTALACION (COD_INSTALACION),
    CONSTRAINT FK_ID_EQUIPO FOREIGN KEY (ID_EQUIPO) REFERENCES EQUIPO (ID_EQUIPO)
);
CREATE TABLE EQUIPO_PROFESIONAL(
    ID_EQUIPO varchar(10),
    ID_PROFESIONAL varchar(10),
    CONSTRAINT PK_EQUIPO_PROFESIONAL PRIMARY KEY (ID_EQUIPO),
    CONSTRAINT FK_ID_EQUIPO_PRO FOREIGN KEY (ID_EQUIPO) REFERENCES EQUIPO (ID_EQUIPO),
    CONSTRAINT FK_ID_PROFESIONAL FOREIGN KEY (ID_PROFESIONAL) REFERENCES EQUIPO_PROFESIONAL (ID_EQUIPO)
);
CREATE TABLE EQUIPO_FORMACION(
    ID_EQUIPO varchar(10),
    CATEGORIA varchar(10),
    CONSTRAINT PK_EQUIPO_FORMACION PRIMARY KEY (ID_EQUIPO),
    CONSTRAINT FK_ID_EQUIPO_FOR FOREIGN KEY (ID_EQUIPO) REFERENCES EQUIPO (ID_EQUIPO),
    CONSTRAINT CK_EQUIPO_FORMACION_CATEGORIA CHECK (CATEGORIA IN ('juvenil', 'cadete', 'infantil', 'alevin', 'benjamin', 'pre-benjamin'))
);

CREATE TABLE RESERVA (
    COD_RESERVA varchar(16),
    HORA_FIN time,
    HORA_INICIO time,
    COD_INSTALACION varchar(30),
    N_TARJETA varchar(26),
    CONSTRAINT PK_RESERVA PRIMARY KEY (COD_RESERVA),
    CONSTRAINT FK_RESERVA_INSTALACION FOREIGN KEY (COD_INSTALACION)
        REFERENCES INSTALACION (COD_INSTALACION),
    CONSTRAINT FK_RESERVA_VENTAS FOREIGN KEY (COD_RESERVA)
        REFERENCES VENTAS (ID_VENTAS)
        ON DELETE CASCADE,
);

CREATE TABLE COMPRA_MERCHANDISING(
	CODCOMPRA VARCHAR(16) NOT NULL,
	CONSTRAINT PK_COMPRA_MERCHANDISING PRIMARY KEY (CODCOMPRA),
	CONSTRAINT FK_COMPRA_MERCHANDISING FOREIGN KEY (CODCOMPRA)
	REFERENCES VENTAS (ID_VENTAS)
);

CREATE TABLE PRODUCTO(
	CODPRODUCTO VARCHAR(4) NOT NULL,
	TIPO VARCHAR(20),
	NOMBRE VARCHAR(50),
	PRECIO DECIMAL(5,2),
	CONSTRAINT PK_PRODUCTO PRIMARY KEY (CODPRODUCTO)
);

CREATE TABLE COMPRA_PRODUCTO(
    UNIDADES DECIMAL(2,0),
    CODCOMPRA VARCHAR(16),
    CODPRODUCTO VARCHAR(4),
    CONSTRAINT FK_COMPRA_PRODUCTO_COMPRA FOREIGN KEY (CODCOMPRA)
        REFERENCES COMPRA_MERCHANDISING (CODCOMPRA),
    CONSTRAINT FK_COMPRA_PRODUCTO_PRODUCTO FOREIGN KEY (CODPRODUCTO)
        REFERENCES PRODUCTO (CODPRODUCTO)
);

CREATE TABLE CAMPAÑA_ACCIONISTA(
	CODACCIONISTA VARCHAR(16) NOT NULL,
	CONSTRAINT PK_CAMPAÑA_ACCIONISTA PRIMARY KEY (CODACCIONISTA),
	CONSTRAINT FK_CAMPAÑA_ACCIONISTA FOREIGN KEY (CODACCIONISTA)
	REFERENCES VENTAS (ID_VENTAS)
);

CREATE TABLE ABONO_TEMPORADA(
	CODABONO VARCHAR(16) NOT NULL,
	CONSTRAINT PK_ABONO_TEMPORADA PRIMARY KEY (CODABONO),
	CONSTRAINT FK_ABONO_TEMPORADA FOREIGN KEY (CODABONO)
	REFERENCES VENTAS (ID_VENTAS)
);

CREATE TABLE PARTIDO (
    ID_PARTIDO varchar(10),
    HORA_FIN time,
    HORA_INICIO time,
    FECHA date,
    ID_EQUIPO varchar(10),
    CONSTRAINT PK_PARTIDO PRIMARY KEY (ID_PARTIDO),
    CONSTRAINT FK_PARTIDO_EQUIPO FOREIGN KEY (ID_EQUIPO)
        REFERENCES EQUIPO (ID_EQUIPO)
);

CREATE TABLE ENTRADA (
    COD_ENTRADA varchar(10), 
    TRIBUNA varchar(1),
    SECCION varchar(1),
    N_FILA INT,
    N_ASIENTO INT, 
    ID_PARTIDO varchar(10),
    CONSTRAINT CK_TRIBUNA CHECK(TRIBUNA BETWEEN 'A' AND 'D'),
    CONSTRAINT CK_SECCION CHECK(SECCION BETWEEN 'A' AND 'F'),
    CONSTRAINT CK_N_FILA CHECK(N_FILA BETWEEN 0 AND 9),
    CONSTRAINT CK_N_ASIENTO CHECK(N_ASIENTO BETWEEN 0 AND 14),
    CONSTRAINT PK_ENTRADA PRIMARY KEY (COD_ENTRADA),
    CONSTRAINT FK_ENTRADA_VENTAS FOREIGN KEY (COD_ENTRADA) 
        REFERENCES VENTAS (ID_VENTAS)
        ON DELETE CASCADE,
    CONSTRAINT FK_ENTADA_PARTIDO FOREIGN KEY (ID_PARTIDO)
        REFERENCES PARTIDO (ID_PARTIDO)
);

CREATE TABLE FRANJA_ENTREVISTA (
    ID_JUGADOR varchar(10),
    FECHA date,
    HORA_INICIO time,
    HORA_FIN time,
    CONSTRAINT PK_FRANJA_ENTREVISTA PRIMARY KEY (ID_JUGADOR, FECHA, HORA_INICIO, HORA_FIN),
    CONSTRAINT FK_FRANJA_JUGADOR FOREIGN KEY (ID_JUGADOR) 
        REFERENCES JUGADOR (ID_JUGADOR)
);

CREATE TABLE ENTREVISTA (
    COD_ENTREVISTA varchar(10),
    ID_JUGADOR varchar(10),
    FECHA date,
    HORA_INICIO time,
    HORA_FIN time,
    MEDIO_COMUNICACION varchar(50),
    CONSTRAINT PK_ENTREVISTA PRIMARY KEY (COD_ENTREVISTA),
    CONSTRAINT FK_ENTREVISTA_FRANJA FOREIGN KEY (ID_JUGADOR, FECHA, HORA_INICIO, HORA_FIN)
        REFERENCES FRANJA_ENTREVISTA (ID_JUGADOR, FECHA, HORA_INICIO, HORA_FIN),
    UNIQUE (ID_JUGADOR, FECHA, HORA_INICIO, HORA_FIN)
);







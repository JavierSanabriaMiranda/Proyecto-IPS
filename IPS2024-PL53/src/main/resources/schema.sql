--Primero se deben borrar todas las tablas (de detalle a maestro) y lugo anyadirlas (de maestro a detalle)
--(en este caso en cada aplicacion se usa solo una tabla, por lo que no hace falta)

--Para giis.demo.tkrun:
--drop table Carreras;
--create table Carreras (id int primary key not null, inicio date not null, fin date not null, fecha date not null, descr varchar(32), check(inicio<=fin), check(fin<fecha));


-- ¡¡¡IMPORTANTE!!!
-- Se han de hacer los drops a la inversa de los create para evitar 
-- fallos SQL por borrado de tablas que estan referenciadas en otras tablas

------- ZONA DE DROPS -------
DROP TABLE ACCION;
DROP TABLE PARTICIPA_EN_CAMPANIA;
DROP TABLE ACCIONISTA;
DROP TABLE CAMPANIA_ACCIONISTAS;
DROP TABLE RESERVA_JARDINERIA;
DROP TABLE IMAGEN;
DROP TABLE NOTICIA;
DROP TABLE ENTREVISTA;
DROP TABLE FRANJA_ENTREVISTA;
DROP TABLE ENTRADA;
DROP TABLE ASIENTO;
DROP TABLE PARTIDO;
DROP TABLE ABONO_TEMPORADA;
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
DROP TABLE EMPLEADO_NO_DEPORTIVO;
DROP TABLE USUARIO;
DROP TABLE VENTAS;
DROP TABLE CLIENTE;

------- ZONA DE CREATES ------- 
CREATE TABLE CLIENTE (
    DNI varchar(9),
    NOMBRE varchar(50),
    CONSTRAINT PK_CLIENTE PRIMARY KEY (DNI)
);
CREATE TABLE VENTAS (
    ID_VENTAS varchar(16),
    DNI varchar(9),
    FECHA timestamp,
    COSTE decimal(8, 2),
    CONSTRAINT PK_VENTAS PRIMARY KEY (ID_VENTAS),
    CONSTRAINT FK_VENTAS_CLIENTE FOREIGN KEY (DNI)
        REFERENCES CLIENTE (DNI)
        ON DELETE CASCADE
);

CREATE TABLE USUARIO (
	ID_USUARIO VARCHAR(20),
	NOMBRE_USUARIO VARCHAR(50),
	CONTRASEÑA VARCHAR(50),
	CONSTRAINT PK_USUARIO PRIMARY KEY (ID_USUARIO),
	CONSTRAINT UQ_USUARIO UNIQUE (NOMBRE_USUARIO)
);

CREATE TABLE EMPLEADO_NO_DEPORTIVO (
	ID_EMPLEADO_NO_DEP varchar(10),
    DNI varchar(20),
    NOMBRE varchar (15),
    APELLIDO varchar(15),
    FECHA_NACIMIENTO date,
    TELEFONO varchar(20),
    POSICION varchar(40),
    SALARIO_ANUAL decimal(20,2),
    CONSTRAINT PK_EMP_NO_DEP PRIMARY KEY (ID_EMPLEADO_NO_DEP),
    CONSTRAINT FK_EMP_NO_DEP FOREIGN KEY (ID_EMPLEADO_NO_DEP)
    	REFERENCES USUARIO (ID_USUARIO),
    CONSTRAINT UQ_EMP_NO_DEP UNIQUE (DNI),	
    CONSTRAINT CK_POSICION CHECK (POSICION IN ('gerente', 
        'vendedor de entradas/abonos', 'encargado de tienda',
        'gestor de instalaciones', 'empleado de tienda', 'empleado de jardineria',
        'empleado de cocina', 'director de comunicaciones'))
);

CREATE TABLE TURNO (
	ID_TURNO varchar(50),
	ID_EMPLEADO varchar(10),
    HORA_INICIO time,
    HORA_FIN time,
    CONSTRAINT PK_TURNO PRIMARY KEY (ID_TURNO, ID_EMPLEADO),
    CONSTRAINT FK_TURNO FOREIGN KEY (ID_EMPLEADO)
        REFERENCES EMPLEADO_NO_DEPORTIVO (ID_EMPLEADO_NO_DEP)
);

CREATE TABLE TURNO_SEMANAL (
	ID_TURNO varchar(50),
	ID_EMPLEADO varchar(10),
	DIA_SEMANA int,
	CONSTRAINT PK_TURNO_SEM PRIMARY KEY (ID_TURNO, ID_EMPLEADO),
	CONSTRAINT FK_TURNO_SEM FOREIGN KEY (ID_TURNO, ID_EMPLEADO)
		REFERENCES TURNO (ID_TURNO, ID_EMPLEADO),
	CONSTRAINT CK_DIA_SEMANA CHECK(DIA_SEMANA BETWEEN 1 AND 7)
);

CREATE TABLE TURNO_PUNTUAL (
	ID_TURNO varchar(50),
	ID_EMPLEADO varchar(10),
	DIA date,
	CONSTRAINT PK_TURNO_PUN PRIMARY KEY (ID_TURNO, ID_EMPLEADO),
	CONSTRAINT FK_TURNO_PUN FOREIGN KEY (ID_TURNO, ID_EMPLEADO)
		REFERENCES TURNO (ID_TURNO, ID_EMPLEADO)
);


CREATE TABLE EMPLEADO_DEPORTIVO (
	ID_EMPLEADO_DEP varchar(10),
    DNI varchar(20),
    NOMBRE varchar (15),
    APELLIDO varchar(15),
    FECHA_NACIMIENTO date,
    TELEFONO varchar(20),
    SALARIO_ANUAL decimal(20,2),
    CONSTRAINT PK_EMP_DEP PRIMARY KEY (ID_EMPLEADO_DEP),
    CONSTRAINT FK_EMP_DEP FOREIGN KEY (ID_EMPLEADO_DEP)
    	REFERENCES USUARIO (ID_USUARIO),
    CONSTRAINT UQ_EMP_DEP UNIQUE (DNI)
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
        REFERENCES EQUIPO (ID_EQUIPO)
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
    COD_INSTALACION varchar(30),
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
    CATEGORIA varchar(20),
    CONSTRAINT PK_EQUIPO_FORMACION PRIMARY KEY (ID_EQUIPO),
    CONSTRAINT FK_ID_EQUIPO_FOR FOREIGN KEY (ID_EQUIPO) REFERENCES EQUIPO (ID_EQUIPO),
    CONSTRAINT CK_EQUIPO_FORMACION_CATEGORIA CHECK (CATEGORIA IN ('juvenil', 'cadete', 'infantil', 'alevin', 'benjamin', 'prebenjamin'))
);

CREATE TABLE RESERVA (
    COD_RESERVA varchar(16),
    HORA_FIN time,
    HORA_INICIO time,
    COD_INSTALACION varchar(30),
    FECHA_RESERVA timestamp,
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
	CONSTRAINT PK_PRODUCTO PRIMARY KEY (CODPRODUCTO),
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
    VISITANTE varchar(20),
    TIENESUPLEMENTO boolean,
    CONSTRAINT PK_PARTIDO PRIMARY KEY (ID_PARTIDO),
    CONSTRAINT FK_PARTIDO_EQUIPO FOREIGN KEY (ID_EQUIPO)
        REFERENCES EQUIPO (ID_EQUIPO)
);

CREATE TABLE ASIENTO (
	ID_ASIENTO VARCHAR(50),
	TRIBUNA VARCHAR(1),
	SECCION varchar(1),
	N_FILA INT,
    N_ASIENTO INT,
    CONSTRAINT PK_ASIENTO PRIMARY KEY (ID_ASIENTO),
   	CONSTRAINT CK_TRIBUNA CHECK(TRIBUNA BETWEEN 'A' AND 'D'),
    CONSTRAINT CK_SECCION CHECK(SECCION BETWEEN 'A' AND 'F'),
    CONSTRAINT CK_N_FILA CHECK(N_FILA BETWEEN 0 AND 9),
    CONSTRAINT CK_N_ASIENTO CHECK(N_ASIENTO BETWEEN 0 AND 14)
);

CREATE TABLE ENTRADA (
    COD_ENTRADA varchar(16),
    ID_PARTIDO varchar(10),
    ID_ASIENTO varchar(50),

    CONSTRAINT PK_ENTRADA PRIMARY KEY (COD_ENTRADA),
    CONSTRAINT FK_ENTRADA_VENTAS FOREIGN KEY (COD_ENTRADA)
        REFERENCES VENTAS (ID_VENTAS)
        ON DELETE CASCADE,
    CONSTRAINT FK_ENTRADA_PARTIDO FOREIGN KEY (ID_PARTIDO)
        REFERENCES PARTIDO (ID_PARTIDO),
	CONSTRAINT FK_ENTRADA_ASIENTO FOREIGN KEY (ID_ASIENTO)
        REFERENCES ASIENTO (ID_ASIENTO)
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

CREATE TABLE NOTICIA (
    COD_NOTICIA varchar(10) NOT NULL,
    TITULO varchar(255),
    TEXTO clob,
    CONSTRAINT PK_NOTICIA PRIMARY KEY (COD_NOTICIA)
);

CREATE TABLE IMAGEN (
    COD_NOTICIA varchar(10) NOT NULL,  
    ID_IMAGEN varchar(10) NOT NULL,                             
    NOMBRE varchar(255),       
    CONSTRAINT PK_IMAGEN PRIMARY KEY (ID_IMAGEN),    
    CONSTRAINT FK_IMAGEN FOREIGN KEY (COD_NOTICIA) REFERENCES NOTICIA(COD_NOTICIA) ON DELETE CASCADE
);

CREATE TABLE RESERVA_JARDINERIA(
	COD_RESERVA_JARDINERIA varchar(20),
	ID_JARDINERO varchar(10),
	COD_INSTALACION varchar(30),
	FECHA date,
	HORA_INICIO time,
	HORA_FIN time,
	CONSTRAINT PK_RESERVA_JARDINERIA PRIMARY KEY (COD_RESERVA_JARDINERIA),
	CONSTRAINT FK_RESERVA_JARDINERIA_INSTALACION FOREIGN KEY (COD_INSTALACION) REFERENCES INSTALACION(COD_INSTALACION) ON DELETE CASCADE,
	CONSTRAINT FK_RESERVA_JARDINERIA_EMPLEADO_NO_DEP FOREIGN KEY (ID_JARDINERO) REFERENCES EMPLEADO_NO_DEPORTIVO(ID_EMPLEADO_NO_DEP) ON DELETE CASCADE
);

CREATE TABLE CAMPANIA_ACCIONISTAS (
	COD_CAMPANIA varchar(50),
	NUMERO_ACCIONES_INICIAL int,
	NUMERO_ACCIONES_RESTANTES int,
	FASE int,
	ESTADO varchar(20),
	CONSTRAINT PK_CAMPANIA PRIMARY KEY (COD_CAMPANIA),
	CONSTRAINT FK_CAMPANIA FOREIGN KEY (COD_CAMPANIA) REFERENCES VENTAS (ID_VENTAS)
	ON DELETE CASCADE
);

CREATE TABLE ACCIONISTA (
	ID_ACCIONISTA varchar(50),
	DNI varchar (20),
	NOMBRE varchar (50),
	CONSTRAINT PK_ACCIONISTA PRIMARY KEY (ID_ACCIONISTA),
	CONSTRAINT FK_ACCIONISTA FOREIGN KEY (ID_ACCIONISTA)
    	REFERENCES USUARIO (ID_USUARIO),
	CONSTRAINT UQ_ACCIONISTA UNIQUE (DNI)
);

CREATE TABLE PARTICIPA_EN_CAMPANIA (
	COD_CAMPANIA varchar(50),
	ID_ACCIONISTA varchar(50),
	NUM_ACCIONES_INICIALES int,
	NUM_ACCIONES_COMPRADAS int,
	CONSTRAINT PK_PARTICIPA_EN_CAMPANIA PRIMARY KEY (COD_CAMPANIA, ID_ACCIONISTA),
	CONSTRAINT FK_PARTICIPA_EN_CAMPANIA FOREIGN KEY (COD_CAMPANIA)
		REFERENCES CAMPANIA_ACCIONISTAS (COD_CAMPANIA),
	CONSTRAINT FK_ACCIONISTA_PARTICIPA FOREIGN KEY (ID_ACCIONISTA)
		REFERENCES ACCIONISTA (ID_ACCIONISTA)
);

CREATE TABLE ACCION (
    ID_ACCION varchar(50),
    ID_ACCIONISTA varchar(50),
    PRECIO DECIMAL(5,2),
    ISENVENTA BOOLEAN DEFAULT FALSE,
    CONSTRAINT PK_ACCION PRIMARY KEY (ID_ACCION),
    CONSTRAINT FK_ACCION FOREIGN KEY (ID_ACCIONISTA)
        REFERENCES ACCIONISTA (ID_ACCIONISTA)
);

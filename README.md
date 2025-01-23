<h1 align="center">Aplicación de Gestión del Burgos CF</h1>

<p align="center">ℹ️ Repositorio para el desarrollo de un proyecto en Java para la asignatura "Ingeniería del Proceso Software"</p>

## Contexto

Esta es una aplicación de gestión de un equipo de futbol, en este caso el Burgos CF.

La aplicación permite que se gestionen empleados (tanto jugadores como entrenadores o puestos más administrativos como el vendedor de entradas y abonos o los jardineros), gestionar partidos y entrenamientos, venta de entradas, merchandising y hasta acciones del club.

## Sistema de Usuarios

La aplicación dispone de un sistema de Log In que permite que aquellos usuarios registrados accedan a la aplicación con su rol correspondiente.
El rol del usuario en la aplicación condiciona las funcionalidades a las que este puede acceder dentro de la misma.

### Roles

Los roles de la aplicación son los siguientes:
- Jugador
- Entrenador
  - Añade horarios de entrenamiento a su equipo
  - Asigna franjas para posibles entrevistas a sus jugadores
- Gerente
  - Añade, modifica y elimina a empleados de la aplicación
  - Modifica los horarios de los empleados
  - Visualiza el historial de ventas del club
  - Añade equipos
  - Crea partidos
  - Crea y gestiona campañas de venta de acciones del club
  - Visualiza gráficos estadísticos que muestran la situación económica del club
- Vendedor de Entradas y Abonos
  - Vende entradas
  - Vende abonos
- Encargado de Tienda
  - Realiza compras de merchandising
- Gestor de Instalaciones
  - Gestiona la reserva de instalaciones deportivas a clientes ajenos al club
- Empleado de Tienda
  - Realiza compras de merchandising
- Empleado de Jardinería
- Empleado de Cocina
- Director de Comunicaciones
  - Crea entrevistas para los jugadores en sus franjas disponibles
  - Crea noticias para visualizar en el portal de noticias
- Accionista
  - Compra y vende acciones
- No Usuario (Entrar sin iniciar sesión)
  - Visualiza el portal de noticias
  - Accede a campañas de accionistas, convirtiendose en accionista en caso de comprar alguna acción

## Pantallas de la Aplicación

Toda la interfaz de usuario ha sido desarrollada utilizando java swing e incorporando algunos componentes nuevos por medio de librerías.

A continuación se muestran algunas imágenes de muestra de la aplicación:

### Menú Inicial (Caso del Gerente)

![menuGerente.jpg](docs/multimedia/menuGerente.jpg)

### Compra de Merchandising

![tiendaMerch.jpg](docs/multimedia/tiendaMerch.jpg)

### Menú de Modificación de Empleados

![modEmpleados.jpg](docs/multimedia/modEmpleados.jpg)

### Gráfico Económico

![graficoEconomico.jpg](docs/multimedia/graficoEconomico.jpg)

### Compra de Abonos

![compraAbono.jpg](docs/multimedia/compraAbono.jpg)

### Portal de Accionistas

![portalAccionista.jpg](docs/multimedia/portalAccionista.jpg)

## Sistema de Log

La aplicación genera un log por cada ingreso de un usuario en la misma, registrando las acciones que dicho usuario realiza por medio de lecturas o escrituras en la base de datos

## Tecnologías Utilizadas

El sistema de gestión de bases de datos utilizado ha sido HSQLDB

Se han utilizado múltiples librerías Java:
- JCalendar: para la introducción de nuevos componentes de selección de fechas en java swing
- JFreeChart: para la introducción de nuevos componentes de visualización de gráficos en java swing
- Jakarta Mail: para el envio de un correo electrónico de confirmación tras compras de merchandising
- iText: para la creación de un archivo pdf a modo de ticket para compras de merchandising

## Referencias Utilizadas

Para el desarrollo de este proyecto se ha utilizado material proveniente del equipo Burgos CF a cuya web oficial puedes acceder haciendo [click aquí](https://www.burgoscf.es/)

Todos los derechos sobre dicho contenido pertenecen a ellos y se utilizan únicamente con fines académicos y no comerciales.

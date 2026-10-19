
# Gas Mapocho - Microservicio de Reportes

Este repositorio contiene el microservicio de reportes de **Gas Mapocho**, proyecto que estamos desarrollando para el curso de Desarrollo de Aplicaciones Web II de Cibertec.

Este módulo se encarga de reunir información de los demás microservicios para poder consultar datos relacionados con los balones de gas y sus movimientos dentro del almacén.

La idea es tener un servicio dedicado a las consultas y reportes, sin tener que realizar todo este trabajo directamente desde los módulos de balones o movimientos.

## Tecnologías utilizadas

Para desarrollar este microservicio estamos utilizando:

- Java 25
- Spring Boot 4.1.1
- Spring Cloud 2025.1.3
- Spring Security
- Spring Cloud OpenFeign
- Netflix Eureka Client
- Spring Cloud Config Client
- JWT
- Maven
- Docker

## ¿Qué hace este microservicio?

El servicio de reportes está pensado para reunir información de diferentes partes del sistema y presentarla de una manera más ordenada.

Principalmente trabajamos con los datos que proporcionan los microservicios de balones y movimientos.

Entre las funciones que buscamos cubrir están:

- Consultar información del catálogo de balones.
- Obtener datos relacionados con los movimientos del inventario.
- Reunir información de diferentes microservicios.
- Facilitar la consulta de entradas y salidas de balones.
- Preparar información que pueda utilizarse en reportes del sistema.

Por ejemplo, si necesitamos revisar los movimientos de los balones, este servicio puede solicitar los datos correspondientes y reunirlos para mostrarlos en una sola consulta.

## ¿Cómo funciona?

A diferencia de otros módulos, este microservicio está enfocado principalmente en consultar información que ya se encuentra en otros servicios.

Para comunicarnos con ellos utilizamos **OpenFeign**, que permite realizar peticiones HTTP entre microservicios.

También contamos con Eureka Client para localizar los servicios disponibles y Config Client para obtener las configuraciones desde el Config Server.

En cuanto a la seguridad, el proyecto incluye Spring Security y dependencias de JWT para trabajar con la autenticación de las peticiones.

## Requisitos

Antes de ejecutar el proyecto necesitamos:

- JDK 25
- Git
- Maven o el Maven Wrapper incluido
- Docker (opcional)

También debemos revisar las conexiones con los servicios de infraestructura y los microservicios que proporcionan la información.

## Instalación

Primero clonamos el repositorio:

```bash
git clone https://github.com/Sophia-1827/DAW-II_Grupo09_gasmapocho_ms-reportes.git
```

Ingresamos a la carpeta:

```bash
cd DAW-II_Grupo09_gasmapocho_ms-reportes
```

Compilamos el proyecto:

```bash
.\mvnw.cmd clean install
```

Finalmente, ejecutamos el microservicio:

```bash
.\mvnw.cmd spring-boot:run
```

Estos comandos están pensados para Windows. Si utilizamos Linux o macOS, podemos reemplazar `.\mvnw.cmd` por `./mvnw`.

## Configuración

El proyecto utiliza Spring Cloud Config Client para obtener sus propiedades desde el Config Server.

También cuenta con Eureka Client para integrarse con el descubrimiento de servicios.

Es importante revisar que las direcciones de los servicios estén configuradas correctamente antes de iniciar la aplicación.

El Dockerfile expone el puerto **8084**, por lo que debemos comprobar que coincida con el puerto establecido en la configuración del microservicio.

## Comunicación con otros microservicios

Una de las partes principales de este módulo es la comunicación con los servicios de balones y movimientos.

- **Microservicio de Balones:** proporciona información relacionada con los productos del catálogo.
- **Microservicio de Movimientos:** proporciona los registros de entradas, salidas y otros movimientos del inventario.
- **Eureka Server:** permite localizar los servicios registrados.
- **Config Server:** administra las configuraciones del sistema.
- **API Gateway:** funciona como punto de entrada para las peticiones del sistema.

Gracias a OpenFeign podemos realizar consultas a otros microservicios sin tener que manejar manualmente todas las llamadas HTTP.

## Ejecución con Docker

El repositorio también incluye un Dockerfile para ejecutar el proyecto dentro de un contenedor.

Primero construimos la imagen:

```bash
docker build -t gasmapocho-ms-reportes .
```

Luego ejecutamos el contenedor:

```bash
docker run -p 8084:8084 gasmapocho-ms-reportes
```

Para que funcione correctamente, debemos asegurarnos de que el contenedor tenga acceso a los servicios que necesita consultar.

## Relación con Gas Mapocho

Este microservicio forma parte de la arquitectura general de Gas Mapocho.

Mientras que otros módulos se encargan de registrar usuarios, administrar balones o guardar los movimientos del inventario, el servicio de reportes se ocupa de reunir información para realizar consultas.

Separar esta responsabilidad nos ayuda a mantener el proyecto más organizado y evita que cada microservicio tenga que encargarse también de generar reportes.

## Pruebas

El proyecto incluye dependencias de Spring Boot Test y Spring Security Test.

Para ejecutar las pruebas podemos utilizar:

```bash
.\mvnw.cmd test
```

Esto nos permite revisar las pruebas implementadas y comprobar el funcionamiento del proyecto antes de integrar nuevos cambios.

## Curso

**Desarrollo de Aplicaciones Web II**

**Instituto:** Cibertec

**Grupo:** 09

**Proyecto:** Gas Mapocho

# Entrega Proyecto 1 - Escenario 3

## Contexto del proyecto

El proyecto actual consiste en una API REST realizada con java y Spring Boot que maneja productos y categorias de producto y guarda la información en una base de datos MySQL.

## Objetivos de la entrega
- Crear repositorio en Github + agregar colaboradores
- Crear documento txt con los nombres -> Se puede encontrar el archivo como colaboradores.txt
- Crear dos contenedores y realizar la comunicación entre ellos

# Desarrollo de los Objetivos:
# Paso 1
- Descargar la imagen de mysql:
```bash
  Docker pull mysql:latest
```

# Paso 2
- Construir la imagen de la API REST de Spring (Nuestra aplicación) usando un Dockerfile:
  **Ejecutar comando 1:**
```bash
FROM amazoncorretto:17-alpine
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```
**Ejecutar comando 2:**
```bash
docker build -t my-app:v1 .
```
# Paso 3
- Crear Docker-compose.yml para configurar la creacion y conexion de los contenedores:

```
services:
  integracion-continua:
    image: my-app:v1
    ports:
      - "8080:9191"
    restart: always
    depends_on:
      my-mysql:
        condition: service_healthy
  my-mysql:
    image: mysql:8.0.33
    ports:
      - "3307:3306"
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: course
    restart: always
    healthcheck:
      test: ["CMD", "mysqladmin" ,"ping", "-h", "localhost"]
      timeout: 10s
      retries: 10
```
**Y despues ejecutar el siguiente comando:**
```bash
docker compose -p integracion-continua up -d
```
# Detalle de la configuración, creación y conexión de los contenedores

## spring-api-rest:

- image: my-app:v1 indica que este servicio utilizará la imagen llamada my-app con la etiqueta v1.

- ports: 8080:9191 mapea el puerto 8080 en el host al puerto 9191 en el contenedor.

- restart: always asegura que el contenedor se reinicie siempre que se detenga.

- depends_on: indica que este servicio depende de my-mysql y esperará a que el servicio my-mysql esté saludable antes de iniciarse.

## my-mysql:

- image: mysql:8.0.33 indica que se usará la imagen de MySQL versión 8.0.33.

- ports: 3307:3306 mapea el puerto 3307 en el host al puerto 3306 en el contenedor.

- environment:

    - MYSQL_ROOT_PASSWORD: configura la contraseña de  root como root.

    - MYSQL_DATABASE: crea una base de datos llamada course.

- restart: always asegura que el contenedor se reinicie siempre que se detenga.

- healthcheck: define una verificación de salud para el contenedor:

    - test: ejecuta el comando mysqladmin ping -h localhost para verificar que MySQL esté operativo.

    - timeout: espera 10 segundos para que la verificación se complete.

    - retries: intenta la verificación 10 veces antes de considerarlo fallido.

# Contenedores y comunicación
**Este docker-compose.yml define dos contenedores:**

- spring-api-rest

- my-mysql

## Comunicación entre contenedores
spring-api-rest depende de my-mysql. Esta dependencia asegura que my-mysql esté en funcionamiento y saludable antes de que spring-api-rest se inicie.

Los dos contenedores estarán en la misma red Docker por defecto, lo que les permitirá comunicarse entre sí utilizando los nombres de los servicios (spring-api-rest y my-mysql).

En resumen, este archivo (docker-compose.yml) crea dos contenedores Docker: uno para una aplicación Spring API y otro para una base de datos MySQL, asegurando que la base de datos esté lista y saludable antes de que la aplicación intente conectarse a ella.
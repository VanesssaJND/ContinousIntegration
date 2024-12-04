# Introducción

Este proyecto tiene como objetivo contenerizar una aplicación utilizando Docker, asegurando su portabilidad y facilidad de despliegue en cualquier entorno. La aplicación consiste en una API-REST desarrollada con Spring Boot, junto con la integración de servicios necesarios, como una base de datos. Para gestionar los contenedores y facilitar su configuración, se utiliza Docker Compose. El proyecto también incluye pruebas de conexión entre contenedores, demostrando su correcto funcionamiento.

# Componentes del Proyecto

# Docker

Contenerización:

El proyecto se encuentra contenerizado utilizando Docker, lo que asegura que la aplicación se ejecute de manera consistente sin importar el entorno. Esto elimina problemas de compatibilidad que pueden surgir en entornos de desarrollo, pruebas y producción.

# Docker Compose:

Docker Compose se utiliza para gestionar múltiples contenedores dentro del mismo entorno. Define la configuración de contenedores en un archivo docker-compose.yml, lo que facilita la ejecución de la aplicación junto con los servicios dependientes, como bases de datos.

# Archivos principales:

docker-compose.yml:

Este archivo contiene la configuración necesaria para ejecutar los contenedores de la aplicación y la base de datos. Aquí se especifican las redes, volúmenes y servicios involucrados.

Ejemplo de archivo docker-compose.yml:

yaml
Copiar código
version: '3'
services:
  app:
    image: myapp:latest
    container_name: app-container
    ports:
      - "8080:8080"
    depends_on:
      - db
  db:
    image: mysql:5.7
    container_name: db-container
    environment:
      MYSQL_ROOT_PASSWORD: example
      MYSQL_DATABASE: mydb
    ports:
      - "3306:3306"
Dockerfile:
El archivo Dockerfile se utiliza para crear una imagen personalizada de la aplicación, con todas las dependencias necesarias. A continuación se muestra un ejemplo de Dockerfile:

dockerfile
Copiar código
FROM openjdk:11-jre-slim
ADD target/myapp.jar myapp.jar
ENTRYPOINT ["java", "-jar", "/myapp.jar"]
Contenedores
Contenedores Apagados (Inactivos):
Cuando los contenedores están apagados, no se pueden realizar interacciones con la aplicación ni con la base de datos.
Resultado en Postman (Contenedores Apagados):
Al intentar realizar una petición a la API con los contenedores apagados, se recibirá un error de conexión.

Contenedores Encendidos (Funcionando):
Cuando los contenedores se inician correctamente, tanto la API como la base de datos están operativos, permitiendo la comunicación entre ellos y la interacción a través de la API.

Resultado de correcto funcionamiento (Contenedores Encendidos):
Una vez que los contenedores están en funcionamiento, se puede realizar una solicitud GET desde Postman y recibir una respuesta exitosa de la API.

Conexión entre Contenedores
Se verifica que desde un contenedor (por ejemplo, el de la API) se pueda hacer ping al contenedor de la base de datos para asegurar que la red entre los contenedores funciona correctamente.

Comando Ping entre Contenedores:

bash
Copiar código
docker exec -it app-container ping db-container
Resultado esperado:
La respuesta del ping indica que los contenedores pueden comunicarse correctamente entre sí.

# Jira
En este proyecto se gestionaron las actividades utilizando Jira, permitiendo el seguimiento de tareas, la planificación y la asignación de responsabilidades, garantizando una ejecución fluida de las actividades de desarrollo.

# GitHub
El código fuente del proyecto está alojado en GitHub, donde se gestionan las versiones y el control de código fuente. Los desarrolladores realizan cambios en ramas separadas y posteriormente se fusionan con la rama principal, asegurando un desarrollo organizado.

# Jenkins
Configuración de Jenkins
El archivo de configuración de Jenkins (Jenkinsfile) define el pipeline de CI/CD para automatizar la construcción, pruebas y despliegue de la aplicación.

Archivo de configuración Jenkinsfile:

groovy
Copiar código
pipeline {
  agent any
  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }
    stage('Build') {
      steps {
        script {
          sh 'mvn clean install'
        }
      }
    }
    stage('Test') {
      steps {
        script {
          sh 'mvn test'
        }
      }
    }
    stage('Deploy') {
      steps {
        script {
          sh 'docker-compose up -d'
        }
      }
    }
  }
}
Pipeline en Jenkins
El pipeline de Jenkins automatiza el proceso de construcción, prueba y despliegue. El pipeline más reciente se ejecutó sin errores, con una duración de 1 minuto y 32 segundos. Esto garantiza que el flujo de trabajo se ejecute correctamente y se despliegue la aplicación en contenedores Docker.

Resultado del Pipeline:

Duración: 1 minuto y 32 segundos
Estado: Exitoso (verde)
Codecov
La integración con Codecov permite medir la cobertura de las pruebas automatizadas, asegurando que el código tiene una cobertura adecuada y ayudando a identificar áreas que requieren más pruebas.

# Sentry
La integración de Sentry proporciona monitoreo en tiempo real para detectar errores en la aplicación. Esto ayuda al equipo de desarrollo a solucionar problemas rápidamente y mantener la estabilidad del sistema.

Resultados
Se logró construir una API-REST con Spring Boot, contenerizarla utilizando Docker y automatizar el proceso de CI/CD con Jenkins. La integración de herramientas como Jira, Sentry y Codecov mejoró la colaboración, el monitoreo y la calidad del software, respectivamente.

# Conclusiones
Automatización de Procesos:
La implementación de Docker, Jenkins y GitHub optimizó el flujo de trabajo al automatizar tareas como construcción, pruebas y despliegue.

Mejora en la Estabilidad:
Sentry permitió un monitoreo efectivo de la aplicación, ayudando a detectar y corregir errores rápidamente.

Aseguramiento de la Calidad:
La cobertura de pruebas se incrementó mediante Codecov, garantizando un código más confiable y robusto.

Colaboración Eficiente:
El uso de Jira y GitHub facilitó la gestión de tareas y versiones, promoviendo una colaboración más fluida entre los miembros del equipo.

Desarrollo Ágil y Continuo:
La integración continua (CI) permitió ciclos de desarrollo rápidos, asegurando la entrega constante de nuevas funcionalidades.

# Entrega Proyecto 
## Introducción
Este proyecto tiene como objetivo desarrollar una API-REST utilizando el framework Spring Boot, contenerizar la aplicación con Docker para asegurar su portabilidad y facilidad de despliegue, y automatizar el proceso de integración y despliegue continuo utilizando Jenkins.

# Componentes del Proyecto
## Spring Boot:

**Desarrollo de la API:** La API se desarrolla utilizando Spring Boot, un framework robusto y flexible para construir aplicaciones Java.

**Gestión de Dependencias:** Utilizamos Maven para gestionar las dependencias y el ciclo de vida del proyecto.

## Docker:

**Contenerización:** La aplicación Spring Boot se empaca en una imagen Docker. Esto garantiza que la aplicación se ejecute de manera consistente en diferentes entornos, eliminando problemas de compatibilidad.

**Docker Compose:** Utilizamos Docker Compose para definir y ejecutar aplicaciones multicontenedor. Esto es particularmente útil para configurar servicios dependientes, como bases de datos.

## Jenkins:

**Automatización de CI/CD:** Jenkins se configura para gestionar el ciclo de vida de integración y entrega continua. Esto incluye la construcción automática del proyecto, la ejecución de pruebas y el despliegue de la aplicación.

**Pipeline:** Definimos un pipeline de Jenkins usando un archivo Jenkinsfile, que incluye etapas para el checkout del código, construcción de la aplicación, ejecución de pruebas y despliegue en un entorno de pruebas o producción.

# Flujo de Trabajo
## Desarrollo:

* Los desarrolladores realizan cambios en el código fuente y los suben al repositorio de Git.

## Construcción y Pruebas:

* Jenkins detecta los cambios en el repositorio y ejecuta el pipeline.

* La aplicación se construye utilizando Maven.

* Si las pruebas se ejecutan, Jenkins asegura que todo funcione correctamente antes de proceder al despliegue.

## Despliegue:

* La imagen Docker se construye y se despliega utilizando Docker Compose.

* La aplicación se ejecuta en contenedores Docker, facilitando el manejo de dependencias y configuraciones.

## Notificaciones:

* Jenkins envía notificaciones automáticas (por correo electrónico o Slack) sobre el estado de cada build y despliegue, manteniendo al equipo informado en todo momento ante cada evento.

# Beneficios del Proyecto
**Escalabilidad:** Docker permite escalar fácilmente la aplicación distribuyendo contenedores.

**Automatización:** Jenkins automatiza el proceso de CI/CD, mejorando la eficiencia del equipo de desarrollo.

**Portabilidad:** Con Docker, la aplicación puede ejecutarse en cualquier entorno que soporte contenedores Docker, asegurando consistencia.

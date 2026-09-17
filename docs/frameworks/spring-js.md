# Spring Boot y JavaScript en Linux

“Spring JS” suele referirse a un backend Spring consumido por una interfaz JavaScript; Spring Boot no es un framework JavaScript. Esta guia usa Java 17+, Maven o Gradle y Node.js.

## Backend Spring Boot

Crea el proyecto desde Spring Initializr con Java, Spring Web y, si hace falta, Spring Data JPA. En un proyecto Maven:

```bash
./mvnw spring-boot:run
```

En un proyecto Gradle:

```bash
./gradlew bootRun
```

Una API local suele quedar en `http://127.0.0.1:8080`. Configura CORS solo para los origenes de desarrollo conocidos y usa perfiles (`application-dev.yml`, `application-test.yml`) para separar entornos.

## Frontend JavaScript

Con Vite, por ejemplo:

```bash
npm create vite@latest frontend -- --template vanilla
cd frontend
npm install
npm run dev -- --host 0.0.0.0
```

Configura la URL de la API mediante una variable `VITE_API_URL`; no hardcodees `localhost` si el cliente se ejecutara en un telefono.

## Pruebas

```bash
./mvnw test
npm run build
```

Para HyperOS, usa la IP LAN del equipo en `VITE_API_URL` y permite el puerto del backend en el firewall. Prueba la API desde el navegador del dispositivo antes de depurar la interfaz hibrida.

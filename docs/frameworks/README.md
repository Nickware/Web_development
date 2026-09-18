# Frameworks y runtimes

Esta carpeta documenta tecnologías que trabajan junto con los lenguajes del repositorio:

- **Flutter**: toolkit multiplataforma basado en Dart para interfaces móviles, web y escritorio.
- **Tokio**: runtime asíncrono de Rust para servicios concurrentes y operaciones de red.
- **Gin**: framework HTTP de Go para construir APIs y microservicios rápidos.

## Relación entre las tecnologías

Una arquitectura habitual puede usar Flutter como cliente, Gin como API pública y Tokio como un servicio Rust especializado en tareas concurrentes, simulación o procesamiento intensivo. La minería de datos y la programación de AI normalmente se implementan mediante librerías adicionales; estos frameworks aportan la interfaz, el transporte HTTP y la concurrencia necesarios para integrarlas.

## Documentos

- [Flutter](flutter.md)
- [Tokio](tokio.md)
- [Gin](gin.md)

## Flujo de trabajo sugerido

1. Modelar las entidades, eventos y contratos JSON.
2. Implementar la API con Gin o un servicio concurrente con Tokio.
3. Conectar la aplicación Flutter mediante HTTP, WebSocket o gRPC.
4. Ejecutar simulaciones y trabajos de minería fuera del hilo de la interfaz.
5. Exponer la inferencia de AI detrás de una API autenticada y validada.

## Ejemplo de arquitectura

```text
Flutter (Dart)
       |
       | HTTPS / WebSocket
       v
Gin (Go) ---- PostgreSQL / almacenamiento
       |
       | cola o HTTP interno
       v
Tokio (Rust) ---- simulación, minería y clientes de modelos
```

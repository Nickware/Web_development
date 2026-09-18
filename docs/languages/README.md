# Lenguajes y tecnologías emergentes

Esta carpeta reúne una guía rápida de lenguajes modernos y tendencias relevantes en desarrollo de software, IA, backend, frontend y sistemas de alto rendimiento.

## Objetivo

Documentar tecnologías actuales que están marcando la dirección del ecosistema tecnológico, con foco en:

- productividad del desarrollador
- rendimiento y escalabilidad
- interoperabilidad
- IA y automatización
- ecosistemas modernos de desarrollo

## Lenguajes y tendencias principales

### 1. Kotlin
- Popular en Android, backend y multiplataforma
- Diseñado para ser conciso, seguro y interoperable con Java
- Excelente para desarrollo moderno y aplicaciones empresariales

### 2. TypeScript
- Superconjunto de JavaScript con tipado estático
- Base de muchos proyectos frontend y backend modernos
- Muy usado con React, Node.js, Next.js y frameworks full-stack

### 3. Rust
- Enfocado en rendimiento, seguridad de memoria y concurrencia
- Muy fuerte en sistemas, compiladores, herramientas CLI y web assembly
- Crece mucho en infraestructura y desarrollo de bajo nivel

### 4. Go
- Rápido, simple y muy utilizado en APIs, microservicios y herramientas cloud
- Excelente para infraestructura, DevOps y servicios escalables
- Muy popular en entornos distribuidos

### 5. Python
- Dominante en IA, ciencia de datos, automatización y backend rápido
- Ideal para prototipos, ML, scripts y servicios de negocio
- Gran comunidad y ecosistema de librerías

### 6. Zig
- lenguaje prometedor para sistemas y rendimiento cercano al bajo nivel
- busca una sintaxis simple con control preciso de memoria
- tendencia fuerte en herramientas y infraestructura

### 7. WebAssembly / WASM
- No es un lenguaje puro, pero es una tendencia clave
- Permite ejecutar código de alto rendimiento en navegador y servidores
- Muy relevante para gaming, edición, videoconferencia y aplicaciones exigentes

### 8. AI-first development
- No es un lenguaje, pero sí una tendencia de diseño
- La IA está transformando desarrollo, testing, documentación y generación de código
- Cada vez más proyectos integran agentes y asistentes de programación

## Índice de documentos

- [Kotlin](kotlin.md)
- [TypeScript](typescript.md)
- [Rust](rust.md)
- [Go](go.md)

## Recomendación de aprendizaje

Para empezar bien en tecnologías emergentes, conviene priorizar:

1. fundamentos sólidos de programación
2. un lenguaje moderno con ecosistema real
3. herramientas de desarrollo y testing
4. comprensión de arquitectura y rendimiento
5. uso de IA como apoyo, no como reemplazo del criterio

## Instalación y configuración en Linux

La mayoría de estas tecnologías se instalan en Linux con gestores de versiones o binarios oficiales:

- Kotlin: SDKMAN o JDK + Gradle
- TypeScript: Node.js + npm/nvm
- Rust: rustup
- Go: descarga oficial del binario o paquete del sistema

## Ejemplo de testing con Ollama

Un caso práctico y muy útil en 2026 es probar integración con un modelo local usando Ollama.

```bash
# 1. Instalar Ollama
curl -fsSL https://ollama.com/install.sh | sh

# 2. Iniciar el servicio
ollama serve

# 3. Descargar un modelo local
ollama pull llama3.2

# 4. Probar la respuesta
ollama run llama3.2 "Escribe un resumen breve sobre Rust para un backend moderno"
```

Este enfoque permite validar el comportamiento localmente sin depender de APIs externas.

## Conclusión

El panorama actual combina lenguajes modernos, performance y productividad. Kotlin y TypeScript son muy relevantes hoy, pero también conviene mirar Rust, Go y otros enfoques que marcan las tendencias futuras.

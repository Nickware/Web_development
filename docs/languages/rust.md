# Rust

Rust es un lenguaje de programación enfocado en rendimiento, seguridad de memoria y concurrencia. Ha ganado mucha popularidad por su capacidad de crear software robusto y eficiente.

## ¿Por qué es importante?

- sin errores de memoria comunes de C/C++
- muy rápido en ejecución
- excelente para sistemas, herramientas y servicios de alto rendimiento
- creciente adopción en infraestructura y compilación

## Ventajas

- seguridad de memoria a nivel del compilador
- muy buen rendimiento
- excelente para programación concurrente
- ecosistema fuerte para herramientas y desarrollo de bajo nivel

## Casos de uso

- sistemas operativos y motores
- herramientas CLI
- desarrollo web con Rust y WASM
- backend de alto rendimiento
- infraestructura y networking

## Ecosistema

- Cargo
- Tokio
- Axum
- wasm-bindgen
- Rust Analyzer

## Tendencia

Rust es uno de los lenguajes con mayor relevancia técnica en la actualidad por su enfoque en seguridad, velocidad y nuevas arquitecturas modernas.

## Instalación y configuración en Linux

### 1. Instalar Rust con rustup

```bash
curl --proto '=https' --tlsv1.2 -sSf https://sh.rustup.rs | sh
source "$HOME/.cargo/env"
rustc --version
cargo --version
```

### 2. Crear un proyecto nuevo

```bash
cargo new mi-rust-app
cd mi-rust-app
```

### 3. Ejecutar ejemplo básico

```rust
fn main() {
    println!("Hola desde Rust en Linux");
}
```

```bash
cargo run
```

## Ejemplo de testing con criptografía

Rust es muy bueno para operaciones criptográficas, por ejemplo, calcular un hash SHA-256.

```rust
use sha2::{Digest, Sha256};

fn main() {
    let data = b"mensaje secreto";
    let hash = Sha256::digest(data);
    println!("Hash SHA-256: {:x}", hash);
}
```

```bash
cargo add sha2
cargo run
```

Este tipo de validación permite comprobar integridad y seguridad de datos con una implementación rápida y confiable.

## En resumen

Rust es una excelente opción para proyectos donde el rendimiento y la confiabilidad son críticos.

# Tokio

Tokio es un runtime asíncrono para Rust. Proporciona un planificador de tareas, primitivas de concurrencia, temporizadores y utilidades de red. No es un framework de AI o minería por sí mismo: permite ejecutar esos trabajos de manera concurrente y controlada.

## Instalación y configuración

```bash
rustup update stable
cargo new procesador_tokio
cd procesador_tokio
cargo add tokio --features full
```

En `Cargo.toml`, una configuración mínima equivalente es:

```toml
[dependencies]
tokio = { version = "1", features = ["macros", "rt-multi-thread", "time", "sync"] }
```

## Modelamiento

Rust permite modelar una observación con tipos explícitos y serializarla con `serde`:

```bash
cargo add serde --features derive
```

```rust
use serde::{Deserialize, Serialize};

#[derive(Debug, Serialize, Deserialize)]
struct Observacion {
    timestamp: u64,
    valor: f64,
}
```

## Simulación concurrente

Las tareas Tokio pueden producir pasos de una simulación y enviarlos por un canal:

```rust
use tokio::sync::mpsc;

#[tokio::main]
async fn main() {
    let (tx, mut rx) = mpsc::channel(32);

    tokio::spawn(async move {
        for paso in 0..10 {
            tx.send(paso).await.expect("receptor activo");
        }
    });

    while let Some(paso) = rx.recv().await {
        println!("paso={paso}");
    }
}
```

## Minería de datos

Para procesar archivos o endpoints en paralelo, limita el número de tareas y usa un canal de resultados. Tokio coordina la E/S; el cálculo intensivo debe moverse a `spawn_blocking` o a un pool especializado para no bloquear el runtime.

```rust
let resultado = tokio::task::spawn_blocking(|| {
    // Calculo CPU-intensivo sobre una particion de datos.
    datos.iter().filter(|valor| **valor > 0.8).count()
}).await?;
```

## Programación AI

Tokio es adecuado para llamar varios servicios de inferencia de forma asíncrona. Con `reqwest` se pueden hacer solicitudes concurrentes y después combinar sus resultados:

```bash
cargo add reqwest --features json,rustls-tls
```

```rust
let cliente = reqwest::Client::new();
let respuesta = cliente
    .post("http://localhost:11434/api/generate")
    .json(&serde_json::json!({
        "model": "llama3.2",
        "prompt": "Clasifica esta observacion"
    }))
    .send()
    .await?;
```

En producción añade timeouts, reintentos con límite, cancelación y validación del resultado. Nunca asumas que una respuesta de un modelo es una decisión válida sin aplicar reglas de negocio.

## Ejecución y pruebas

```bash
cargo fmt
cargo check
cargo test
cargo run
```

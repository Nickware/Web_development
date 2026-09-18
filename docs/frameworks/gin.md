# Gin

Gin es un framework HTTP ligero para Go. Incluye enrutamiento, middleware, binding de JSON y respuestas JSON, por lo que es una buena capa API para una aplicación Flutter o para coordinar servicios especializados escritos en Rust con Tokio.

## Instalación y configuración

```bash
mkdir api-datos && cd api-datos
go mod init example.com/api-datos
go get github.com/gin-gonic/gin
```

Servidor mínimo:

```go
package main

import "github.com/gin-gonic/gin"

func main() {
    router := gin.Default()
    router.GET("/health", func(context *gin.Context) {
        context.JSON(200, gin.H{"status": "ok"})
    })
    router.Run(":8080")
}
```

Ejecuta y prueba:

```bash
go run .
curl http://localhost:8080/health
```

## Modelamiento

Los structs de Go definen el contrato de entrada y salida de la API:

```go
type Muestra struct {
    ID    int     `json:"id" binding:"required"`
    Valor float64 `json:"valor" binding:"required"`
}

func crearMuestra(context *gin.Context) {
    var muestra Muestra
    if err := context.ShouldBindJSON(&muestra); err != nil {
        context.JSON(400, gin.H{"error": err.Error()})
        return
    }
    context.JSON(201, muestra)
}
```

## Simulación

Una ruta puede iniciar un trabajo y devolver un identificador para consultar su progreso. Para trabajos largos usa una cola o un worker; no mantengas una solicitud HTTP abierta indefinidamente.

```go
router.POST("/simulaciones", func(context *gin.Context) {
    context.JSON(202, gin.H{
        "job_id": "sim-001",
        "status": "queued",
    })
})
```

## Minería de datos

Gin puede exponer métricas agregadas calculadas previamente:

```go
router.GET("/frecuencias", func(context *gin.Context) {
    context.JSON(200, gin.H{
        "items": []gin.H{
            {"categoria": "A", "frecuencia": 42},
            {"categoria": "B", "frecuencia": 18},
        },
    })
})
```

En un sistema real valida filtros, pagina resultados, parametriza las consultas a la base de datos y evita devolver datos sensibles.

## Programación AI

Gin puede ofrecer una frontera estable para un modelo local o remoto. El cliente envía una solicitud validada y el handler delega la inferencia a un servicio interno.

```go
type PromptRequest struct {
    Prompt string `json:"prompt" binding:"required,min=1,max=4000"`
}

router.POST("/ai/chat", func(context *gin.Context) {
    var request PromptRequest
    if err := context.ShouldBindJSON(&request); err != nil {
        context.JSON(400, gin.H{"error": err.Error()})
        return
    }
    // En producción, delegar a un cliente AI con timeout y autenticación.
    context.JSON(200, gin.H{"prompt": request.Prompt, "status": "queued"})
})
```

## Configuración para producción

- Configura `GIN_MODE=release`.
- Añade autenticación, autorización, CORS restringido y límites de tamaño.
- Usa timeouts en el servidor y en clientes externos.
- Registra métricas sin exponer prompts o información personal.
- Ejecuta las pruebas con `go test ./...` y revisa dependencias con `go mod tidy`.

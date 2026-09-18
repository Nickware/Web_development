# Go

Go, o Golang, es un lenguaje creado por Google pensado para simplificar la programación concurrente, construir servicios rápidos y mantener código claro.

## ¿Por qué es importante?

- muy bueno para APIs y microservicios
- rendimiento alto y compilación muy rápida
- sincronización y concurrencia sencillas
- muy usado en infraestructura y cloud

## Ventajas

- sintaxis simple y clara
- excelente escalabilidad
- gran rendimiento para servicios web
- muy usado en herramientas DevOps

## Casos de uso

- APIs REST
- microservicios
- plataformas cloud
- servicios de infraestructura
- scraping y herramientas backend

## Ecosistema

- Gin
- Echo
- Fiber
- Kubernetes
- Docker

## Tendencia

Go sigue siendo una opción muy fuerte para equipos que necesitan construir servicios backend robustos, distribuidos y fáciles de operar.

## Instalación y configuración en Linux

### 1. Descargar Go

```bash
wget https://go.dev/dl/go1.22.6.linux-amd64.tar.gz
sudo rm -rf /usr/local/go
sudo tar -C /usr/local -xzf go1.22.6.linux-amd64.tar.gz
export PATH=$PATH:/usr/local/go/bin
go version
```

### 2. Crear un proyecto

```bash
mkdir mi-go-app && cd mi-go-app
go mod init mi-go-app
```

### 3. Programa inicial

```go
package main

import "fmt"

func main() {
    fmt.Println("Hola desde Go en Linux")
}
```

```bash
go run main.go
```

## Ejemplo de testing básico

Go incluye testing nativo con el paquete `testing`.

```go
package main

func sumar(a, b int) int {
    return a + b
}
```

```go
package main

import "testing"

func TestSumar(t *testing.T) {
    if sumar(2, 3) != 5 {
        t.Fatalf("sumar(2,3) = %d; want 5", sumar(2,3))
    }
}
```

```bash
go test ./...
```

Esto permite validar lógica de negocio y funciones públicas con pruebas rápidas y confiables.

## En resumen

Go es una tecnología muy poderosa para backend moderno, especialmente en entornos de alta escala y servicios cloud.

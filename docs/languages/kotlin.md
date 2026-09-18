# Kotlin

Kotlin es un lenguaje moderno, seguro y expresivo, desarrollado por JetBrains. Se usa ampliamente en Android, backend, multiplataforma y herramientas empresariales.

## ¿Por qué es importante?

- Interoperabilidad con Java
- Sintaxis más concisa y legible
- Null safety integrado
- Muy bueno para desarrollo Android
- Excelente en proyectos full-stack y backend con Ktor o Spring

## Ventajas

- Reduce boilerplate
- Evita muchos errores de null
- Mejora productividad del equipo
- Compatible con ecosistemas Java existentes

## Casos de uso

- aplicaciones móviles Android
- servicios backend
- ciencia de datos y aplicaciones empresariales
- desarrollo multiplataforma

## Herramientas comunes

- IntelliJ IDEA
- Android Studio
- Gradle
- Ktor
- Spring Boot

## Tendencia

Kotlin sigue ganando relevancia por su combinación de productividad, seguridad y compatibilidad con Java. También es clave en el desarrollo multiplataforma y en soluciones modernas para Android.

## Instalación y configuración en Linux

### 1. Instalar Java

```bash
sudo apt update
sudo apt install -y openjdk-17-jdk
java -version
```

### 2. Instalar Kotlin con SDKMAN

```bash
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk install kotlin
kotlin -version
```

### 3. Crear un proyecto mínimo

```bash
mkdir mi-kotlin-app && cd mi-kotlin-app
kotlinc -version
```

### 4. Crear un archivo principal

```kotlin
fun main() {
    println("Hola desde Kotlin en Linux")
}
```

### 5. Compilar y ejecutar

```bash
kotlinc Main.kt -include-runtime -d app.jar
java -jar app.jar
```

## Ejemplo de testing básico

Un ejemplo simple de prueba en Kotlin puede hacerse con JUnit o con una validación directa de función.

```kotlin
fun sumar(a: Int, b: Int): Int = a + b

fun main() {
    val resultado = sumar(2, 3)
    check(resultado == 5) { "La suma no es correcta" }
    println("Prueba exitosa: $resultado")
}
```

Esto permite validar lógica de negocio de forma rápida antes de integrar más componentes.

## En resumen

Kotlin es una tecnología muy sólida para proyectos modernos, especialmente donde se busca claridad, seguridad y compatibilidad con infraestructura Java.

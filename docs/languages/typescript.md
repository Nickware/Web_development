# TypeScript

TypeScript es un superset de JavaScript con tipado estático. Fue creado para hacer el desarrollo frontend y backend más seguro, escalable y mantenible.

## ¿Por qué es importante?

- reduce errores en tiempo de compilación
- mejora la mantenibilidad de proyectos grandes
- es el estándar en muchos ecosistemas modernos
- funciona muy bien con React, Node.js, Next.js y frameworks full-stack

## Ventajas

- tipado fuerte
- mejor autocompletado y navegación de código
- menos bugs en producción
- excelente integración con herramientas modernas

## Casos de uso

- aplicaciones web modernas
- frontend con React o Next.js
- APIs con Node.js y Express o NestJS
- aplicaciones empresariales complejas

## Ecosistema

- React
- Next.js
- Vite
- Node.js
- Express
- NestJS
- Prisma

## Tendencia

TypeScript se ha convertido en la base del desarrollo web moderno. La adopción masiva por parte de startups, empresas y comunidades de software lo posiciona como una tecnología esencial.

## Instalación y configuración en Linux

### 1. Instalar Node.js con nvm

```bash
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.40.1/install.sh | bash
source ~/.nvm/nvm.sh
nvm install --lts
node -v
npm -v
```

### 2. Crear un proyecto TypeScript

```bash
mkdir mi-ts-app && cd mi-ts-app
npm init -y
npm install typescript --save-dev
npx tsc --init
```

### 3. Configuración básica

```json
{
  "compilerOptions": {
    "target": "ES2020",
    "module": "CommonJS",
    "strict": true,
    "esModuleInterop": true,
    "outDir": "dist"
  }
}
```

### 4. Ejecutar un script

```ts
const mensaje: string = 'Hola desde TypeScript en Linux';
console.log(mensaje);
```

```bash
npx tsc
node dist/index.js
```

## Ejemplo de testing con Ollama

Un caso práctico muy útil es consultar un modelo local con Ollama desde TypeScript.

```ts
async function consultarModelo(prompt: string) {
  const respuesta = await fetch('http://localhost:11434/api/generate', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({
      model: 'llama3.2',
      prompt,
      stream: false
    })
  });

  const data = await respuesta.json();
  console.log(data.response);
}

consultarModelo('Explica brevemente qué es TypeScript para un frontend moderno');
```

### Ejecutar la prueba

```bash
# iniciar Ollama
ollama serve

# descargar modelo
ollama pull llama3.2

# ejecutar el script TypeScript
npx tsx app.ts
```

Este tipo de prueba valida cómo la aplicación se integra con IA local sin depender de servicios externos.

## En resumen

TypeScript es una tecnología clave para cualquier equipo que quiera construir software escalable, seguro y mantenible en la actualidad.

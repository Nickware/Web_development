# Ecosistema integrado de datos y analítica

Este proyecto define un entorno de desarrollo integrado para crear aplicaciones web con una capa de datos y analítica moderna, utilizando:

- PostgreSQL como base de datos relacional
- NocoDB para gestionar datos de forma visual y programática
- Metabase para análisis y dashboards
- Vite + React + TypeScript para la capa frontend
- Docker Compose para levantar todo el ecosistema de forma reproducible

La idea principal es tener un stack completo y listo para desarrollar aplicaciones con acceso a datos reales, interfaces visuales y reportes analíticos sin necesidad de configurar cada servicio a mano.

---

## Objetivo

Proporcionar una base práctica para:

- crear y administrar datos con PostgreSQL
- visualizar y gestionar registros desde NocoDB
- construir dashboards con Metabase
- conectar el frontend con APIs de datos
- trabajar con un entorno local consistente y fácil de replicar

---

## Arquitectura

El entorno está compuesto por cuatro bloques principales:

1. Base de datos
   - PostgreSQL
   - Almacena la información principal del sistema

2. Capa de gestión de datos
   - NocoDB
   - Permite administrar tablas, registros y esquemas de forma visual

3. Analítica y BI
   - Metabase
   - Permite crear consultas, reportes y paneles operativos

4. Frontend
   - Vite + React + TypeScript
   - Se conecta con la API de NocoDB y consume los datos del sistema

---

## Requisitos previos

Antes de iniciar, asegúrate de tener instalado:

- Docker
- Docker Compose
- Node.js y npm
- Visual Studio Code

---

## Estructura sugerida del proyecto

```text
web-ecosystem/
├── docker-compose.yml
├── frontend/
│   ├── package.json
│   ├── src/
│   ├── .env
│   └── ...
└── README.md
```

---

## 1. Configuración de Docker Compose

Crea un archivo llamado `docker-compose.yml` en la raíz del proyecto y agrega el siguiente contenido:

```yaml
version: '3.8'

services:
  postgres:
    image: postgres:15-alpine
    container_name: eco_postgres
    environment:
      POSTGRES_DB: main_db
      POSTGRES_USER: db_user
      POSTGRES_PASSWORD: db_password
    ports:
      - "5432:5432"
    volumes:
      - pgdata:/var/lib/postgresql/data
    networks:
      - eco-net

  nocodb:
    image: nocodb/nocodb:latest
    container_name: eco_nocodb
    environment:
      NC_DB: "pg://postgres:5432?u=db_user&p=db_password&d=main_db"
    ports:
      - "8080:8080"
    depends_on:
      - postgres
    networks:
      - eco-net

  metabase:
    image: metabase/metabase:latest
    container_name: eco_metabase
    environment:
      MB_DB_TYPE: postgres
      MB_DB_DBNAME: main_db
      MB_DB_PORT: 5432
      MB_DB_USER: db_user
      MB_DB_PASS: db_password
      MB_DB_HOST: postgres
    ports:
      - "3000:3000"
    depends_on:
      - postgres
    networks:
      - eco-net

volumes:
  pgdata:

networks:
  eco-net:
    driver: bridge
```

---

## 2. Levantar los servicios

Abre la terminal en la carpeta donde está el archivo `docker-compose.yml` y ejecuta:

```bash
docker compose up -d
```

Esto levantará en segundo plano:

- PostgreSQL en `localhost:5432`
- NocoDB en `http://localhost:8080`
- Metabase en `http://localhost:3000`

### Acceso a los servicios

- NocoDB: `http://localhost:8080`
- Metabase: `http://localhost:3000`

> En Metabase, al configurarlo por primera vez, usa `postgres` como host de la base de datos.

---

## 3. Crear el frontend con Vite

Dentro del mismo proyecto, crea la parte visual con Vite y React + TypeScript:

```bash
npm create vite@latest frontend -- --template react-ts
cd frontend
npm install
```

Si necesitas consumir APIs desde el frontend, puedes instalar Axios:

```bash
npm install axios
```

---

## 4. Variables de entorno

Dentro de la carpeta `frontend`, crea un archivo `.env` con la siguiente estructura:

```env
VITE_API_URL=http://localhost:8080/api/v1/db/data/v1/main_db
VITE_NOCODB_TOKEN=tu_token_de_api_generado_en_nocodb
```

Estas variables permiten conectar la app con los servicios de NocoDB y mantener la configuración separada del código fuente.

---

## 5. Configuración recomendada en VS Code

Para desarrollar de forma más eficiente, puedes instalar estas extensiones:

- Docker
- REST Client
- TypeScript React/JSX plugin

Esto facilita:

- revisar contenedores en ejecución,
- probar endpoints directamente,
- y trabajar mejor con React y TypeScript.

---

## 6. Ejecutar el frontend

En la carpeta del frontend, corre:

```bash
npm run dev
```

La aplicación quedará disponible en:

- `http://localhost:5173`

---

## 7. Flujo de trabajo recomendado

El flujo ideal suele ser:

1. Levantar PostgreSQL, NocoDB y Metabase con Docker.
2. Definir la estructura de datos en NocoDB.
3. Crear consultas y dashboards en Metabase.
4. Consumir la API desde el frontend en Vite.
5. Validar cambios y datos en tiempo real.

Este enfoque permite tener una base sólida para proyectos con administración de datos, paneles analíticos y una interfaz moderna.

---

## 8. Buenas prácticas

- Mantén la configuración de entorno en variables de entorno.
- No expongas credenciales sensibles en el código fuente.
- Usa contenedores para mantener un ambiente reproducible.
- Documenta los endpoints y campos de cada tabla.
- Usa Metabase para validar KPIs y análisis, y no solo como una capa visual.

---

## 9. Resultado esperado

Con este ecosistema, puedes trabajar con una solución integrada donde:

- la base de datos centraliza la información,
- NocoDB facilita la administración de datos,
- Metabase visualiza métricas y reportes,
- y Vite entrega una experiencia web moderna y rápida.

Es una base excelente para proyectos de dashboards, CRUDs, reporting y aplicaciones con análisis de negocio.

---

## 10. Siguiente paso

Si deseas, el siguiente nivel puede ser:

- conectar el frontend con la API de NocoDB,
- crear un modelo de datos real,
- preparar un dashboard con Metabase,
- o convertir este entorno en un proyecto más completo con autenticación y módulos de negocio.

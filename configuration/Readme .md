# Ecosistema integrado

Para poner en marcha este ecosistema de forma limpia, eficiente y completamente integrada, la estrategia ideal es utilizar **Docker Compose**. Esto permite levantar la infraestructura de datos y los paneles analíticos en contenedores aislados, mientras se deja un entorno de desarrollo frontend con **Vite** corriendo localmente en tu máquina a través de **Visual Studio Code**.

A continuación, se tiene el paso a paso detallado para configurar este entorno de punta a punta.

---

## Paso 1: Estructura del Proyecto y Configuración de Docker Compose

Crear una carpeta en el ordenador (por ejemplo, `web-ecosystem`) y dentro de ella un archivo llamado `docker-compose.yml`. Este archivo centralizará la base de datos PostgreSQL, NocoDB y Metabase.

Copiar y pegar la siguiente configuración:

```yaml
version: '3.8'

services:
  # 1. Base de datos central relacional
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

  # 2. Capa de gestión visual de datos (NocoDB)
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

  # 3. Inteligencia de Negocios y Analítica (Metabase)
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

## Paso 2: Levantar el Ecosistema de Datos y Servicios

Abrir terminal, ubícarse en la carpeta del proyecto y ejecutar el siguiente comando para poner en marcha los contenedores en segundo plano:

```bash
docker compose up -d

```

Una vez que los contenedores estén corriendo, tendrá acceso a los siguientes paneles desde el navegador:

* **NocoDB:** `http://localhost:8080` (La interfaz para administrar registros, crear tablas y gestionar datos de forma visual).
* **Metabase:** `http://localhost:3000` (El motor para conectar consultas y construir los tableros analíticos). Utiliza `postgres` como host al configurarlo por primera vez.

---

## Paso 3: Configurar el Frontend con Vite en Visual Studio Code

Ahora que la infraestructura de backend y datos está lista, configuraremos la interfaz a medida.

1. Abrir **Visual Studio Code**.
2. Abrir una terminal integrada en VS Code (`Ctrl + `` o `Cmd + ``) y crear una aplicación frontend moderna basada en Vite con TypeScript:

```bash
# Crear un proyecto Vite con TypeScript usando npm
npm create vite@latest frontend -- --template react-ts

# Entrar a la carpeta e instala las dependencias base
cd frontend
npm install

```

3. Instalar un cliente HTTP rápido (como `axios` o usa `fetch` nativo) para comunicarte con las APIs que NocoDB genera automáticamente sobre tu base de datos:

```bash
npm install axios

```

---

## Paso 4: Estructurar el Entorno en VS Code

Para trabajar cómodamente con este entorno unificado, te sugiero la siguiente estructura de espacio de trabajo en VS Code:

1. Crear un archivo `.env` dentro de la carpeta `frontend/` para manejar las variables de entorno de la aplicación Vite:
```env
VITE_API_URL=http://localhost:8080/api/v1/db/data/v1/main_db
VITE_NOCODB_TOKEN=tu_token_de_api_generado_en_nocodb

```


2. Instalar extensiones clave en VS Code para potenciar este flujo:
* **Docker:** Para monitorear, apagar o reiniciar los contenedores de Postgres, NocoDB y Metabase sin salir del editor.
* **REST Client:** Permite probar las APIs de NocoDB directamente escribiendo archivos `.http` en tu proyecto.
* **TypeScript Vue/React Plugin** (según el framework que elijas sobre Vite).



---

## Paso 5: Ejecución y Desarrollo Diario

Para empezar a desarrollar y conectar la aplicación visual con la base de datos:

1. Iniciar el servidor de desarrollo ultrarrápido de Vite:
```bash
cd frontend
npm run dev

```


2. La aplicación estará corriendo instantáneamente en `http://localhost:5173`.
3. Cualquier cambio que realce en la base de datos a través de **NocoDB** se reflejará inmediatamente en la consulta desde el código con **Vite**, mientras mide el impacto de los datos en tiempo real con **Metabase**.
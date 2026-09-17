# Laravel en Linux

Laravel es un framework PHP para aplicaciones web y APIs. Esta guia asume PHP, Composer y Node.js instalados; revisa [la preparacion comun de Linux](linux.md).

## Instalacion

Instala Composer siguiendo su instalador oficial y valida la firma antes de ejecutarlo. Despues crea una aplicacion:

```bash
composer create-project laravel/laravel ejemplo-laravel
cd ejemplo-laravel
cp .env.example .env
php artisan key:generate
npm install
npm run build
```

Para desarrollo local:

```bash
php artisan serve
```

Abre `http://127.0.0.1:8000`. Para SQLite:

```bash
touch database/database.sqlite
php artisan migrate
```

Configura `DB_CONNECTION=sqlite` en `.env` y no subas ese archivo al repositorio.

## Configuracion minima

- Ejecuta `php artisan about` para revisar el entorno.
- Usa `.env.testing` para pruebas y una base de datos separada.
- Ejecuta `php artisan test` antes de integrar cambios.
- Para una API, define rutas en `routes/api.php` y valida entradas con Form Requests.

## Prueba desde HyperOS

El telefono debe acceder a la IP LAN del equipo, no a `127.0.0.1`. Inicia el servidor escuchando en la red:

```bash
php artisan serve --host=0.0.0.0 --port=8000
```

Abre `http://IP_DE_LINUX:8000` desde el navegador del Xiaomi. Permite el puerto 8000 en el firewall solo dentro de la red de pruebas y cierralo al terminar.

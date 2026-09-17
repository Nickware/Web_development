# Instalacion y configuracion en Linux

Estas instrucciones usan Ubuntu/Debian como referencia. En Fedora, sustituye `apt` por `dnf` y usa los nombres equivalentes de los paquetes.

## Paquetes base

```bash
sudo apt update
sudo apt install -y git curl unzip zip build-essential ca-certificates \
  php-cli php-mbstring php-xml php-curl php-zip php-sqlite3 \
  openjdk-17-jdk nodejs npm
```

Comprueba las herramientas:

```bash
php --version
java -version
node --version
npm --version
```

## Versiones y gestores recomendados

- Usa `nvm` para cambiar versiones de Node.js sin modificar el sistema.
- Usa `sdkman` si necesitas alternar JDK 17 y JDK 21.
- Mantén Android SDK y las licencias en el usuario que ejecuta Android Studio.
- No ejecutes Composer, npm, Gradle o Cordova con `sudo` dentro del proyecto.

## Variables Android

Después de instalar Android Studio y el SDK:

```bash
export ANDROID_HOME="$HOME/Android/Sdk"
export PATH="$ANDROID_HOME/platform-tools:$ANDROID_HOME/cmdline-tools/latest/bin:$PATH"
```

Añade esas líneas a `~/.bashrc` o `~/.zshrc`. Verifica el dispositivo con:

```bash
adb version
adb devices
```

Para un teléfono Xiaomi con HyperOS, activa Opciones de desarrollador, Depuracion USB y, si el sistema lo solicita, Depuracion USB (configuracion de seguridad). Autoriza la huella RSA en el teléfono.

## Permisos USB en Linux

Si `adb devices` muestra `no permissions`, instala las reglas udev de Android del fabricante, desconecta y vuelve a conectar el teléfono, y reinicia el servidor ADB:

```bash
adb kill-server
adb start-server
adb devices
```

Consulta también [Android Studio](android-studio.md), [Laravel](laravel.md), [Spring Boot y JavaScript](spring-js.md) y [Cordova](cordova.md).

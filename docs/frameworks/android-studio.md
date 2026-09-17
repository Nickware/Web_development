# Android Studio en Linux

Android Studio es el IDE oficial para compilar y depurar aplicaciones Android. Instala el IDE desde la distribucion oficial, abre el SDK Manager e instala Android SDK Platform, Build-Tools, Platform-Tools y un emulador si lo necesitas.

## Configuracion del proyecto

- Usa Kotlin y Gradle Wrapper (`./gradlew`) para fijar la version de Gradle.
- Configura `ANDROID_HOME` como se explica en [Linux](linux.md).
- Acepta licencias con `sdkmanager --licenses` despues de instalar las command-line tools.
- Ejecuta `./gradlew test` y `./gradlew assembleDebug` antes de instalar en el dispositivo.

## Dispositivo Xiaomi con HyperOS

1. En el telefono, abre Ajustes > Sobre el telefono y pulsa varias veces la version de HyperOS para activar las opciones de desarrollador.
2. Activa Depuracion USB y acepta la clave RSA al conectar el cable.
3. Si el dispositivo no aparece, habilita Depuracion USB (configuracion de seguridad) y selecciona Transferencia de archivos como modo USB.
4. Ejecuta `adb devices` y confirma que el estado sea `device`.
5. Instala el APK con `adb install -r app-debug.apk`.

HyperOS puede limitar procesos en segundo plano y autoinicio. Para pruebas de notificaciones o servicios, documenta la version de HyperOS, el modelo, el nivel de API y los permisos concedidos. No desactives optimizaciones del sistema sin registrarlo, porque cambia el resultado de la prueba.

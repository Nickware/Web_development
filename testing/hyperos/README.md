# Proyectos de prueba para HyperOS

Estos smoke tests sirven para comprobar que un proyecto nativo Android y uno Cordova pueden instalarse y ejecutarse en un telefono Xiaomi con HyperOS. No sustituyen pruebas de compatibilidad por modelo.

## Requisitos Linux

- Android Studio, Android SDK Platform-Tools y un JDK compatible.
- `adb` disponible en `PATH`.
- Depuracion USB autorizada en el telefono.
- Cable USB o una conexion ADB por red dentro de la misma LAN.

## Android nativo

```bash
cd android-smoke
gradle test
gradle assembleDebug
adb install -r app/build/outputs/apk/debug/app-debug.apk
adb shell am start -n com.example.hyperossmoke/.MainActivity
```

## Cordova

```bash
cd ../cordova-smoke
npm install
cordova platform add android
cordova requirements
cordova run android --device
```

## Checklist por dispositivo

Registra modelo, version de HyperOS, version de Android, nivel de API, resultado de instalacion, arranque, rotacion, modo oscuro, pausa/reanudacion, red y desinstalacion. Repite con ahorro de bateria activado si la aplicacion usa tareas en segundo plano.

Si `adb` no muestra el telefono, revisa [la guia de Android Studio](../../docs/frameworks/android-studio.md) y las reglas USB de [Linux](../../docs/frameworks/linux.md).

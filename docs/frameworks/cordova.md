# Apache Cordova en Linux

Cordova empaqueta HTML, CSS y JavaScript como una aplicacion Android mediante WebView. Necesita Node.js, Java, Android SDK y Gradle; prepara primero [Linux](linux.md).

## Instalacion

```bash
npm install --global cordova
cordova create ejemplo-cordova com.example.ejemplo Ejemplo
cd ejemplo-cordova
cordova platform add android
cordova requirements
cordova build android
```

Sirve la interfaz durante el desarrollo con el servidor web del proyecto o genera un APK debug. Usa plugins mantenidos y revisa sus permisos antes de añadirlos.

## Ejecucion en HyperOS

Conecta el Xiaomi con la depuracion USB autorizada y ejecuta:

```bash
adb devices
cordova run android --device
```

Para una prueba en la red local, no uses `localhost` en las llamadas HTTP de JavaScript: usa la IP LAN del equipo. En Android 9+ usa HTTPS en produccion; el trafico HTTP claro debe estar limitado al entorno de desarrollo y configurado explicitamente.

Valida rotacion, teclado, permisos, enlaces externos, reanudacion desde segundo plano y comportamiento sin red en el dispositivo real.

# Android smoke test

Proyecto Android minimo para comprobar compilacion, instalacion y arranque en HyperOS.

Abre esta carpeta en Android Studio y sincroniza Gradle. Si tienes Gradle instalado globalmente:

```bash
gradle test
gradle assembleDebug
adb install -r app/build/outputs/apk/debug/app-debug.apk
adb shell am start -n com.example.hyperossmoke/.MainActivity
```

La pantalla solo muestra un resultado visible de arranque; el objetivo es detectar problemas de SDK, firma, instalacion o lanzamiento antes de probar una aplicacion real.

# Cordova smoke test

Prueba minima de WebView, evento `deviceready` e interaccion en HyperOS.

```bash
npm install
npx cordova platform add android
npx cordova requirements
npm run build
npm run run:device
```

La aplicacion no solicita permisos especiales. Usa este proyecto para validar instalacion, primer arranque, rotacion, pausa/reanudacion y comportamiento basico de la WebView.

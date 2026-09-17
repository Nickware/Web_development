document.addEventListener('deviceready', function () {
  document.getElementById('status').textContent = 'Cordova lista en el dispositivo.';
});

document.getElementById('lifecycle').addEventListener('click', function () {
  document.getElementById('status').textContent = 'Interaccion WebView: OK';
});

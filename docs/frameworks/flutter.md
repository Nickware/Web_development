# Flutter

Flutter es un toolkit de Google para crear aplicaciones móviles, web y de escritorio desde una base de código Dart. Su modelo reactivo reconstruye la interfaz cuando cambia el estado, por lo que resulta útil para visualizar datos, simulaciones y resultados de modelos.

## Instalación y configuración en Linux

```bash
# Descargar Flutter desde https://docs.flutter.dev/get-started/install/linux
git clone https://github.com/flutter/flutter.git --branch stable $HOME/flutter
export PATH="$HOME/flutter/bin:$PATH"
flutter doctor
```

Instala también el SDK de Android si desarrollarás para Android. Para crear una aplicación:

```bash
flutter create explorador_datos
cd explorador_datos
flutter run
```

Para consumir una API HTTP añade el paquete oficial de la comunidad:

```bash
flutter pub add http
```

## Modelamiento

Las clases Dart pueden representar entidades recibidas desde una API. Este modelo mantiene separado el dato de la presentación:

```dart
class Muestra {
  const Muestra({required this.id, required this.valor});

  final int id;
  final double valor;

  factory Muestra.fromJson(Map<String, dynamic> json) {
    return Muestra(
      id: json['id'] as int,
      valor: (json['valor'] as num).toDouble(),
    );
  }
}
```

## Simulación reactiva

Un `StatefulWidget` puede actualizar una serie temporal sin bloquear la interfaz:

```dart
class SimulacionPage extends StatefulWidget {
  const SimulacionPage({super.key});

  @override
  State<SimulacionPage> createState() => _SimulacionPageState();
}

class _SimulacionPageState extends State<SimulacionPage> {
  double posicion = 0;

  void avanzar() {
    setState(() => posicion += 0.5);
  }

  @override
  Widget build(BuildContext context) {
    return Column(children: [
      Text('Posicion: $posicion'),
      ElevatedButton(onPressed: avanzar, child: const Text('Avanzar')),
    ]);
  }
}
```

## Minería de datos

Flutter debe visualizar resultados ya procesados. Por ejemplo, puede consultar frecuencias calculadas por Gin:

```dart
final response = await http.get(Uri.parse('https://api.example.com/frecuencias'));
if (response.statusCode != 200) {
  throw Exception('No se pudieron cargar las frecuencias');
}
final datos = jsonDecode(response.body) as List<dynamic>;
```

Para grandes volúmenes, pagina los resultados y usa un `ListView.builder`; no cargues todo el dataset en memoria del dispositivo.

## Programación AI

La aplicación puede enviar una pregunta a un endpoint de inferencia y mostrar la respuesta de forma incremental mediante streaming. No incrustes claves privadas de proveedores AI en la aplicación; usa el backend como proxy autenticado.

```dart
final response = await http.post(
  Uri.parse('https://api.example.com/ai/chat'),
  headers: {'Content-Type': 'application/json'},
  body: jsonEncode({'prompt': 'Resume esta muestra'}),
);
```

## Buenas prácticas

- Mantén los trabajos pesados en el backend o en isolates.
- Valida respuestas remotas antes de convertirlas a modelos Dart.
- Usa estado explícito para carga, éxito y error.
- Protege tokens, permisos y datos personales en el servidor.

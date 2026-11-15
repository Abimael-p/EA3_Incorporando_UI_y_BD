# EA3_Incorporando_UI_y_BD

## Descripción

Aplicación de escritorio desarrollada en Java utilizando Swing, como parte de la actividad evaluativa EA3.

La aplicación prueba una conexión JDBC con la URL, el usuario y la contraseña del formulario. Muestra el éxito en verde o el fallo en rojo con el detalle técnico.

## Tecnologías utilizadas

- Java (JDK 17 o superior).
- Java Swing.
- Java AWT.
- JDBC y el controlador del motor que se quiera probar.

## Estructura del proyecto

```text
EA3_Incorporando_UI_y_BD/
├── Principal.java
├── iu/
│   ├── ConexionTester.java
│   ├── VentanaPrincipal.java
│   └── componentes/
│       ├── BotonCircular.java
│       ├── PanelConexion.java
│       ├── PanelFormulario.java
│       └── PanelResultado.java
├── modelo/
│   ├── ConfiguracionBD.java
│   └── ResultadoConexion.java
├── servicio/
│   └── ServicioConexionBD.java
└── README.md
```

## Ejecutar el proyecto

Requiere un JDK 17 o superior.

Ejecuta los comandos desde la carpeta raíz del repositorio, donde está `Principal.java`.

### 1. Compilar

En Windows PowerShell:

```powershell
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse -Filter *.java).FullName
```

En macOS o Linux:

```bash
javac -encoding UTF-8 -d out Principal.java iu/*.java iu/componentes/*.java modelo/*.java servicio/*.java
```

Este comando compila todos los archivos `.java` del proyecto y guarda los archivos compilados en la carpeta `out`.

### 2. Ejecutar

Para probar con SQLite, guarda [el JAR de SQLite JDBC](https://github.com/xerial/sqlite-jdbc/releases/tag/3.54.1.0) en una carpeta `lib` dentro del repositorio. Para otro motor, coloca en `lib` su controlador JDBC y los JAR que requiera en tiempo de ejecución.

En Windows PowerShell:

```powershell
java -cp "out;lib/*" EA3_Incorporando_IU_y_BD.Principal
```

En macOS o Linux:

```bash
java -cp "out:lib/*" EA3_Incorporando_IU_y_BD.Principal
```

### 3. Probar con SQLite

Ingresa `jdbc:sqlite::memory:`, deja vacíos el usuario y la contraseña, y pulsa **Probar conexión**. El servicio cierra automáticamente la conexión al terminar la prueba. Si la prueba es exitosa, el botón **Desconectar** vuelve al formulario para iniciar otra prueba.

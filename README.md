# EA3_Incorporando_UI_y_BD

## Descripción

Aplicación de escritorio desarrollada en Java utilizando Swing, como parte de la actividad evaluativa EA3.

El proyecto consiste en desarrollar una interfaz gráfica para gestionar la conexión con una base de datos. La interfaz contempla campos para introducir la URL de conexión, el nombre de usuario y la contraseña, además de controles para probar y desconectar la conexión.

## Tecnologías utilizadas

- Java (JDK 17 o superior).
- Java Swing.
- Java AWT.

No utiliza frameworks ni dependencias externas.

## Estructura del proyecto

```text
EA3_Incorporando_UI_y_BD/
│   ├── Main.java
│   └── iu/
│       ├── JFrameMain.java
│       └── components/
│           ├── JPanelForm.java
│           └── JPanelConection.java
└── README.md
```

## Ejecutar el proyecto

Requiere un JDK 17 o superior.

Los siguientes comandos deben ejecutarse desde la carpeta raíz del proyecto, donde se encuentra la carpeta `EA3_Incorporando_UI_y_BD`.

### 1. Compilar

En Windows PowerShell:

```powershell
javac -d out (Get-ChildItem -Recurse -Filter *.java).FullName
```

Este comando compila todos los archivos `.java` del proyecto y guarda los archivos compilados en la carpeta `out`.

### 2. Ejecutar

```bash
java -cp out EA3_Incorporando_UI_y_BD/Main
```

## Interfaz gráfica

La aplicación utiliza Java Swing para construir su interfaz mediante componentes independientes:

- **Main:** punto de entrada de la aplicación.
- **JFrameMain:** ventana principal.
- **JPanelForm:** formulario para introducir los datos de conexión.
- **JPanelConection:** panel destinado a los controles de conexión y desconexión.

## Estado del proyecto

Proyecto en desarrollo. La interfaz gráfica se está construyendo por componentes, preparando la integración de la funcionalidad de conexión con la base de datos.
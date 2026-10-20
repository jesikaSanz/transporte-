# Actividad Sesión 3 — Empresa de transporte

Proyecto Java 21 + Spring Boot 3.5.5 que practica encapsulación, herencia, polimorfismo, `List`, `Map` y API REST.

## Requisitos
- JDK 21 instalado.
- Visual Studio Code con las extensiones **Extension Pack for Java** y **Spring Boot Extension Pack** (recomendadas).
- Maven Wrapper incluido (`mvnw` / `mvnw.cmd`). La primera ejecución necesita internet para descargar Maven/dependencias.

## Abrir y ejecutar en Visual Studio Code
1. Descomprime `transporte.zip`.
2. En VS Code selecciona **Archivo → Abrir carpeta** y elige la carpeta `transporte`.
3. Espera a que Java/Maven termine de importar el proyecto.
4. Para iniciar la API, abre `TransporteApplication.java` y pulsa **Run** sobre `main`; alternativamente, en terminal:
   - Windows: `mvnw.cmd spring-boot:run`
   - Linux/macOS: `./mvnw spring-boot:run`
5. Abre `http://localhost:8080/vehiculos` en el navegador.

> Si no tienes Java 21, instala JDK 21 y revisa que `java -version` muestre 21.

## Probar las etapas 1–3 sin servidor
Abre `Practica.java` y pulsa **Run** sobre `main`. También puedes ejecutar `com.ejemplo.transporte.Practica` desde el panel Java Projects.

## Endpoints GET
| Ruta | Resultado |
|---|---|
| `/vehiculos` | Flota completa en JSON |
| `/vehiculos/placa/bus101` | Descripción del vehículo; ignora mayúsculas/minúsculas |
| `/vehiculos/tarifa/10` | Descripción y tarifa de cada vehículo para 10 km |
| `/vehiculos/capacidad/10` | Vehículos con capacidad mayor o igual a 10 |
| `/conductor/bus101` | `El conductor de BUS101 es Carlos` |
| `/conductor/xyz999` | `Sin conductor asignado` |
| `/vehiculos/mayor-capacidad` | Vehículo con mayor capacidad (reto opcional) |
| `/vehiculos/total-capacidad` | `Capacidad total de la flota: 91 pasajeros` |

## Datos iniciales
- Bus `BUS101`, capacidad 40, ruta `Centro-Norte`.
- Bus `BUS102`, capacidad 35, ruta `Sur-Aeropuerto`.
- Taxi `TAX201`, capacidad 4, empresa `Taxis Bogotá`.
- Taxi `TAX202`, capacidad 4, empresa `Radio Taxi`.
- Vehículo `VEH301`, capacidad 8.
- Conductores: `BUS101 → Carlos`, `BUS102 → Ana`, `TAX201 → Luis`.

Los datos se mantienen en memoria y se reinician con la aplicación. No hay base de datos porque la guía no la solicita.

## Respuestas numéricas esperadas
- Tarifas a 10 km: vehículo base `$15000.0`, bus `$9000.0`, taxi `$19000.0`.
- Capacidad mayor que 10: 2 vehículos (los dos buses).
- Capacidad total: 91 pasajeros.

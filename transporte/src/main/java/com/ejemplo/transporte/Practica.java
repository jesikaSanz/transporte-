package com.ejemplo.transporte;

import java.util.List;
import java.util.Map;

public class Practica {
    // Ejecuta esta clase por separado para comprobar las etapas 1, 2 y 3 sin servidor.
    public static void main(String[] args) {
        Vehiculo vehiculo = new Vehiculo("VEH301", 8);
        System.out.println("Etapa 1: " + vehiculo.descripcion());
        vehiculo.setCapacidad(-5);
        System.out.println("Capacidad tras intentar asignar -5: " + vehiculo.getCapacidad());
        vehiculo.setCapacidad(10);
        System.out.println("Capacidad tras asignar 10: " + vehiculo.getCapacidad());

        Vehiculo bus = new Bus("BUS101", 40, "Centro-Norte");
        Vehiculo taxi = new Taxi("TAX201", 4, "Taxis Bogotá");
        System.out.println("\nEtapa 2 (10 km):");
        imprimir(bus, 10);
        imprimir(taxi, 10);
        imprimir(vehiculo, 10);

        List<Vehiculo> flota = Flota.crearVehiculos();
        System.out.println("\nEtapa 3: flota de " + flota.size() + " vehículos");
        int mayoresA10 = 0;
        for (Vehiculo actual : flota) {
            imprimir(actual, 10);
            if (actual.getCapacidad() > 10) {
                mayoresA10++;
            }
        }
        System.out.println("Vehículos con capacidad mayor a 10: " + mayoresA10);

        Map<String, String> conductores = Flota.crearConductores();
        System.out.println("Conductor BUS101: " + conductores.get("BUS101"));
        if (conductores.containsKey("XYZ999")) {
            System.out.println("Conductor XYZ999: " + conductores.get("XYZ999"));
        } else {
            System.out.println("No hay conductor asignado para XYZ999");
        }
    }

    private static void imprimir(Vehiculo vehiculo, double km) {
        System.out.println(vehiculo.descripcion() + " -> $" + vehiculo.calcularTarifa(km));
    }
}

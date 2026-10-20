package com.ejemplo.transporte;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Flota {
    private Flota() {}

    public static List<Vehiculo> crearVehiculos() {
        List<Vehiculo> flota = new ArrayList<>();
        flota.add(new Bus("BUS101", 40, "Centro-Norte"));
        flota.add(new Bus("BUS102", 35, "Sur-Aeropuerto"));
        flota.add(new Taxi("TAX201", 4, "Taxis Bogotá"));
        flota.add(new Taxi("TAX202", 4, "Radio Taxi"));
        flota.add(new Vehiculo("VEH301", 8));
        return flota;
    }

    public static Map<String, String> crearConductores() {
        Map<String, String> conductores = new HashMap<>();
        conductores.put("BUS101", "Carlos");
        conductores.put("BUS102", "Ana");
        conductores.put("TAX201", "Luis");
        return conductores;
    }
}

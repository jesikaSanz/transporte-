package com.ejemplo.transporte;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class TransporteController {
    private final List<Vehiculo> flota;
    private final Map<String, String> conductores;

    public TransporteController() {
        this.flota = Flota.crearVehiculos();
        this.conductores = Flota.crearConductores();
    }

    @GetMapping("/vehiculos")
    public List<Vehiculo> listarVehiculos() {
        return flota;
    }

    @GetMapping("/vehiculos/placa/{placa}")
    public String buscarPorPlaca(@PathVariable String placa) {
        for (Vehiculo vehiculo : flota) {
            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                return vehiculo.descripcion();
            }
        }
        return "No se encontró el vehículo " + placa;
    }

    @GetMapping("/vehiculos/tarifa/{km}")
    public List<String> tarifas(@PathVariable double km) {
        List<String> resultado = new ArrayList<>();
        for (Vehiculo vehiculo : flota) {
            resultado.add(vehiculo.descripcion() + " -> $" + vehiculo.calcularTarifa(km));
        }
        return resultado;
    }

    @GetMapping("/vehiculos/capacidad/{minima}")
    public List<Vehiculo> filtrarPorCapacidad(@PathVariable int minima) {
        List<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo vehiculo : flota) {
            if (vehiculo.getCapacidad() >= minima) {
                resultado.add(vehiculo);
            }
        }
        return resultado;
    }

    @GetMapping("/conductor/{placa}")
    public String consultarConductor(@PathVariable String placa) {
        String conductor = conductores.get(placa.toUpperCase());
        if (conductor == null) {
            return "Sin conductor asignado";
        }
        return "El conductor de " + placa.toUpperCase() + " es " + conductor;
    }

    @GetMapping("/vehiculos/mayor-capacidad")
    public Vehiculo mayorCapacidad() {
        Vehiculo mayor = flota.get(0);
        for (Vehiculo vehiculo : flota) {
            if (vehiculo.getCapacidad() > mayor.getCapacidad()) {
                mayor = vehiculo;
            }
        }
        return mayor;
    }

    @GetMapping("/vehiculos/total-capacidad")
    public String totalCapacidad() {
        int total = 0;
        for (Vehiculo vehiculo : flota) {
            total += vehiculo.getCapacidad();
        }
        return "Capacidad total de la flota: " + total + " pasajeros";
    }
}

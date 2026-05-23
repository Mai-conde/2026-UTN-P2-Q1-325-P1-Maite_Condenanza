/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transporteturistico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author maite
 */
public class GestorTurismo {
    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    public GestorTurismo() {
        this.vehiculos = vehiculos;
    }
    
    public void mostrarVehiculos() {
        if (vehiculos.isEmpty()) {
            System.out.println("no hay vehiculos registrados.");
            return; 
        }

        for (Vehiculo v : vehiculos) {
            System.out.println(v);
        }
    }
    
    public void agregarVehiculos(Vehiculo vehiculo1) throws VehiculoDuplicadoException {
        for (Vehiculo v: vehiculos) {
            if (v.getPatente().equalsIgnoreCase(vehiculo1.getPatente())) {
                throw new VehiculoDuplicadoException("Ya existe un vehiculo con esas caracteristicas");
            }
        
        } 
        vehiculos.add(vehiculo1);
        System.out.println("Vehiculo agregado correctamente");
    }
    
    public void realizarServiciosTuristicos() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehiculos para relizar servicios");
            return;
        }
        for (Vehiculo v : vehiculos) {
            v.realizarServicioTuristico();
        }
    }
    
    public void buscarPorPatente(String patenteBuscar) {
        boolean existe = false;
        for (Vehiculo v : vehiculos) {
            if (v.getPatente().equalsIgnoreCase(patenteBuscar)) {
                System.out.println("El vehiculo " + v + " tiene la patente " + v.getPatente());
                existe = true;
                break;
            }
        }
        if (!existe) {
            System.out.println("No se encontro ningun vehiculo con la patente " + patenteBuscar);
        }
    }
    
    public void mostrarPorCapacidadMayor(int capacidadASuperar) {
        boolean vehiculosSuperan = false;
        for (Vehiculo v : vehiculos) {
            if (v.getCapacidadPasajeros() > capacidadASuperar) {
                System.out.println("El vehiculo " + v + "tiene mayor capacidad a " + capacidadASuperar + "pasajeros");
                vehiculosSuperan = true;
            }
        }
        if (!vehiculosSuperan) {
            System.out.println("No hay vehiculos con capacidad mayor a " + capacidadASuperar);
        }
   
    }
    
    public void ordenarVehiculosPorAnioDescendente(ArrayList<Vehiculo> vehiculosOriginal) {
        if (vehiculosOriginal == null || vehiculosOriginal.isEmpty()) {
            System.out.println("No hay vehiculos registradas para ordenar.");
            return;
        }
        ArrayList<Vehiculo> copiaVehiculos = new ArrayList<>(vehiculosOriginal);
        Collections.sort(copiaVehiculos);
        
        for (Vehiculo v : copiaVehiculos) {
            System.out.println(v);
        }
    }
    
    public void ordenarNavesPorCapacidadPasajerosDescendente(ArrayList<Vehiculo> VehiculosOriginal) {
        if (VehiculosOriginal == null || VehiculosOriginal.isEmpty()) {
            System.out.println("No hay vehiculos registrados para ordenar.");
            return;
        }
        ArrayList<Vehiculo> copiaV = new ArrayList<>(VehiculosOriginal);
        copiaV.sort(Comparator.comparingInt(Vehiculo::getCapacidadPasajeros).reversed());
        
        for (Vehiculo v : copiaV) {
            System.out.println(v);
        }
    }
    


    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    
    
    
    
    
    
    
    
}

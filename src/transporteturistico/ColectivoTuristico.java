/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transporteturistico;

/**
 *
 * @author maite
 */
public class ColectivoTuristico extends Vehiculo {
    private int cantidadPisos;

    public ColectivoTuristico(int cantidadPisos, String patente, String marca, int capacidadPasajeros, int anioFabricacion) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        this.cantidadPisos = cantidadPisos;
    }

    @Override
    public String toString() {
        return "Vehiculo --> ColectivoTuristico = " + super.toString() + " ,cantidadPisos: " + cantidadPisos;
    }

    @Override
    public void realizarServicioTuristico() {
        System.out.println("El Colectivo Turistico ha comenzado a realizar servicios turisticos");
    }
    
    
}

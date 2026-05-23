/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transporteturistico;

/**
 *
 * @author maite
 */
public class VanEjecutiva extends Vehiculo {
    private boolean aireAcondicionado;

    public VanEjecutiva(boolean aireAcondicionado, String patente, String marca, int capacidadPasajeros, int anioFabricacion) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        this.aireAcondicionado = aireAcondicionado;
    }

    @Override
    public String toString() {
        return "Vehiculo --> VanEjecutiva" + super.toString() + " ,aireAcondicionado: " + aireAcondicionado;
    }
    
    @Override
    public void realizarServicioTuristico() {
        System.out.println("La Van Ejecutiva ha comenzado a realizar servicios turisticos");
    }
    
    
}

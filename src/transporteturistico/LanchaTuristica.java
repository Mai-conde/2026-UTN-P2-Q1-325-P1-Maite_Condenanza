/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transporteturistico;
import transporteturistico.TransporteTuristico.tipoMotor;
/**
 *
 * @author maite
 */
public class LanchaTuristica extends Vehiculo {
    private tipoMotor motor;

    public LanchaTuristica(tipoMotor motor, String patente, String marca, int capacidadPasajeros, int anioFabricacion) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        this.motor = motor;
    }

    @Override
    public String toString() {
        return "Vehiculo --> LanchaTuristica{" + super.toString() + " ,motor: " + motor;
    }
    
    @Override
    public void realizarServicioTuristico() {
        System.out.println("La Lancha Turistica ha comenzado a realizar servicios turisticos");
    }

    
    
    
    
}

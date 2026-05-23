/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transporteturistico;

/**
 *
 * @author maite
 */
public abstract class Vehiculo implements Comparable<Vehiculo>  {
    protected String patente;
    protected String marca;
    protected int capacidadPasajeros;
    protected int anioFabricacion;

    public Vehiculo(String patente, String marca, int capacidadPasajeros, int anioFabricacion) {
        this.patente = patente;
        this.marca = marca;
        this.capacidadPasajeros = capacidadPasajeros;
        this.anioFabricacion = anioFabricacion;
    }
    
    public abstract void realizarServicioTuristico();

    @Override
    public String toString() {
        return " patente: " + patente + " ,marca: " + marca + " ,capacidadPasajeros: " + capacidadPasajeros + " ,anioFabricacion: " + anioFabricacion;
    }
    
    @Override
    public int compareTo(Vehiculo v) {
        int resultadoAnio = Integer.compare(v.anioFabricacion, this.anioFabricacion);

        if (resultadoAnio != 0) {
            return resultadoAnio;
        }

        // 2. Si los años empatan (resultadoAño == 0), desempatamos por Tripulación (Mayor a menor)
        return Integer.compare(v.capacidadPasajeros, this.capacidadPasajeros);
    }
    

    public String getPatente() {
        return patente;
    }

    public String getMarca() {
        return marca;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }
    
    
    
    
}

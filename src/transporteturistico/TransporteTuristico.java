/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package transporteturistico;

import java.util.Scanner;

/**
 *
 * @author maite
 */
public class TransporteTuristico {

    public enum tipoMotor {NAFTA, DIESEL, ELECTRICO}
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorTurismo sistema = new GestorTurismo();
        
        
        int opcion = 0;

        //Bucle principal del programa
        do {
            System.out.println("\n=========== MENÚ PRINCIPAL ===========");
            System.out.println("1. Agregar vehiculo");
            System.out.println("2. Mostrar todas los vehiculos");
            System.out.println("3. Realizar servicios turisticos");
            System.out.println("4. Buscar vehiculo por patente");
            System.out.println("5. Mostrar vehiculos con capacidad mayor a un valor ingresado");
            System.out.println("6. Mostrar vehiculos ordenados por anio de fabricacion descendente");
            System.out.println("7. Mostrar vehiculos ordenados por capacidad de pasajeros descendente");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opcion (1-8): ");

            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());

                switch (opcion) {
                    case 1:
                        menuAgregarVehiculo(sistema, scanner); 
                        break;
                        
                    case 2:
                        System.out.println("\n---------- VEHICULOS REGISTRADOS -----------");
                        sistema.mostrarVehiculos();
                        break;
                        
                    case 3:
                        System.out.println("\n--------- REALIZANDO SERVICIOS TURISTICOS ----------");
                            sistema.realizarServiciosTuristicos();
                            break;
                        
                    case 4:
                        String patente = ValidarString("Ingrese la patente que desea buscar: ", scanner);
                        System.out.println("\n------------ BUSCANDO VEHICULO CON ESA PATENTE ------------");
                        sistema.buscarPorPatente(patente);
                        break;
                        
                    case 5:
                        int capacidadP = ValidarEntero("Ingrese la capacidad de pasajeros: ", scanner);
                        System.out.println("\n------------ BUSCANDO VEHICULOS CON CAPACIDAD MAYOR A LA SOLICITADA -------------");
                        sistema.mostrarPorCapacidadMayor(capacidadP);
                        break;
                        
                    case 6:
                        System.out.println("\n----------- VEHICULOS ORDENADOS POR ANIO DE FABRICACION DESCENDENTE -------------");
                        sistema.ordenarVehiculosPorAnioDescendente(sistema.getVehiculos());
                        break;
                        
                    case 7:
                        System.out.println("\n----------- VEHICULOS ORDENADOS POR CAPACIDAD DE PASAJEROS DESCENDENTE -------------");
                        sistema.ordenarNavesPorCapacidadPasajerosDescendente(sistema.getVehiculos());
                        break;
                        
                    case 8:
                        System.out.println("Cerrando el sistema...");
                        
                    default:
                        System.out.println("Error: Opcion invalida. Por favor, seleccione un numero del 1 al 7.");
                }

            } catch (NumberFormatException e) {
                // Si el usuario ingresa letras, símbolos o deja vacío
                System.out.println("Error: Debe ingresar un numero entero valido.");
            }

        } while (opcion != 8);
        
        scanner.close(); 
    }
    
    
    
    
   private static void menuAgregarVehiculo(GestorTurismo gestor, Scanner scanner) {
        boolean VehiculoAgregar = false;

        // Bucle para pedir datos hasta que sean correctos
        while (!VehiculoAgregar) {
            System.out.println("\n--- REGISTRAR NUEVO VEHICULO ---");
            
            int tipo = ValidarEnteroRango("Seleccione tipo (1. Colectivo Turistico, 2. Van Ejecutiva, 3. Lancha Turistica): ", 1, 3, scanner);
            String patente = ValidarString("patente del vehiculo: ", scanner);
            String marca = ValidarString("marca del vehiculo: ", scanner);
            int pasajeros = ValidarEntero("Capacidad de pasajeros: ", scanner);
            int anio = ValidarEnteroRango("Anio de fabricacion: ", 1990, 2026, scanner);
            
            Vehiculo nuevoVehiculo = null; 

            // Instanciamos según el tipo de vehiculo
            if (tipo == 1) {
                int cantidadPisos = ValidarEnteroRango("Cantidad de pisos: ", 1, 2, scanner);
                nuevoVehiculo = new ColectivoTuristico(cantidadPisos, patente, marca, pasajeros, anio);
                
            } else if (tipo == 2) {
                boolean aire = validarBoolean("Tiene aire acondicionado? (S/N)", scanner);
                nuevoVehiculo = new VanEjecutiva(aire, patente, marca, pasajeros, anio);
                
            } else if (tipo == 3) {
                tipoMotor motor = validarMotor(scanner);
                nuevoVehiculo = new LanchaTuristica(motor, patente, marca, pasajeros, anio);
            
            }
            
            try {
                gestor.agregarVehiculos(nuevoVehiculo);
                VehiculoAgregar = true;

            } catch (VehiculoDuplicadoException e) {
                System.out.println("Ya existe un vehiculo con esas caracteristicas.");
            }
        
        }
    }
    
    
     // ----------------------------- MÉTODOS DE VALIDACIÓN ------------------------------
    
   
    public static String ValidarString(String mensaje, Scanner scanner) {
        String entrada = "";
        boolean esValido = false;

        while (!esValido) {
            System.out.print(mensaje);
            entrada = scanner.nextLine().trim();

            if (entrada.isEmpty()) {
                System.out.println("El campo no puede estar vacio. Por favor, escriba un texto valido.");
            } else {
                esValido = true; 
            }
        }
        return entrada; 
    }

    
    public static int ValidarEntero(String mensaje, Scanner scanner) {
        int numero = 0;
        boolean esValido = false;

        while (!esValido) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim(); 

            if (entrada.isEmpty()) {
                System.out.println("El campo no puede estar vacio. Ingrese un numero.");
                continue; 
            }

            try {
                numero = Integer.parseInt(entrada);
                if (numero <= 0) {
                    System.out.println("La cantidad de pasajeros debe ser positiva");
                }
                esValido = true; 

            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un numero valido (sin letras).");
            }
        }
        return numero; 
    
    }
    
    public static int ValidarEnteroRango(String mensaje, int min, int max, Scanner scanner) {
        int numero = 0;
        boolean esValido = false;

        while (!esValido) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim(); 

            if (entrada.isEmpty()) {
                System.out.println("El campo no puede estar vacio. Ingrese un numero.");
                continue; 
            }

            try {
                numero = Integer.parseInt(entrada);

                if (numero < min || numero > max) {
                    System.out.println("Valor fuera de rango. Debe estar entre " + min + " y " + max);
                } else {
                    esValido = true; 
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido (no se permiten letras ni caracteres).");
            }
        }
        return numero; 
    }
    
    public static boolean validarBoolean(String mensaje, Scanner scanner) {
        while(true) {
            String entrada = ValidarString(mensaje, scanner).toUpperCase();
            if (entrada.equals("S")) {
                return true;
            } else if (entrada.equals("N")){
                return false;
            } else {
                System.out.println("Ingrese un solo -S- (si) o -N- (no)");
            }
                    
        }
    }
    
    public static tipoMotor validarMotor(Scanner scanner) {
        while(true) {
            System.out.println("Tipos de motor: 1. NAFTA, 2. DIESEL, 3.ELECTRICO");
            int opcion = ValidarEnteroRango("Seleccione un tipo de motor (1-3)", 1, 3, scanner);
            switch (opcion) {
                case 1: return tipoMotor.NAFTA;
                case 2: return tipoMotor.DIESEL;
                case 3: return tipoMotor.ELECTRICO;
            }
        }
    }
    
    
    
}

package Eventos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Seccion {
    private Map<Character, List<Integer>> asientosPorFila;
    private String nombre;
    private int capacidad;
    private double precio;

    public Seccion(String nombre, int capacidad, double precio) {
        this.asientosPorFila = new HashMap<>();
        this.capacidad = capacidad;
        this.nombre = nombre;
        this.precio = precio;

        char fila = 'A';
        int numeroAsiento = 1;

        for (int i = 1; i <= capacidad; i++) {
            asientosPorFila.putIfAbsent(fila, new ArrayList<>());
            asientosPorFila.get(fila).add(numeroAsiento);

            numeroAsiento++;
            if (numeroAsiento > 20) { // Avanzar a la siguiente fila después de 20 asientos
                fila++;
                numeroAsiento = 1;
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public double getPrecio() {
        return precio;
    }

    public String asientosDisponibles() {
        StringBuilder resultado = new StringBuilder();

        for (Map.Entry<Character, List<Integer>> entry : asientosPorFila.entrySet()) {
            char fila = entry.getKey();
            List<Integer> disponibles = entry.getValue();

            // Generar rangos para los asientos disponibles de la fila actual
            if (!disponibles.isEmpty()) {
                resultado.append(fila).append(formatearRangos(disponibles)).append(", ");
            }
        }

        // Eliminar la última coma y espacio
        if (resultado.length() > 0) {
            resultado.setLength(resultado.length() - 2);
        }

        return resultado.toString();
    }

    private String formatearRangos(List<Integer> disponibles) {
        StringBuilder sb = new StringBuilder();
        int inicio = -1, previo = -1;
    
        for (int asiento : disponibles) {
            if (inicio == -1) {
                // Iniciar un nuevo rango
                inicio = asiento;
            } else if (asiento != previo + 1) {
                // Detectar un salto y cerrar el rango actual
                if (inicio == previo) {
                    sb.append(inicio).append(",");
                } else {
                    sb.append(inicio).append("-").append(previo).append(",");
                }
                inicio = asiento; // Iniciar un nuevo rango
            }
            previo = asiento; // Actualizar el último asiento procesado
        }
    
        // Procesar el último rango
        if (inicio != -1) {
            if (inicio == previo) {
                sb.append(inicio).append(",");
            } else {
                sb.append(inicio).append("-").append(previo).append(",");
            }
        }
    
        // Eliminar la última coma
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
    
        return sb.toString();
    }
    

    public boolean reservarAsiento(String asiento) {
        char fila = asiento.charAt(0);
        int numero;

        try {
            numero = Integer.parseInt(asiento.substring(1));
        } catch (NumberFormatException e) {
            System.out.println("El asiento " + asiento + " no es válido.");
            return false;
        }

        if (!asientosPorFila.containsKey(fila) || !asientosPorFila.get(fila).contains(numero)) {
            System.out.println("El asiento " + asiento + " no existe o ya está reservado.");
            return false;
        }

        asientosPorFila.get(fila).remove((Integer) numero);
        System.out.println("¡El asiento " + asiento + " ha sido reservado exitosamente!");
        return true;
    }

    public boolean eliminarReservacion(String asiento) {
        char fila = asiento.charAt(0);
        int numero;

        try {
            numero = Integer.parseInt(asiento.substring(1));
        } catch (NumberFormatException e) {
            System.out.println("El asiento " + asiento + " no es válido.");
            return false;
        }

        if (!asientosPorFila.containsKey(fila)) {
            System.out.println("El asiento " + asiento + " no existe.");
            return false;
        }

        if (asientosPorFila.get(fila).contains(numero)) {
            System.out.println("El asiento " + asiento + " no está reservado.");
            return false;
        }

        asientosPorFila.get(fila).add(numero);
        asientosPorFila.get(fila).sort(Integer::compareTo); // Mantener el orden
        System.out.println("La reservación del asiento " + asiento + " se ha cancelado exitosamente.");
        return true;
    }

    @Override
    public String toString() {
        return "Sección{Nombre: " + nombre + ", Precio: " + precio + ", Asientos Disponibles: " + asientosDisponibles() + "}";
    }
}

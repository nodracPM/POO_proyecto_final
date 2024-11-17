package Eventos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Seccion {
    private Map<String, Boolean> asientos;
    private String nombre;
    private int capacidad;
    private double precio;

    public Seccion(String nombre, int capacidad, double precio) {
    this.asientos = new HashMap<>();
    this.capacidad = capacidad;
    this.nombre = nombre;
    this.precio = precio;

    char fila = 'A';
    int numeroAsiento = 1;

    for (int i = 1; i <= capacidad; i++) {
        String asiento = fila + String.valueOf(numeroAsiento);
        asientos.put(asiento, true);

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
    // Crear un mapa para agrupar los asientos por fila
    Map<Character, StringBuilder> filas = new HashMap<>();
    
    // Obtener una lista de los asientos ordenada
    List<String> asientosOrdenados = new ArrayList<>(asientos.keySet());
    asientosOrdenados.sort((a, b) -> {
        char filaA = a.charAt(0);
        char filaB = b.charAt(0);
        int numA = Integer.parseInt(a.substring(1));
        int numB = Integer.parseInt(b.substring(1));
        
        // Comparar primero por fila y luego por número
        if (filaA == filaB) {
            return Integer.compare(numA, numB);
        } else {
            return Character.compare(filaA, filaB);
        }
    });

    // Recorrer los asientos y agruparlos por fila
    for (String asiento : asientosOrdenados) {
        char fila = asiento.charAt(0);
    
        // Inicializar el acumulador de la fila si no existe
        filas.putIfAbsent(fila, new StringBuilder());
    
        // Si el asiento está disponible, añadirlo al acumulador de la fila
        if (asientos.get(asiento)) {
            filas.get(fila).append(asiento).append(",");
        }
    }
    
    // Procesar cada fila para formatear los rangos
    StringBuilder resultado = new StringBuilder();
    for (Map.Entry<Character, StringBuilder> entry : filas.entrySet()) {
        String[] disponibles = entry.getValue().toString().split(",");
        resultado.append(formatearRangos(disponibles)).append(", ");
    }
    
    // Eliminar la última coma y espacio
    if (resultado.length() > 0) {
        resultado.setLength(resultado.length() - 2);
    }
    
    return resultado.toString();
}

    
    private String formatearRangos(String[] disponibles) {
        StringBuilder sb = new StringBuilder();
        String inicioRango = null;
    
        for (int i = 0; i < disponibles.length; i++) {
            if (inicioRango == null) {
                inicioRango = disponibles[i];
            }
    
            // Si es el último asiento o el próximo no es consecutivo, cerrar el rango
            if (i == disponibles.length - 1 || !sonConsecutivos(disponibles[i], disponibles[i + 1])) {
                if (inicioRango.equals(disponibles[i])) {
                    sb.append(inicioRango).append(", ");
                } else {
                    sb.append(inicioRango).append("-").append(disponibles[i]).append(", ");
                }
                inicioRango = null; // Reiniciar el rango
            }
        }
    
        // Eliminar la última coma y espacio
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2);
        }
    
        return sb.toString();
    }
    
    private boolean sonConsecutivos(String actual, String siguiente) {
        char filaActual = actual.charAt(0);
        char filaSiguiente = siguiente.charAt(0);
        int numeroActual = Integer.parseInt(actual.substring(1));
        int numeroSiguiente = Integer.parseInt(siguiente.substring(1));
    
        return filaActual == filaSiguiente && numeroSiguiente == numeroActual + 1;
    }
    
    public boolean reservarAsiento(String asiento)
    {
        if(!asientos.containsKey(asiento))
        {
            System.out.println("El asiento " + asiento +" no existe.");
            return false;
        }

        if(!asientos.get(asiento))
        {
            System.out.println("El asiento " + asiento + " se encuentra reservado.");
            return false;
        }

        asientos.put(asiento, false);
        System.out.println("¡El asiento "+ asiento +" ha sido reservado exitosamente!");
        return true;
    }

    public boolean eliminarReservacion(String asiento)
    {
        if(!asientos.containsKey(asiento))
        {
            System.out.println("El asiento " + asiento +" no existe.");
            return false;
        }

        if(asientos.get(asiento))
        {
            System.out.println("El asiento " + asiento + " se encuentra reservado.");
            return false;
        }

        asientos.put(asiento, true);
        System.out.println("La reservacion del asiento "+asiento+" se ha cancelado exitosamente.");
        return true;
    }

    @Override

    public String toString()
    {
        return "Seccion{Nombre:" +
        nombre+", Precio: "+precio+", Asientos Disponibles: " + asientosDisponibles();
    }
}

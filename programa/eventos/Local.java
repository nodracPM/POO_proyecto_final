package Eventos;

import java.util.ArrayList;

public class Local {
    protected ArrayList<Seccion> secciones;
    private String nombre;
    private String direccion;

    public Local(String nombre, String direccion)
    {
        this.direccion = direccion;
        this.nombre = nombre;
        this.secciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarSeccion(Seccion seccion)
    {
        secciones.add(seccion);
    }

    public void eliminarSeccion(Seccion seccion)
    {
        secciones.remove(seccion);
    }

    private Seccion buscarSeccion(String nombreSeccion) {
        for (Seccion seccion : secciones) {
            if (seccion.getNombre().equalsIgnoreCase(nombreSeccion)) {
                return seccion;
            }
        }
        return null; // Retornar null si no se encuentra la sección
    }

    public int getCapacidadTotal()
    {
        int capacidad = 0;
        for(Seccion seccion : secciones)
        {
            capacidad += seccion.getCapacidad();
        }
        return capacidad;
    }

    public String resumenDisponibilidad()
    {
        StringBuilder sb = new StringBuilder("Disponibilidad por seccion: \n");
        for(Seccion seccion : secciones)
        {
            sb.append("Seccion ").append(seccion.getNombre()).append(" : ").append(seccion.asientosDisponibles()).
            append("\n");
        }
        return sb.toString();
    }

    public boolean reservarAsiento(String nombreSeccion, String asiento)
    {
        Seccion seccion = buscarSeccion(nombreSeccion);
        if(seccion != null)
        {
            return seccion.reservarAsiento(asiento);
        }
        System.out.println("El asiento "+asiento+" no existe.");
        return false;
    }

    public boolean eliminarReservacion(String nombreSeccion, String asiento)
    {
        Seccion seccion = buscarSeccion(nombreSeccion);
        if(seccion != null)
        {
            return seccion.eliminarReservacion(asiento);
        }
        System.out.println("El asiento "+asiento+" no existe.");
        return false;
    }

    public int ingresoPotencial()
    {
        int ganancia = 0;
        for(Seccion seccion : secciones)
        {
            ganancia += seccion.getPrecio();
        }
        return ganancia;
    }

    @Override
    public String toString() {
            return "Local: " + nombre +
            "\nDirección:"+direccion+
           "\nCapacidad Total: " + getCapacidadTotal() +
           "\nIngreso Potencial: $" + ingresoPotencial();
    }
}

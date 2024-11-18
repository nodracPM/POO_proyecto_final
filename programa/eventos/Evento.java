package programa.eventos;

import java.util.ArrayList;
import java.util.Date;

public class Evento
{
    private int id;
    private int asientos;
    private ArrayList<Double> precios;
    private Date fecha;
    private String hora;
    private Local local;
    private double ganancias;

    public Evento(int id, Date fecha, String hora, Local local)
    {
        this.id= id;
        this.fecha = fecha;
        this.hora = hora;
        this.local = local;
    }


    public double calcular_Ganancias()
    {
        double ganancias = 0.0;

        for(Seccion seccion: local.secciones)
        {
            int asientosReservados = seccion.getCapacidad() - seccion.conteoAsientosDisponibles();
            ganancias += asientosReservados*seccion.getPrecio();
        }
        return Math.round(ganancias*100.0)/100.0;
    }

    public int getAsientos() {
        return asientos;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getGanancias() {
        return ganancias;
    }

    public String getHora() {
        return hora;
    }

    public int getId() {
        return id;
    }

    public Local getLocal() {
        return local;
    }

    public ArrayList<Double> getPrecios() {
        return precios;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setGanancias(double ganancias) {
        this.ganancias = ganancias;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public void setPrecios(ArrayList<Double> precios) {
        this.precios = precios;
    }

    // Reservar un asiento
    public boolean reservarAsiento(String nombreSeccion, String asiento) {
        return local.reservarAsiento(nombreSeccion, asiento);
    }

    // Cancelar una reservación
    public boolean eliminarReservacion(String nombreSeccion, String asiento) {
        return local.eliminarReservacion(nombreSeccion, asiento);
    }

    // Resumen de asientos disponibles por sección
    public String resumenDisponibilidad() {
        return local.resumenDisponibilidad();
    }

    // Detalles completos del evento
    @Override
    public String toString() {
        return "Evento ID: " + id +
               "\nFecha: " + fecha +
               "\nHora: " + hora +
               "\nLocal: " + local.getNombre() +
               "\nDirección: " + local.getDireccion() +
               "\nCapacidad Total: " + local.getCapacidadTotal() +
               "\nGanancias Estimadas: $" + String.format("%.2f", calcular_Ganancias()) +
               "\nResumen de Disponibilidad:\n" + resumenDisponibilidad();
    }
}

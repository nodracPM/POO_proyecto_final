package Eventos;

import java.util.ArrayList;

public class Evento
{
    private int id;
    private int asientos;
    private ArrayList<Double> precios;
    private String fecha;
    private String hora;
    private Local local;
    private double ganancias;

    public Evento(int id, String fecha, String hora, Local local)
    {
        this.id= id;
        this.fecha = fecha;
        this.hora = hora;
        this.local = local;
    }


    public double calcular_Ganancias()
    {
        return ganancias;    
    }

    public int getAsientos() {
        return asientos;
    }

    public String getFecha() {
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

    public void setFecha(String fecha) {
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

}
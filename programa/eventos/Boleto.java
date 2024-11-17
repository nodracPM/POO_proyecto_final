package programa.eventos;

public class Boleto {
    private double precio;
    private Seccion seccion;
    private String asiento;
    private String fecha;
    private String hora;
    private String local;

    public Boleto(double precio, Seccion seccion, String asiento, String fecha, String hora, String local) {
        this.precio = precio;
        this.seccion = seccion;
        this.asiento = asiento;
        this.fecha = fecha;
        this.hora = hora;
        this.local = local;
    }

    public double getPrecio() {
        return precio;
    }   

    public Seccion getSeccion() {
        return seccion;
    }

    public String getAsiento() {
        return asiento;
    }   

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getLocal() {
        return local;
    }
}

import java.io.*;

public class Ticket implements Serializable{
    private String Asientos;
    private String Propietario;
    private String FechaCompra;
    //private Evento evento;

    public Ticket (String Asientos,String Propietario,String FechaCompra/* ,Evento evento*/){
        this.Asientos=Asientos;
        this.Propietario=Propietario;
        this.FechaCompra=FechaCompra;
        //this.evento = evento;
    }

    @Override
    public String toString() {
        System.out.println("Asientos: " +this.Asientos);
        System.out.println("Propietario: " +this.Propietario);
        System.out.println("Fecha de compra: " +this.FechaCompra);
        return "Gracias por su reservación";
    }
}

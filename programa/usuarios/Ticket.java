//package programa.usuarios;

import java.io.*;
import java.util.Date;

public class Ticket implements Serializable,Cloneable{
    private int Asientos;
    private String Propietario;
    private Date FechaCompra;
    private Date FechaEvento;
    private String hora;
    private String local;

    public Ticket (int Asientos,String Propietario,Date FechaCompra,Date FechaEvento,String hora,String local){
        this.Asientos=Asientos;
        this.Propietario=Propietario;
        this.FechaCompra=FechaCompra;
        this.FechaEvento=FechaEvento;
        this.hora=hora;
        this.local=local;
    }

    @Override
    public String toString() {
        System.out.println("Asientos: " +this.Asientos);
        System.out.println("Propietario: " +this.Propietario);
        System.out.println("Fecha de compra: " +this.FechaCompra);
        System.out.println("Fecha de evento: "+this.FechaEvento);
        System.out.println("Hora del evento: "+this.hora);
        System.out.println("Lugar del evento: "+this.local);
        return "Gracias por su reservación";
    }

    @Override
    public Ticket clone(){
        return new Ticket(this.Asientos, this.Propietario, this.FechaCompra,this.FechaEvento,this.hora,this.local);
    }
}

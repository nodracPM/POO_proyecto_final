//package programa.usuarios;

import java.io.*;
import java.util.Date;

public class Ticket implements Serializable,Cloneable{
    private int Asientos;
    private String Propietario;
    private Date FechaCompra;
    private Date FechaEvento;

    public Ticket (int Asientos,String Propietario,Date FechaCompra,Date FechaEvento){
        this.Asientos=Asientos;
        this.Propietario=Propietario;
        this.FechaCompra=FechaCompra;
        this.FechaEvento=FechaEvento; 
    }

    @Override
    public String toString() {
        System.out.println("Asientos: " +this.Asientos);
        System.out.println("Propietario: " +this.Propietario);
        System.out.println("Fecha de compra: " +this.FechaCompra);
        System.out.println("Fecha de evento: "+this.FechaEvento);
        return "Gracias por su reservación";
    }

    @Override
    public Ticket clone(){
        return new Ticket(this.Asientos, this.Propietario, this.FechaCompra,this.FechaEvento);
    }
}

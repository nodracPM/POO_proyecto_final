import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TicketUtilery {
    public static void saveTickets(ArrayList<Ticket> Tickets){
        Scanner stdIn = new Scanner(System.in);
        ObjectOutputStream fileOut;
        String filename;
        System.out.print("Introduzca el nombre del archivo: ");
        filename = stdIn.nextLine();
        try {
            fileOut = new ObjectOutputStream(new FileOutputStream(filename));
            for (Ticket a:Tickets){
                fileOut.writeObject(a);
            }
            fileOut.close();
        } 
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static ArrayList<Ticket> loadTickets(){
        ArrayList<Ticket> Tickets = new ArrayList<Ticket>();
        Scanner stdIn = new Scanner(System.in);
        try {
            int n = 0;
            ObjectInputStream fileIn;
            System.out.print("Introduzca el nombre del archivo: ");
            fileIn = new ObjectInputStream(new FileInputStream(stdIn.nextLine()));
            do{
                Tickets.add((Ticket) fileIn.readObject());
            }while(n!=1);
            fileIn.close();
        } catch (EOFException e) {
            System.out.println("Archivo cargado con éxito");
        }catch (IOException e){
            System.out.println("IO Error: " + e.getMessage());
        }
        catch (ClassNotFoundException e) {
            System.out.println("ClassNotFound " + e.getMessage());
        }
        return Tickets;
    }
}

package programa.usuarios;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import programa.eventos.*;;

public class AccUtilery {
    public static void saveAdmins(ArrayList<Admin> Admins){
        Scanner stdIn = new Scanner(System.in);
        ObjectOutputStream fileOut;
        String filename;
        System.out.print("Introduzca el nombre del archivo: ");
        filename = stdIn.nextLine();
        try {
            fileOut = new ObjectOutputStream(new FileOutputStream(filename));
            for (Admin a:Admins){
                fileOut.writeObject(a);
            }
            fileOut.close();
        } 
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static ArrayList<Admin> loadAdmins(){
        ArrayList<Admin> admins = new ArrayList<Admin>();
        Scanner stdIn = new Scanner(System.in);
        try {
            int n = 0;
            ObjectInputStream fileIn;
            System.out.print("Introduzca el nombre del archivo: ");
            fileIn = new ObjectInputStream(new FileInputStream(stdIn.nextLine()));
            do{
                admins.add((Admin) fileIn.readObject());
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
        return admins;
    }

    public static void saveClients(ArrayList<Cliente> Clientes){
        Scanner stdIn = new Scanner(System.in);
        ObjectOutputStream fileOut;
        String filename;
        System.out.print("Introduzca el nombre del archivo: ");
        filename = stdIn.nextLine();
        try {
            fileOut = new ObjectOutputStream(new FileOutputStream(filename));
            for (Cliente c:Clientes){
                fileOut.writeObject(c);
            }
            fileOut.close();
        } 
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static ArrayList<Cliente> loadClientes(){
        ArrayList<Cliente> Clients = new ArrayList<Cliente>();
        Scanner stdIn = new Scanner(System.in);
        try {
            int n = 0;
            ObjectInputStream fileIn;
            System.out.print("Introduzca el nombre del archivo: ");
            fileIn = new ObjectInputStream(new FileInputStream(stdIn.nextLine()));
            do{
                Clients.add((Cliente) fileIn.readObject());
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
        return Clients;
    }

    public static void saveLocales(ArrayList<Local> locales) {
        Scanner stdIn = new Scanner(System.in);
        ObjectOutputStream fileOut;
        String filename;
        System.out.print("Introduzca el nombre del archivo para guardar los locales: ");
        filename = stdIn.nextLine();
        try {
            fileOut = new ObjectOutputStream(new FileOutputStream(filename));
            for (Local local : locales) {
                fileOut.writeObject(local);
            }
            fileOut.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static ArrayList<Local> loadLocales() {
        ArrayList<Local> locales = new ArrayList<>();
        Scanner stdIn = new Scanner(System.in);
        System.out.print("Introduzca el nombre del archivo para cargar los locales: ");
        String filename = stdIn.nextLine();
    
        try (ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                locales.add((Local) fileIn.readObject());
            }
        } catch (EOFException e) {
            System.out.println("Archivo cargado con éxito.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    
        return locales;
    }

    /*ublic static void main(String[] args) {
        Cliente c1 = new Cliente("Mario", "1234");
        Cliente c2 = c1.clone();
        c2.setNombre("Yuga");
        c2.setPassword("777");
        ArrayList<Cliente> Clients = new ArrayList<Cliente>();
        Clients.add(c1);
        Clients.add(c2);
        AccUtilery.saveClients(Clients);
        ArrayList<Cliente> Clients2 = AccUtilery.loadClientes();
        System.out.println("Admins 1:");
        for (Cliente c: Clients){
            System.out.println(c.getNombre());
        }
        System.out.println("Admins 2:");
        for (Cliente c:Clients2){
            System.out.println(c.getNombre());
        }
    }*/

    public static void saveEventos(ArrayList<Evento> eventos) {
        Scanner stdIn = new Scanner(System.in);
        ObjectOutputStream fileOut;
        String filename;
        System.out.print("Introduzca el nombre del archivo para guardar los eventos: ");
        filename = stdIn.nextLine();
        try {
            fileOut = new ObjectOutputStream(new FileOutputStream(filename));
            for (Evento evento : eventos) {
                fileOut.writeObject(evento);
            }
            fileOut.close();
            System.out.println("Eventos guardados exitosamente en " + filename);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    
    public static ArrayList<Evento> loadEventos() {
        ArrayList<Evento> eventos = new ArrayList<>();
        Scanner stdIn = new Scanner(System.in);
        System.out.print("Introduzca el nombre del archivo para cargar los eventos: ");
        String filename = stdIn.nextLine();
    
        try (ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                eventos.add((Evento) fileIn.readObject());
            }
        } catch (EOFException e) {
            System.out.println("Archivo cargado con éxito.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    
        return eventos;
    }
}

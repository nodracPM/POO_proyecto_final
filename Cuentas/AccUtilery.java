import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

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

    public static void main(String[] args) {
        Admin a1 = new Admin("Mario", "1234", "Dev3");
        Admin a2 = a1.clone();
        a2.setNombre("Yuga");
        a2.setPassword("777");
        a2.setID("Dev7");
        ArrayList<Admin> admins = new ArrayList<Admin>();
        admins.add(a1);
        admins.add(a2);
        AccUtilery.saveAdmins(admins);
        ArrayList<Admin> admins2 = AccUtilery.loadAdmins();
        System.out.println("Admins 1:");
        for (Admin a: admins){
            System.out.println(a.getNombre());
        }
        System.out.println("Admins 2:");
        for (Admin a: admins2){
            System.out.println(a.getNombre());
        }
    }
}

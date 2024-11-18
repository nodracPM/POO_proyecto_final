package programa.utilerias;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Utilerias {
    public static void limpiarConsola() {
        try {
            // Detectar el sistema operativo
            String sistemaOperativo = System.getProperty("os.name");

            if (sistemaOperativo.contains("Windows")) {
                // Comando para limpiar la consola en Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Comando para limpiar la consola en sistemas basados en UNIX (Linux, MacOS)
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Manejo de errores
            System.out.println("Error al intentar limpiar la consola: " + e.getMessage());
        }
    }

    public static void esperarCincoSegundos() {
        try {
            for(int i = 0; i < 3; i++) {
                Thread.sleep(1000); 
                System.out.print(". ");
            }
        } catch (InterruptedException e) {
            // Manejo de excepción si el hilo es interrumpido
            System.out.println("La espera fue interrumpida: " + e.getMessage());
        }
    }

    public static void esperarTecla() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Presiona Enter para continuar...");
        scanner.nextLine(); // Espera hasta que el usuario presione Enter
    }
    public static <T> LinkedList<T> convertirArrayListALinkedList(ArrayList<T> arrayList) {
        // Constructor de LinkedList que acepta una colección
        return new LinkedList<>(arrayList);
    }

    public static <T> ArrayList<T> convertirLinkedListAArrayList(LinkedList<T> linkedList) {
        // Constructor de ArrayList que acepta una colección
        return new ArrayList<>(linkedList);
    }
}

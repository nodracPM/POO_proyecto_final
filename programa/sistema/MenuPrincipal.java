package programa.sistema;

import java.util.InputMismatchException;
import java.util.Scanner;
import programa.utilerias.Utilerias;

public class MenuPrincipal {
    public Sistema sistema;

    public MenuPrincipal(Sistema sistema) {
        this.sistema = sistema;
    }

    public void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Mostrar el menú mientras el usuario no elija salir
        do {
            Utilerias.limpiarConsola();
            System.out.println("\n===== Menú Principal =====");
            System.out.println("1. Iniciar sesión como cliente");
            System.out.println("2. Iniciar sesión como administrador");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");

            do {
                try {
                    opcion = scanner.nextInt();
                }
                catch (InputMismatchException e) {
                    System.out.println("\nOpción inválida. Por favor, introduce un número.");
                    scanner.next();
                    opcion = -1;
                }
            } while (opcion != 1 && opcion != 2 && opcion != 3);

            // Manejo de las opciones con switch-case
            switch (opcion) {
                case 1:
                    Utilerias.limpiarConsola(); 
                    MenuCliente menuCliente = new MenuCliente(sistema);
                    menuCliente.menuCliente();
                    break;
                case 2:
                    Utilerias.limpiarConsola(); 
                    MenuAdministrador menuAdministrador = new MenuAdministrador(sistema);    
                    menuAdministrador.menuAdministrador();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
            }
            Utilerias.esperarCincoSegundos();
        } while (opcion != 3);

        scanner.close();
    }
}

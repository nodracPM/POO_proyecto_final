package programa.sistema;

import java.util.Scanner;
import java.util.InputMismatchException;
import programa.excepciones.*;
import programa.usuarios.Admin;
import programa.utilerias.Utilerias;

public class MenuAdministrador {
    Sistema sistema; 
    Admin admin; 

    public MenuAdministrador(Sistema sistema) {
        this.sistema = sistema;
    }

    public void menuAdministrador() {
        //Inicia sesión 
        String nombreUsuarioCliente = iniciarSesion();
        if(nombreUsuarioCliente.equals("s")) return; 

        //Cargar al objeto administrador
        Admin admin = sistema.getAdmin();
        Scanner scanner = new Scanner(System.in);
        int opcion; 

        // Mostrar el menú mientras el usuario no elija salir
        do {
            Utilerias.limpiarConsola();
            System.out.println("\n===== Menú de Cliente =====");
            System.out.println("1. Agregar evento.");
            System.out.println("2. .....");
            System.out.println("3. .....");
            System.out.println("4. Salir.");
            System.out.print("Selecciona una opcion: ");

            try {
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3: 
                        break;
                    case 4: 
                        break;
                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número.");
                opcion = -1;
                continue;   
            }
            Utilerias.esperarCincoSegundos();
        } while (opcion != 4);
    }
    
    public String iniciarSesion() {
        Scanner scanner = new Scanner(System.in);
        boolean iniciarSesionExitoso = false;

        do {
            Utilerias.limpiarConsola();
            try {
                System.out.println("\n===== Menú de Inicio de Sesión =====");
                
                // Solicitar nombreUsuario electrónico
                System.out.print("Ingresa tu nombre de usuario: ");
                String nombreUsuario = scanner.nextLine();

                // Solicitar contraseña
                System.out.print("Ingresa tu contraseña: ");
                String contrasena = scanner.nextLine();
                validarContrasena(contrasena); // Valida que la contraseña no esté vacía

                // Verificar las credenciales
                if (autenticarUsuario(nombreUsuario, contrasena)) {
                    System.out.println("Inicio de sesión exitoso. ¡Bienvenido!");
                    iniciarSesionExitoso = true; // Finaliza el bucle
                    Utilerias.esperarCincoSegundos();
                    return nombreUsuario; 
                } 

            } catch (CampoVacioException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NoRegistradoException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }

            // Regresar al menú principal

            String respuesta; 
            if(!iniciarSesionExitoso) {
                do {
                    try {
                        System.out.print("\nDeseas regresar al menú principal (s/n)? ");
                        respuesta = scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Error: " + e.getMessage());
                        respuesta = "hola :)";
                    }
                } while (!respuesta.equals("n") && !respuesta.equals("s"));

                if(respuesta.equals("s")) {
                    break; 
                }
            }
            Utilerias.esperarCincoSegundos();
        } while (!iniciarSesionExitoso); 
        return "s"; 
    }

    
    // Método para validar que la contraseña no esté vacía
    private static void validarContrasena(String contrasena) throws CampoVacioException {
        if (contrasena == null || contrasena.trim().isEmpty()) {
            throw new CampoVacioException("La contraseña no puede estar vacía.");
        }
    }

    // Método para simular la autenticación del usuario
    private boolean autenticarUsuario(String nombreUsuario, String contrasena) throws NoRegistradoException{
        if (!sistema.getAdmin().getNombreUsuario().equals(sistema.getAdmin().getNombreUsuario()) || !sistema.getAdmin().getPassword().equals(contrasena)) {
            throw new NoRegistradoException("El nombre de usuario no se encuentra registrado o la contraseña es incorrecta"); // !sistema.clientes.containsKey(nombreUsuario);
        }
        return true; 
    }
}



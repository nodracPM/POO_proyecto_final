package programa.sistema;

import java.util.Scanner;
import java.util.InputMismatchException;
import programa.excepciones.*;
import programa.usuarios.Cliente;
import programa.utilerias.Utilerias;
public class MenuCliente {
    Sistema sistema; 
    Cliente cliente; 

    public MenuCliente(Sistema sistema) {
        this.sistema = sistema;
    }
    public void menuCliente() {
        //Inicia sesión 
        String correoCliente = iniciarSesion();
        if(correoCliente.equals("s")) return; 

        //Cargar al objeto cliente
        Cliente cliente = sistema.getClientes().get(correoCliente);
        Scanner scanner = new Scanner(System.in);
        int opcion; 

        // Mostrar el menú mientras el usuario no elija salir
        do {
            Utilerias.limpiarConsola();
            System.out.println("\n===== Menú de Cliente =====");
            System.out.println("1. Ver eventos disponibles.");
            System.out.println("2. Ver mis tickets.");
            System.out.println("3. Hacer una reservación.");
            System.out.println("4. Cerrar sesión.");
            System.out.print("Selecciona una opcion: ");

            try {
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        sistema.mostrarEventos();
                        //System.out.println("\nPresione cualquier tecla para continuar...");
                        //String aux =scanner.nextLine();
                        Utilerias.esperarCincoSegundos();
                        break;
                    case 2:
                        cliente.mostrarTickets();
                        break;
                    case 3: 
                        cliente.reservar(sistema);
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
                
                // Solicitar correo electrónico
                System.out.print("Ingresa tu correo electrónico: ");
                String correo = scanner.nextLine();
                validarCorreo(correo); // Valida que el correo tenga el formato correcto

                // Solicitar contraseña
                System.out.print("Ingresa tu contraseña: ");
                String contrasena = scanner.nextLine();
                validarContrasena(contrasena); // Valida que la contraseña no esté vacía

                // Verificar las credenciales
                if (autenticarUsuario(correo, contrasena)) {
                    System.out.println("Inicio de sesión exitoso. ¡Bienvenido!");
                    iniciarSesionExitoso = true; // Finaliza el bucle
                    Utilerias.esperarCincoSegundos();
                    return correo; 
                } 

            } catch (FormatoCorreoInvalidoException e) {
                System.out.println("Error: " + e.getMessage());
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

    public void crearCuenta() {
        String correoElectronico;
        String password;
        String nombre;
        String apellidos;
        String nombreUsuario;

        Scanner scanner = new Scanner(System.in);

        do {
            Utilerias.limpiarConsola();
            try {
                System.out.print("Ingresa tu nombre: ");                
                nombre = scanner.nextLine();
                break; 
            } catch (InputMismatchException e) {
                System.out.println("Error: " + e.getMessage());
            }
            Utilerias.esperarCincoSegundos();
        }while(true); 

        do {
            Utilerias.limpiarConsola();
            try {
                System.out.print("Ingresa tu primer apellido: ");                
                apellidos = scanner.nextLine();
                break; 
            } catch (InputMismatchException e) {
                System.out.println("Error: " + e.getMessage());
            }
            Utilerias.esperarCincoSegundos();
        }while(true); 

        do {
            Utilerias.limpiarConsola();
            try {
                System.out.print("Ingresa un nombre de usuario: ");                
                nombreUsuario = scanner.nextLine();
                break; 
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            Utilerias.esperarCincoSegundos();
        }while(true); 

        do {
            Utilerias.limpiarConsola();
            try {
                System.out.print("Ingresa tu correo electrónico: ");                
                correoElectronico = scanner.nextLine();
                validarCorreo(correoElectronico);
                verificarUsuario(correoElectronico);

                break; 
            } catch (FormatoCorreoInvalidoException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (CorreoYaRegistradoException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
            Utilerias.esperarCincoSegundos();
        }while(true); 

        do {
            Utilerias.limpiarConsola();
            try {
                System.out.print("Ingresa tu contraseña: ");                
                password = scanner.nextLine();

                break; 
            } catch (InputMismatchException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
                
            Utilerias.esperarCincoSegundos();
        }while(true); 

        Cliente cliente = new Cliente(nombreUsuario, password, nombre, apellidos, correoElectronico);
        sistema.agregarCliente(cliente);
    }



    // Método para validar el formato del correo electrónico
    //.trim() elimina los espacios en blanco al inicio y al final
    private static void validarCorreo(String correo) throws FormatoCorreoInvalidoException {
        if (correo == null || correo.trim().isEmpty() || !correo.contains("@")) {
            throw new FormatoCorreoInvalidoException("El correo debe contener '@' y no estar vacío.");
        }
    }

    // Método para validar que la contraseña no esté vacía
    private static void validarContrasena(String contrasena) throws CampoVacioException {
        if (contrasena == null || contrasena.trim().isEmpty()) {
            throw new CampoVacioException("La contraseña no puede estar vacía.");
        }
    }

    // Método para simular la autenticación del usuario
    private boolean autenticarUsuario(String correo, String contrasena) throws NoRegistradoException{
        if (!sistema.getClientes().containsKey(correo) || !sistema.getClientes().get(correo).getPassword().equals(contrasena)) {
            throw new NoRegistradoException("El correo no se encuentra registrado o la contraseña es incorrecta"); // !sistema.clientes.containsKey(correo);
        }
        return true; 
    }

    private boolean verificarUsuario(String correo) throws CorreoYaRegistradoException{
        if (sistema.getClientes().containsKey(correo)) {
            throw new CorreoYaRegistradoException("El correo ya ha sido registrado."); // !sistema.clientes.containsKey(correo);
        }
        return true; 
    }
        
}






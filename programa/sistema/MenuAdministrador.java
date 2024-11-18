package programa.sistema;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.InputMismatchException;
import java.util.Date;

import programa.excepciones.*;
import programa.usuarios.AccUtilery;
import programa.usuarios.Admin;
import programa.utilerias.Utilerias;
import programa.eventos.*;

public class MenuAdministrador {
    Sistema sistema; 
    Admin admin; 

    public MenuAdministrador(Sistema sistema) {
        this.sistema = sistema;
    }

    public void menuAdministrador() {
        // Inicia sesión 
        String nombreUsuarioCliente = iniciarSesion();
        ArrayList<Local> locales = AccUtilery.loadLocales();
        sistema.cargarEventos();
        if (nombreUsuarioCliente.equals("s")) return; 
    
        Admin admin = sistema.getAdmin();
        Scanner scanner = new Scanner(System.in);
        int opcion; 
    
        
        do {
            Utilerias.limpiarConsola();
            System.out.println("\n===== Menú de Administrador =====");
            System.out.println("1. Agregar evento.");
            System.out.println("2. Eliminar evento.");
            System.out.println("3. Consultar estado de los eventos.");
            System.out.println("4. Agregar local.");
            System.out.println("5. Eliminar local.");
            System.out.println("6. Guardar eventos."); 
            System.out.println("7. Salir.");
            System.out.print("Selecciona una opcion: ");
    
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            switch (opcion) {
                case 1:
                    agregarEvento(scanner, locales);
                    break;
                case 2:
                    eliminarEventoAdministrador(sistema, scanner);
                    break;
                case 3:
                    consultarEventos();
                    break;
                case 4:
                    agregarLocal(scanner, locales);
                    break;
                case 5:
                    eliminarLocal(scanner, locales);
                    break;
                case 6:
                    sistema.guardarEventos();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
                    break;
            }
        } while (opcion != 7);
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

    private void agregarEvento(Scanner scanner, ArrayList<Local> locales) {
        System.out.println("-------- Creación de Evento --------");
        System.out.println("Ingrese los datos del Evento.");
    
        if (locales.isEmpty()) {
            System.out.println("No hay locales disponibles para asignar el evento. Por favor, agregue locales primero.");
            return;
        }
    
        try {
            System.out.print("Ingrese el ID del evento: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
    
            System.out.print("Ingrese la fecha del Evento (YYYY-MM-DD): ");
            Date fecha = new Date(scanner.nextLine());
    
            System.out.print("Ingrese la hora del Evento (HH:MM): ");
            String hora = scanner.nextLine();
    
            System.out.println("Seleccione un local para el evento:");
            for (int i = 0; i < locales.size(); i++) {
                System.out.println((i + 1) + ". " + locales.get(i).getNombre() + " - " + locales.get(i).getDireccion());
            }
            System.out.print("Opción: ");
            int seleccion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
    
            if (seleccion > 0 && seleccion <= locales.size()) {
                Local localSeleccionado = locales.get(seleccion - 1);
    
                // Generar descripción usando el método definirDescripcion
                Evento eventoTemporal = new Evento();
                String descripcion = eventoTemporal.definirDescripcion();
    
                Evento nuevoEvento = new Evento(id, fecha, hora, descripcion, localSeleccionado);
                sistema.agregarEvento(nuevoEvento);
    
                System.out.println("Evento creado exitosamente:");
                System.out.println(nuevoEvento);
            } else {
                System.out.println("Selección de local inválida. No se creó el evento.");
            }
        } catch (Exception e) {
            System.out.println("Error: Entrada no válida. Intente de nuevo.");
            scanner.nextLine(); // Limpiar buffer
        }
    }

    private static void eliminarEventoAdministrador(Sistema sistema, Scanner scanner) {
    System.out.println("\n===== Eliminar Evento =====");

    LinkedList<Evento> eventos = sistema.getEventos();
    if (eventos.isEmpty()) {
        System.out.println("No hay eventos registrados para eliminar.");
        return;
    }

    // Mostrar los eventos disponibles
    System.out.println("Lista de eventos:");
    for (int i = 0; i < eventos.size(); i++) {
        System.out.println((i + 1) + ". " + eventos.get(i));
    }

    // Solicitar el índice del evento a eliminar
    System.out.print("Selecciona el número del evento a eliminar: ");
    try {
        int seleccion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        if (seleccion > 0 && seleccion <= eventos.size()) {
            Evento eliminado = eventos.get(seleccion - 1);
            sistema.eliminarEvento(eliminado);
            System.out.println("Evento eliminado: " + eliminado);
        } else {
            System.out.println("Selección inválida.");
        }
    } catch (InputMismatchException e) {
        System.out.println("Error: Debes ingresar un número válido.");
        scanner.nextLine(); // Limpiar buffer
    }
}

private void consultarEventos() {
    System.out.println("\n===== Consultar Eventos =====");
    if (sistema.getEventos().isEmpty()) {
        System.out.println("No hay eventos registrados.");
    } else {
        sistema.mostrarEventos();
    }
}

// Método para agregar un nuevo local
private void agregarLocal(Scanner scanner, ArrayList<Local> locales) {
    System.out.println("\n===== Agregar Local =====");
    try {
        System.out.print("Ingrese el nombre del local: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la dirección del local: ");
        String direccion = scanner.nextLine();

        Local nuevoLocal = new Local(nombre, direccion);
        locales.add(nuevoLocal);

        // Guardar los locales actualizados en archivo
        AccUtilery.saveLocales(locales);

        System.out.println("Local agregado exitosamente:");
        System.out.println("Nombre: " + nuevoLocal.getNombre());
        System.out.println("Dirección: " + nuevoLocal.getDireccion());
    } catch (Exception e) {
        System.out.println("Error al agregar el local: " + e.getMessage());
    }
}

// Método para eliminar un local
private void eliminarLocal(Scanner scanner, ArrayList<Local> locales) {
    System.out.println("\n===== Eliminar Local =====");
    if (locales.isEmpty()) {
        System.out.println("No hay locales registrados para eliminar.");
        return;
    }

    try {
        // Mostrar los locales disponibles
        System.out.println("Lista de locales:");
        for (int i = 0; i < locales.size(); i++) {
            System.out.println((i + 1) + ". " + locales.get(i).getNombre() + " - " + locales.get(i).getDireccion());
        }

        // Solicitar el índice del local a eliminar
        System.out.print("Selecciona el número del local a eliminar: ");
        int seleccion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        if (seleccion > 0 && seleccion <= locales.size()) {
            Local eliminado = locales.remove(seleccion - 1);

            // Guardar los locales actualizados en archivo
            AccUtilery.saveLocales(locales);

            System.out.println("Local eliminado: " + eliminado.getNombre());
        } else {
            System.out.println("Selección inválida.");
        }
    } catch (InputMismatchException e) {
        System.out.println("Error: Debes ingresar un número válido.");
        scanner.nextLine(); // Limpiar buffer
    }
}
}




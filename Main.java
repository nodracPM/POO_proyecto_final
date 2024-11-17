import programa.sistema.*;
import programa.usuarios.*;

public class Main {
    public static void main(String[] args) {
        // Datos predeterminados de acces al cliente 
        Cliente clienteGenerico = new Cliente("cliente", "clave1234", "clienteGenerico", "clienteGenerico", "cliente@gmail.com");
       
        /* Datos predeterminados para el acceso del administrador: 
         * Nombre: Admi
         * Password: Admi91711
         */

        Sistema sistema = new Sistema();
        sistema.agregarCliente(clienteGenerico);

        MenuPrincipal menuPrincipal = new MenuPrincipal(sistema);
        menuPrincipal.menuPrincipal();
        
    }
}

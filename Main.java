import java.util.LinkedList;

import programa.eventos.Evento;
import programa.eventos.Local;
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


        //Eventos muestra 
        Sistema sistema = new Sistema();
        sistema.agregarCliente(clienteGenerico);
        LinkedList<Evento> eventos = new LinkedList<>();

        // Crear instancias de Evento con Local que incluye dirección
        sistema.agregarEvento(new Evento(1, "2024-11-20", "18:00", new Local("Auditorio Central", "Calle 123, Ciudad")));
        sistema.agregarEvento(new Evento(2, "2024-11-25", "20:00", new Local("Teatro Nacional", "Avenida 456, Ciudad")));
        sistema.agregarEvento(new Evento(3, "2024-12-01", "19:30", new Local("Estadio Olímpico", "Boulevard 789, Ciudad")));
        sistema.agregarEvento(new Evento(4, "2024-12-10", "21:00", new Local("Centro Cultural", "Plaza 101, Ciudad")));
        sistema.agregarEvento(new Evento(5, "2024-12-15", "16:00", new Local("Palacio de los Deportes", "Carretera 202, Ciudad")));



        MenuPrincipal menuPrincipal = new MenuPrincipal(sistema);
        menuPrincipal.menuPrincipal();
        
    }
}

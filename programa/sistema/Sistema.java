package programa.sistema;

import java.util.LinkedList;
import java.util.HashMap; 
import programa.usuarios.*;
import programa.utilerias.Utilerias;
import programa.eventos.*;

public class Sistema {
    private Admin admin;
    private HashMap<String, Cliente> clientes; 
    private LinkedList<Evento> eventos;
    
    // Constructores

    // El constructor con parámetros se utiliza para cargar un sistema previamente creado
    public Sistema(Admin admin, HashMap<String, Cliente> clientes, LinkedList<Evento> eventos) {
        this.admin = admin;
        this.clientes = clientes;
        this.eventos = eventos;
    }

    public Sistema() {
        /* Datos predeterminados para el acceso del administrador: 
         * Nombre: Admi
         * Password: Admi91711
         */
        this.admin = new Admin("Admi", "Admi91711");
        this.clientes = new HashMap<String, Cliente>(); 
        this.eventos = new LinkedList<Evento>();

    }

    // Getters y Setters
    public Admin getAdmin() {
        return admin;
    }

    public HashMap<String, Cliente> getClientes() {
        return clientes; 
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void setClientes(HashMap<String, Cliente> clientes) {
        this.clientes = clientes;
    }   

    public void setEventos(LinkedList<Evento> eventos) {
        this.eventos = eventos;
    }

    public LinkedList<Evento> getEventos() {
        return this.eventos;
    }

    // Métodos
    public void pantallaPrincipal() {
        System.out.println("Bienvenido al sistema de administración de clientes");
    }

    public void agregarCliente(Cliente cliente) {
        if(this.clientes.containsKey(cliente.getCorreoElectronico())) {
            System.out.println("El correo electrónico ingresado ya se encuentra registrado");
            return; 
        }

        clientes.put(cliente.getCorreoElectronico(), cliente);
    }

    public void eliminarCliente(String correoElectronico) {
        if(!this.clientes.containsKey(correoElectronico)) {
            System.out.println("El correo electrónico ingresado no se encuentra registrado");
            return; 
        }
        this.clientes.remove(correoElectronico);
    }

    public void agregarEvento(Evento evento) {
        this.eventos.add(evento);
    }

    public void eliminarEvento(Evento evento) {
        this.eventos.remove(evento);
    }

    public void mostrarEventos() {
        for(Evento evento : this.eventos) {
            System.out.println("------------------------------------------------------------");
            System.out.println(evento.toString());
        }
    }

    public void cargarEventos() {
        eventos = Utilerias.convertirArrayListALinkedList(AccUtilery.loadEventos());
        System.out.println("Eventos cargados: " + eventos.size());
    }

    public void guardarEventos() {
        AccUtilery.saveEventos(Utilerias.convertirLinkedListAArrayList(eventos));
    }
}

package programa.sistema;

import java.util.LinkedList;
import java.util.HashMap; 
import programa.usuarios.*; 

public class Sistema {
    private Admin admin;
    private HashMap<String, Usuario> usuarios; // Se utiliza un HashMap para no permitir la dupliación de nombres de usuario

    
    // Constructores
    public Sistema(Admin admin, HashMap<String, Usuario> usuarios) {
        this.admin = admin;
        this.usuarios = usuarios;
    }

    public Sistema() {
        /* Datos predeterminados para el acceso del administrador: 
         * Nombre: Admi
         * Password: Admi'9'11
         */
        this.admin = new Admin();
        this.clientes = new LinkedList<Cliente>();
    }

    // Getters y Setters
    public Admin getAdmin() {
        return admin;
    }

    public LinkedList<Cliente> getClientes() {
        return clientes;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void setClientes(LinkedList<Cliente> clientes) {
        this.clientes = clientes;
    }  
    
    // Métodos
    public void pantallaPrincipal() {
        System.out.println("Bienvenido al sistema de administración de clientes");
    }
}

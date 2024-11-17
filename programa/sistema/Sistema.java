package programa.sistema;

import java.util.LinkedList;
import java.util.HashMap; 
import programa.usuarios.*; 

public class Sistema {
    private Admin admin;
    private HashMap<String, Usuario> usuarios; // Se utiliza un HashMap para no permitir la dupliación de nombres de usuario
                                               // El usuario 1 (indíce 0) es el administrador 
    
    // Constructores

    // El constructor con parámetros se utiliza para cargar un sistema previamente creado
    public Sistema(Admin admin, HashMap<String, Usuario> usuarios) {
        this.admin = admin;
        this.usuarios = usuarios;
    }

    public Sistema() {
        /* Datos predeterminados para el acceso del administrador: 
         * Nombre: Admi
         * Password: Admi91711
         */
        this.admin = new Admin("Admi", "Admi91711");
        this.usuarios = new HashMap<String, Usuario>(); 

    }

    // Getters y Setters
    public Admin getAdmin() {
        return admin;
    }

    public HashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void setUsuarios(HashMap<String, Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    // Métodos
    public void pantallaPrincipal() {
        System.out.println("Bienvenido al sistema de administración de clientes");
    }

    public void agregarUsuario(Usuario u) {
        if(u.getNombre())
        this.usuarios.put(u.getNombre(), u);
    }
}

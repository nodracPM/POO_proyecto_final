import java.util.LinkedList;

public class Sistema {
    private Administrador admin;
    private LinkedList<Cliente> clientes; 

    // Constructores
    public Sistema(Administrador admin, LinkedList<Cliente> clientes) {
        this.admin = admin;
        this.clientes = clientes;
    }

    public Sistema() {
        this.admin = new Administrador();
        this.clientes = new LinkedList<Cliente>();
    }

    // Getters y Setters
    public Administrador getAdmin() {
        return admin;
    }

    public LinkedList<Cliente> getClientes() {
        return clientes;
    }

    public void setAdmin(Administrador admin) {
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

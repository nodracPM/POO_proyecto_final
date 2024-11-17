package programa.usuarios;

public class Cartera {
    private double dinero; 

    public Cartera() {
        this.dinero = 0; 
    }

    //getters y setters 
    public double getDinero() {
        return dinero; 
    } 

    public void ingresar_dinero(double dinero) {
        this.dinero += dinero; 
    }

    public void retirar_dinero(double dinero) {
        this.dinero -= dinero; 
    } 
}

package programa.cartera;

import java.util.LinkedList;

public class Cartera {
    private LinkedList<MetodoPago> metodosPago;
    public void agregarMetodo(MetodoPago metodo) {
        this.metodosPago.add(metodo); 
    }

    public void eliminarMetodo(MetodoPago metodo) {
        this.metodosPago.remove(metodo); 
    }
}

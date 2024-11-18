package programa.cartera;

import java.util.LinkedList;

public class Cartera {
    private LinkedList<MetodoPago> metodosPago;

    public Cartera() {
        this.metodosPago = new LinkedList<MetodoPago>(); 
    }
    public void agregarMetodo(MetodoPago metodo) {
        this.metodosPago.add(metodo); 
    }

    public LinkedList<MetodoPago> getMetodosPago() {
        return metodosPago; 
    }
    public void eliminarMetodo(MetodoPago metodo) {
        this.metodosPago.remove(metodo); 
    }

    public Boolean existenMetodosPago() {
        if(metodosPago.isEmpty()) return false;
        return true;
    }

    public void mostrarMetodosPago() {
        if(metodosPago.isEmpty())
            System.out.println("No se encontraron metodos de pago");
        else {
            int i = 1; 
            for(MetodoPago metodoPago : metodosPago) {
                if (metodoPago instanceof Tarjeta) {
                    System.out.println(i + ". Tarjeta de número " + ((Tarjeta)metodoPago).getNumero());
                }
                else if (metodoPago instanceof PayPal) {    
                    System.out.println(i + ". PayPal de correo " + ((PayPal)metodoPago).getCorreo());
                }
                i++; 
            }
        }
    }
}

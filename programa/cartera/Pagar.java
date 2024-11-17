package programa.cartera;

public class Pagar implements Visitor{
    public void visit(Tarjeta tarjeta) {
        // Aquí va toda la lógica para pagar con tarjera 
    }
    public void visit(PayPal paypal) {
        // Aquí va toda la lógica para pagar con PayPal
    }
}

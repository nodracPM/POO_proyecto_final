package programa.cartera;

public class Pagar implements Visitor{
    public void visit(Tarjeta tarjeta) {
        System.out.println("\nLa transacción ha sido completada");
        System.out.println("Número de tarjeta: " + tarjeta.getNumero());
    }
    public void visit(PayPal paypal) {
        System.out.println("\nLa transacción ha sido completada");
        System.out.println("Correo electrónco: " + paypal.getCorreo());
    }
}

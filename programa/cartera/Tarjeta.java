package programa.cartera;

public class Tarjeta implements MetodoPago{
    String numero;
    String fechaVencimiento;
    String CVV;

    public Tarjeta() {}

    public Tarjeta(String numero, String fechaVencimiento, String CVV) {
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
        this.CVV = CVV;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }   

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public String getNumero() {
        return this.numero;
    }   

    public String getFechaVencimiento() {
        return this.fechaVencimiento;
    }   

    public String getCVV() {
        return this.CVV;
    }   

    public void acceptVisitor(Visitor visitor) {
        visitor.visit(this);
    }
}

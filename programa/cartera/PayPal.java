package programa.cartera;

public class PayPal implements MetodoPago{
    String correoElectronico;
    String password;

    public PayPal() {}; 
    
    public PayPal(String correoElectronico, String password) {
        this.correoElectronico = correoElectronico;
        this.password = password;
    }

    public void setCorreo(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getCorreo() {
        return this.correoElectronico;
    }

    public void acceptVisitor(Visitor visitor) {
        visitor.visit(this);
    }
}

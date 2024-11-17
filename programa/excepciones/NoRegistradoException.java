package programa.excepciones;

// Excepción personalizada para cuando el correo no está registrado en la base de datos
public class NoRegistradoException extends Exception {
    public NoRegistradoException(String mensaje) {
        super(mensaje);
    }
}

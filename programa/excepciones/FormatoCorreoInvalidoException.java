package programa.excepciones;

// Excepción personalizada para formato de correo inválido
public class FormatoCorreoInvalidoException extends Exception {
    public FormatoCorreoInvalidoException(String mensaje) {
        super(mensaje);
    }
 }

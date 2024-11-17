package programa.excepciones;

// Excepción personalizada para campos vacíos
public class CampoVacioException extends Exception {
    public CampoVacioException(String mensaje) {
        super(mensaje);
    }
}

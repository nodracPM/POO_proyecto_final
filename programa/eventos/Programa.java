package programa.eventos;

public class Programa {
    public static void main(String[] args) {
        // Crear un local
        Local teatro = new Local("Teatro Principal", "Av. Central 123");

        // Crear secciones
        Seccion platea = new Seccion("Platea", 30, 1500.0);
        Seccion balcon = new Seccion("Balcón", 20, 1200.0);

        // Agregar secciones al local
        teatro.agregarSeccion(platea);
        teatro.agregarSeccion(balcon);

        // Intentar reservar asientos
        teatro.reservarAsiento("Platea", "A5"); // Correcto
        teatro.reservarAsiento("Balcón", "B2"); // Incorrecto (fuera de rango)

        // Mostrar disponibilidad
        System.out.println(teatro.resumenDisponibilidad());

        // Mostrar resumen del local
        System.out.println(teatro);
    }
}

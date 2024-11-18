package programa.cartera;

import programa.excepciones.*;
import programa.utilerias.Utilerias;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AgregarMetodo implements Visitor{
    public void visit(Tarjeta tarjeta) {
        Scanner scanner = new Scanner(System.in);

        String numeroTarjeta; 
        String anioVencimiento;
        String mesVencimiento;
        String fechaVencimiento;
        String CVV;


        do {
            Utilerias.limpiarConsola();
            try {
                System.out.print("Ingresa el número de la tarjeta (sin espacios): ");
                numeroTarjeta = scanner.nextLine();
                verificarNumeroTarjeta(numeroTarjeta);
                tarjeta.setNumero(numeroTarjeta);
                break; 
            } catch (ExtensionNoValidaException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
            Utilerias.esperarCincoSegundos();
        } while(true); 

        do {
            Utilerias.limpiarConsola();
            try {
                System.out.print("Ingresa dos digitos para el año de vencimiento de la tarjeta (sin espacios): ");
                anioVencimiento= scanner.nextLine();
                verificarFecha(anioVencimiento);
                break; 
            } catch (ExtensionNoValidaException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
            Utilerias.esperarCincoSegundos();
        } while(true); 
        
        do {
            Utilerias.limpiarConsola();
            try {
                System.out.print("Ingresa dos digitos para el mes de vencimiento de la tarjeta (sin espacios): ");
                mesVencimiento = scanner.nextLine();
                verificarFecha(mesVencimiento);
                tarjeta.setFechaVencimiento(mesVencimiento + "/" + anioVencimiento);
                break; 
            } catch (ExtensionNoValidaException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
            Utilerias.esperarCincoSegundos();
        } while(true); 


        do {
            Utilerias.limpiarConsola();
            try {
                System.out.print("Ingresa el cvv de la tarjeta (sin espacios): ");
                CVV = scanner.nextLine();
                verificarCVV(CVV);
                tarjeta.setCVV(CVV);
                break; 
            } catch (ExtensionNoValidaException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
            Utilerias.esperarCincoSegundos();
        } while(true); 

        System.out.println("\nMetodo de pago agregado exitosamente.");
    }

    public void visit(PayPal paypal) {
        Scanner scanner = new Scanner(System.in);

        String correoElectronico; 
        String contrasena; 

        do {
            Utilerias.limpiarConsola();
            try {
                System.out.print("Ingresa el correo electrónico asociado a tu cuenta: ");
                correoElectronico = scanner.nextLine();
                validarCorreo(correoElectronico);
                paypal.setCorreo(correoElectronico);
                break;
            } catch (FormatoCorreoInvalidoException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
            Utilerias.esperarCincoSegundos();
        } while(true); 


        do {
            Utilerias.limpiarConsola();
            try {
                System.out.print("Ingresa tu contraseña: ");
                contrasena = scanner.nextLine();
                validarContrasena(contrasena);
                paypal.setPassword(contrasena);
                break;
            } catch (CampoVacioException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
            Utilerias.esperarCincoSegundos();
        } while(true); 

        System.out.println("\nMetodo de pago agregado exitosamente.");
    }


    public void verificarNumeroTarjeta(String numeroTarjeta) throws ExtensionNoValidaException{
        if(numeroTarjeta.length() != 16) {
            throw new ExtensionNoValidaException("El número de tarjeta debe tener 16 digitos.");
        }
    }

    public void verificarFecha(String fecha) throws ExtensionNoValidaException{
        if(fecha.length() != 2) {
            throw new ExtensionNoValidaException("Ingresa dos digitos.");
        }
    }

    public void verificarCVV(String cvv) throws ExtensionNoValidaException{
        if(cvv.length() != 3) {
            throw new ExtensionNoValidaException("El cvv ingresado no es válido.");
        }
    }

    private static void validarCorreo(String correo) throws FormatoCorreoInvalidoException {
        if (correo == null || correo.trim().isEmpty() || !correo.contains("@")) {
            throw new FormatoCorreoInvalidoException("El correo debe contener '@' y no estar vacío.");
        }
    }

    private static void validarContrasena(String contrasena) throws CampoVacioException {
        if (contrasena == null || contrasena.trim().isEmpty()) {
            throw new CampoVacioException("La contraseña no puede estar vacía.");
        }
    }
}   

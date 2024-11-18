package programa.usuarios;

import programa.cartera.*;
import programa.eventos.Boleto;
import programa.eventos.Evento;
import programa.sistema.Sistema;
import programa.utilerias.Utilerias;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Cliente extends Usuario implements Cloneable{
    String nombre; 
    String apellidos; 
    String correoElectronico; 
    Cartera cartera;
    LinkedList<Ticket> tickets; 

    public Cliente(String nombreUsuario, String Password, String nombre, String apellidos, String correoElectronico){
        super(nombreUsuario, Password);
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
        this.cartera = new Cartera();
        this.tickets = new LinkedList<Ticket>();
    }

    //getter y setter para la cartera, pero ese código es de Pedro
    //Las funciones de compra, devolución 
    /*@Override
    public Cliente clone(){
        return new Cliente(this.getNombre(), this.getPassword());
    }*/


    public String getNombre() {
        return this.nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public String getCorreoElectronico() {
        return this.correoElectronico;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void reservar(Sistema sistema) {
        Scanner scanner = new Scanner(System.in);
        
        int idEvento;

        do {
            try {
                Utilerias.limpiarConsola();
                sistema.mostrarEventos();
                System.out.print("\nIngresa el ID del evento que deseas reservar: ");
                idEvento = scanner.nextInt();
                if(idEvento > sistema.getEventos().size() || idEvento < 1) {
                    System.out.println("\nPor favor, introduce un número valido.");
                }
                else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nOpción inválida. Por favor, introduce un número.");
                scanner.next();
            }
            Utilerias.esperarCincoSegundos();
        } while(true); 

        cartera.mostrarMetodosPago(); 
        Utilerias.esperarCincoSegundos();
        //Si existe algún método de pago se puede realizar la compra
        if(cartera.existenMetodosPago()) {
            int metodoPago; 
            do {
                Utilerias.limpiarConsola();
                System.out.print("\nSelecciona un metodo de pago: ");

                try {
                    metodoPago = scanner.nextInt();
                    if(metodoPago > cartera.getMetodosPago().size()) {
                        System.out.println("\nPor favor, introduce un número válido.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\nOpción inválida. Por favor, introduce un número.");
                    metodoPago = -1;
                }
                Utilerias.esperarCincoSegundos();
            } while (metodoPago < 1 || metodoPago > cartera.getMetodosPago().size());

            MetodoPago metodo = cartera.getMetodosPago().get(metodoPago - 1);
            metodo.acceptVisitor(new Pagar());

            Evento evento = sistema.getEventos().get(idEvento - 1);
            Ticket ticket = new Ticket(evento.getAsientos(), this.getNombre(), evento.getFecha());
            tickets.add(ticket);
            System.out.println("\nGracias por su compra.");
        }
        else {
            String opcion; 
            do {
                Utilerias.limpiarConsola();
                System.out.print("\n¿Deseas agregar un método de pago (y/n)? ");
                opcion = scanner.next();
                try {
                    if(!opcion.equals("y") && !opcion.equals("n")) 
                        System.out.println("\nPor favor, introduce una opción válida.");
                } catch (InputMismatchException e) {
                    System.out.println("\nOpción inválida. Por favor, introduce un caracter.");
                    opcion = "opcion";
                }
                Utilerias.esperarCincoSegundos();
            } while (!opcion.equals("y") && !opcion.equals("n"));

            if(opcion.equals("y")) {
                Utilerias.limpiarConsola();
                agregarMetodo();

                this.reservar(sistema); 
            }
        } 
    }

    public void agregarMetodo() {
        Scanner scanner = new Scanner(System.in);
        int opcion; 
        do {
            System.out.println("\n1. Tarjeta de crédito / Debito.");
            System.out.println("2. PayPal.");
            try {
                System.out.println("\nIngresa el metodo de pago: "); 
                opcion = scanner.nextInt();
                if (opcion < 1 || opcion > 2) {
                    System.out.println("\nPor favor, introduce un número válido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nOpción inválida. Por favor, introduce un número.");
                scanner.next();
                opcion = -1;
            }

        } while (opcion < 1 || opcion > 2);

        if(opcion == 1) {
            Tarjeta tarjeta = new Tarjeta();
            tarjeta.acceptVisitor(new AgregarMetodo());
            this.cartera.agregarMetodo(tarjeta);

        }
        else {
            PayPal paypal = new PayPal();
            paypal.acceptVisitor(new AgregarMetodo());
            this.cartera.agregarMetodo(paypal);
        }
    }

    public void mostrarTickets() {
        if(tickets.isEmpty()) {
            System.out.println("No se encontraron tickets");
            Utilerias.esperarCincoSegundos();
        }   
        else {
            for(Ticket ticket : tickets) {
                System.out.println(ticket.toString());
                System.out.println("-------------------------------------------------");
            }
        }
    }

    public void TicketTransfer(Cliente destino, Ticket boleto){
        temp = boleto.clone();
        temp.setPropietario(destino.getNombreUsuario());
        destino.getReservaciones().add(temp);
        self.getReservaciones().remove(boleto);
    }
}

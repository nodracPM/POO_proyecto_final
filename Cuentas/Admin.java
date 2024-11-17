public class Admin extends Usuario implements Cloneable{
    private String ID;

    public Admin(String Nombre,String Password,String ID){
        super(Nombre,Password);
        this.ID = ID;
    }

    public String getID(){
        return this.ID;
    }

    public void setID(String ID){
        this.ID = ID;
    }

    @Override
    public Admin clone(){
        return new Admin(this.getNombre(), this.getPassword(), this.ID);
    }

    public static void main(String[] args) {
        Admin a1 = new Admin("Mario", "12345","Number3");
        System.out.println("Antes de clonar: ");
        System.out.println(a1.getNombre());
        System.out.println(a1.getID());
        Admin a2 = a1.clone();
        a2.setNombre("Yuga");
        a2.setPassword("777");
        a2.setID("Ohdone");
        System.out.println("Después de clonar y modificar");
        System.out.println(a2.getNombre());
        System.out.println(a2.getID());
        System.out.println(a1.getNombre());
        System.out.println(a1.getID());
    }
}

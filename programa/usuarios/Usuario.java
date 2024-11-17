package programa.usuarios;

public class Usuario{
  String Nombre;
  String Password;
  
  public Usuario(String Nombre,String Password){
    this.Nombre = Nombre;
    this.Password = Password;
  }

  public String getNombre(){
    return this.Nombre;
  }

  public void setNombre(String Nombre){
    this.Nombre = Nombre;
  }

  public String getPassword(){
    return this.Nombre;
  }

  public void setPassword(String Password){
    this.Nombre = Nombre;
  }
  
}

package programa.usuarios;

public class Usuario{
  String nombreUsuario;
  String password;
  
  public Usuario(String nombreUsuario,String Password){
    this.nombreUsuario = nombreUsuario;
    this.password = Password;
  }

  public String getNombre(){
    return this.nombreUsuario;
  }

  public void setNombre(String nombreUsuario){
    this.nombreUsuario = nombreUsuario;
  }

  public String getPassword(){
    return this.nombreUsuario;
  }

  public void setPassword(String password){
    this.password = password;
  }
  
}

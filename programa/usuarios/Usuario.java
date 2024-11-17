package programa.usuarios;

public class Usuario{
  String nombreUsuario;
  String password;
  
  public Usuario(String nombreUsuario, String Password){
    this.nombreUsuario = nombreUsuario;
    this.password = Password;
  }

  public String getNombreUsuario(){
    return this.nombreUsuario;
  }

  public void setNombreUsuario(String nombreUsuario){
    this.nombreUsuario = nombreUsuario;
  }

  public String getPassword(){
    return this.password;
  }

  public void setPassword(String password){
    this.password = password;
  }
  
}

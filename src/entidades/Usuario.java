package entidades;

import excessoes.UsuarioException;

public class Usuario {
     private String login;
     private int senha;
     private int tipo_de_usuario;

     public String getLogin() {
          return this.login;
     }

     public void setLogin(String login) {
          try {
               if (login.length() <= 10) {
                    this.login = login;
               } else {
                    throw new UsuarioException("O login contém mais de 10 caracteres.");
               }
          } catch (UsuarioException e) {
               e.printStackTrace();
          }

     }

     public int getSenha() {
          return this.senha;
     }

     public void setSenha(int senha) {
          try {
               if ((String.valueOf(senha).length() >= 3) && (String.valueOf(senha).length() <= 9)) {
                    this.senha = senha;
               } else {
                    throw new UsuarioException("A senha deve conter de 3 a 9 dígitos");
               }
          } catch (UsuarioException e) {
               e.printStackTrace();
          }
     }

     public int getTipoDeUsuario() {
          return this.tipo_de_usuario;
     }

     public void setTipoDeUsuario(int tipo_de_usuario) {
          this.tipo_de_usuario = tipo_de_usuario;
     }
}

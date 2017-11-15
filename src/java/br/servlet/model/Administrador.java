package br.servlet.model;
import java.io.*;

 
public class Administrador implements Serializable {
   int id=0;
   String usuario="", senha="";
 
   public int getId(){
       return this.id;
   }
   
   public String getUsuario(){
       return this.usuario;
   }
   
   public String getSenha(){
       return this.senha;
   }
   
   public void setId(int set){
       this.id = set;
   }
   
   public void setUsuario(String set){
       this.usuario = set;
   }
   
   public void setSenha(String set){
       this.senha = set;
   }
}
package br.servlet.model;

 
public class Administrador {
   int id;
   String usuario, senha;
 
   public int getId(){
       return this.id;
   }
   
   public String getUsuario(){
       return this.usuario;
   }
   
   public String getSenha(){
       return this.usuario;
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
package br.servlet.model;
import java.io.*;
 
public class Categoria implements Serializable {
   int id;
   String descricao;
 
   public int getId(){
       return this.id;
   }
   
   public String getDescricao(){
       return this.descricao;
   }
   
   public void setId(int set){
       this.id = set;
   }
   
   public void setDescricao(String set){
       this.descricao = set;
   }
}
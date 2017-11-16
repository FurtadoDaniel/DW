package br.servlet.model;
import java.io.*;

import br.servlet.model.Cliente;
import br.servlet.model.Produto;
 
public class Compra implements Serializable {
   int id=0;
   Cliente cliente;
   Produto produto;
 
   public int getId(){
       return this.id;
   }
   
   public Produto getProduto(){
       return this.produto;
   }
   
   public Cliente getCliente(){
       return this.cliente;
   }
   
   public void setId(int set){
       this.id = set;
   }
   
   public void setCliente(Cliente set){
       this.cliente = set;
   }
   
   public void setProduto(Produto set){
       this.produto = set;
   }
}
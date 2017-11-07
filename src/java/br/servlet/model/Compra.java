package br.servlet.model;

import br.servlet.model.Cliente;
import br.servlet.model.Produto;
 
public class Compra {
   int id;
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
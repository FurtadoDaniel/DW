package br.servlet.model;
import java.io.*;

 
public class Cliente implements Serializable {
   int id;
   String nome, endereco, cep, estado, referencia, cpf, rg, telefone, celular, cartao, bandeira;
 
   public int getId(){
       return this.id;
   }
   
   public String getNome(){
       return this.nome;
   }
   
   public String getEndereco(){
       return this.endereco;
   }
   
   public String getCep(){
       return this.cep;
   }
   
   public String getEstado(){
       return this.estado;
   }
   
   public String getReferencia(){
       return this.referencia;
   }
   
   public String getCpf(){
       return this.cpf;
   }
   
   public String getRg(){
       return this.rg;
   }
   
   public String getTelefone(){
       return this.telefone;
   }
   
   public String getCelular(){
       return this.celular;
   }
   
   public String getCartao(){
       return this.cartao;
   }
   
   public String getBandeira(){
       return this.bandeira;
   }
   
   public void setId(int set){
       this.id = set;
   }
   
   public void setEndereco(String set){
       this.nome = set;
   }
   
   public void setCep(String set){
       this.cep = set;
   }
   
   public void setNome(String set){
       this.nome = set;
   }
   
   public void setEstado(String set){
       this.estado = set;
   }
   
   public void setReferencia(String set){
       this.referencia = set;
   }
   
   public void setCpf(String set){
       this.cpf = set;
   }
   
   public void setRg(String set){
       this.rg = set;
   }
   
   public void setTelefone(String set){
       this.telefone = set;
   }
   
   public void setCelular(String set){
       this.celular = set;
   }
   
   public void setCartao(String set){
       this.cartao = set;
   }
   
   public void setBandeira(String set){
       this.bandeira = set;
   }
}

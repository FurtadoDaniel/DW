package br.servlet.model;

//import br.servlet.model.Categoria;
 
public class Produto {
   int id;
   float valor;
   //Categoria categoria;
   String   nome, descricao;
 
   public int getId(){
       return this.id;
   }
   
   public float getValor(){
       return this.valor;
   }
   /*
   public Categoria getCategoria(){
       return this.categoria;
   }
   */
   
   public String getNome(){
       return this.nome;
   }
   
   public String getDescricao(){
       return this.descricao;
   }
   
   public void setId(int set){
       this.id = set;
   }
   
   public void setValor(Float set){
       this.valor = set;
   }
   /*
   public void setCategoria(Categoria set){
       this.categoria = set;
   }
   */
   public void setNome(String set){
       this.nome = set;
   }
   
   public void setDescricao(String set){
       this.descricao = set;
   }
}
package br.servlet.model;
import java.util.Date;
 
public class User {
   String uname, password, email;
   Date registeredon;
 
   public String getUname(){
       return this.uname;
   }
   
   public String getPassword(){
       return this.password;
   }
   
   public String getEmail(){
       return this.email;
   }
   
   public Date getRegisteredon(){
    return this.registeredon;
   }
   
   public void setUname(String set){
       this.uname = set;
   }
   
   public void setPassword(String set){
       this.password = set;
   }
   
   public void setEmail(String set){
       this.email = set;
   }
   
   public void setRegisteredon(Date set){
       this.registeredon = set;
   }
}
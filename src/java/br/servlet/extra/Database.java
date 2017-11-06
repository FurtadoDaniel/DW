package br.servlet.extra;
import java.sql.Connection;
import java.sql.DriverManager;
public class Database {
      public static Connection getConnection() {
          try  {
              Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
              Connection con = DriverManager.getConnection
                      ("jdbc:derby://localhost:1527/DW",
                      "APP","123");
              
              //O segundo argumento do getconnection segundo a documentacao deveria ser o usuario, mas os metodos usam ele como nome do schema
              
              return con;
          }
          catch(Exception ex) {
              System.out.println("Database.getConnection() Error -->" + ex.getMessage());
              return null;
          }
      }
      
 
       public static void close(Connection con) {
          try  {
              con.close();
          }
          catch(Exception ex) {
          }
      }
}
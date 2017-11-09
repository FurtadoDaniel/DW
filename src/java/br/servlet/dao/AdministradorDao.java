package br.servlet.dao;
 
import java.sql.*;
import java.util.*;
import br.servlet.model.Administrador;
import br.servlet.extra.Database;
 
public class AdministradorDao {
 
    private Connection connection;
 
    public AdministradorDao() {
        connection = Database.getConnection();
    }
 

    public void addAdministrador(Administrador administrador) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into ADMINISTRADOR (USUARIO, SENHA) values ( ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, administrador.getUsuario());
            preparedStatement.setString(2, administrador.getSenha());
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public void deleteAdministrador(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from ADMINISTRADOR where ID=?");
            // Parameters start with 1
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public void updateProuto(Administrador administrador) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update ADMINISTRADOR set USUARIO=?, SENHA ?"
                    + "where ID=?");
            // Parameters start with 1
            
            preparedStatement.setString(1, administrador.getUsuario());
            preparedStatement.setString(2, administrador.getSenha());
            preparedStatement.setInt(3, administrador.getId());
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public List<Administrador> getAdministradors() {
        List<Administrador> administradors = new ArrayList<Administrador>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from ADMINISTRADOR");
            while (rs.next()) {
                Administrador administrador = new Administrador();
                administrador.setId(rs.getInt("ID"));
                administrador.setUsuario(rs.getString("USUARIO"));
                administrador.setSenha(rs.getString("SENHA"));
                administradors.add(administrador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return administradors;
    }
 
    public Administrador getAdministrador(int Id) {
        Administrador administrador = new Administrador();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from ADMINISTRADOR where ID=?");
            preparedStatement.setInt(1, Id);
            ResultSet rs = preparedStatement.executeQuery();
 
            if (rs.next()) {
                administrador.setId(rs.getInt("ID"));
                administrador.setUsuario(rs.getString("USUARIO"));
                administrador.setSenha(rs.getString("SENHA"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return administrador;
    }
    
    public int getAdministrador(String user, String senha) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from ADMINISTRADOR where USUARIO=? AND SENHA=?");
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, senha);
            ResultSet rs = preparedStatement.executeQuery();
 
            if (rs.next()) {
                return (rs.getInt("ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return 0;
    }
    
}
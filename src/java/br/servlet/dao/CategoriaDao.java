package br.servlet.dao;
 
import java.sql.*;
import java.util.*;
import br.servlet.model.Categoria;
import br.servlet.extra.Database;
 
public class CategoriaDao {
 
    private Connection connection;
 
    public CategoriaDao() {
        connection = Database.getConnection();
    }
 

    public void addCategoria(Categoria categoria) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into CATEGORIA (DESCRICAO) values ( ? )");
            // Parameters start with 1
            preparedStatement.setString(1, categoria.getDescricao());
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public void deleteCategoria(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from CATEGORIA where ID=?");
            // Parameters start with 1
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public void updateCategoria(Categoria categoria) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update CATEGORIA set DESCRICAO=?"
                    + "where ID=?");
            // Parameters start with 1
            
            preparedStatement.setString(1, categoria.getDescricao());
            preparedStatement.setInt(2, categoria.getId());
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public List<Categoria> getCategorias() {
        List<Categoria> categorias = new ArrayList<Categoria>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from CATEGORIA");
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("ID"));
                categoria.setDescricao(rs.getString("DESCRICAO"));
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return categorias;
    }
 
    public Categoria getCategoria(int Id) {
        Categoria categoria = new Categoria();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from CATEGORIA where ID=?");
            preparedStatement.setInt(1, Id);
            ResultSet rs = preparedStatement.executeQuery();
 
            if (rs.next()) {
                categoria.setId(rs.getInt("ID"));
                categoria.setDescricao(rs.getString("DESCRICAO"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return categoria;
    }
}
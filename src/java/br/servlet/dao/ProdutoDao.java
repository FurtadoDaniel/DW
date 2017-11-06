package br.servlet.dao;
 
import java.sql.*;
import java.util.*;
import br.servlet.model.Produto;
import br.servlet.extra.Database;
 
public class ProdutoDao {
 
    private Connection connection;
 
    public ProdutoDao() {
        connection = Database.getConnection();
    }
 

    public void addProduto(Produto produto) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into PRODUTO (VALOR, CATEGORIA, NOME, DESCRICAO) values ( ?, ?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setFloat(1, produto.getValor());
            preparedStatement.setInt(2,0);//preparedStatement.setInt(2, user.getcategoria().getId());            
            preparedStatement.setString(3, produto.getNome());
            preparedStatement.setString(4, produto.getDescricao());
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public void deleteProduto(Produto produto) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from PRODUTO where ID=?");
            // Parameters start with 1
            preparedStatement.setInt(1, produto.getId());
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public void updateProuto(Produto produto) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update PRODUTO set VALOR=?, CATEGORIA=? ,NOME=?, DESCRICAO=?"
                    + "where ID=?");
            // Parameters start with 1
            
            preparedStatement.setFloat(1, produto.getValor());
            preparedStatement.setInt(2, 0);//preparedStatement.setint(2, produto.getCategoria());
            preparedStatement.setString(3, produto.getNome());
            preparedStatement.setString(4, produto.getDescricao());
            preparedStatement.setInt(5, produto.getId());
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public List<Produto> getProdutos() {
        List<Produto> produtos = new ArrayList<Produto>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from PRODUTOS");
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("ID"));
                produto.setValor(rs.getFloat("VALOR"));
                //produto.setCategoria(CategoriaDao.getCategoria(rs.getInt("CATEGORIA")));
                produto.setNome(rs.getString("NOME"));
                produto.setDescricao(rs.getString("DESCRICAO"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return produtos;
    }
 
    public Produto getProduto(String Id) {
        Produto produto = new Produto();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from PRODUTO where ID=?");
            preparedStatement.setString(1, Id);
            ResultSet rs = preparedStatement.executeQuery();
 
            if (rs.next()) {
                produto.setId(rs.getInt("ID"));
                produto.setValor(rs.getFloat("VALOR"));
                //produto.setCategoria(CategoriaDao.getCategoria(rs.getInt("CATEGORIA")));
                produto.setNome(rs.getString("NOME"));
                produto.setDescricao(rs.getString("DESCRICAO"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return produto;
    }
}
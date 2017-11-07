package br.servlet.dao;
 
import java.sql.*;
import java.util.*;
import br.servlet.model.Compra;
import br.servlet.extra.Database;
import br.servlet.dao.ClienteDao;
import br.servlet.dao.ProdutoDao;

 
public class CompraDao {
 
    private Connection connection;
    private ClienteDao cliDao;
    private ProdutoDao prodDao;
 
    public CompraDao() {
        connection = Database.getConnection();
        cliDao = new ClienteDao();
        prodDao = new ProdutoDao();
    }
 

    public void addCompra(Compra compra) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into COMPRA (CLIENTE, PRODUTO) values ( ?, ? )");
            // Parameters start with 1
            preparedStatement.setInt(1, compra.getCliente().getId());
            preparedStatement.setInt(2, compra.getProduto().getId());
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public void deleteCompra(Compra compra) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from COMPRA where ID=?");
            // Parameters start with 1
            preparedStatement.setInt(1, compra.getId());
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public void updateProuto(Compra compra) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update COMPRA set CLIENTE=?, PRODUTO=?"
                    + "where ID=?");
            // Parameters start with 1
            
            preparedStatement.setInt(1, compra.getCliente().getId());
            preparedStatement.setInt(2, compra.getProduto().getId());
            preparedStatement.setInt(3, compra.getId());
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public List<Compra> getCompras() {
        List<Compra> compras = new ArrayList<Compra>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from COMPRAS");
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setId(rs.getInt("ID"));
                compra.setCliente(cliDao.getCliente(rs.getInt("CLIENTE")));
                compra.setProduto(prodDao.getProduto(rs.getInt("PRODUTO")));
                compras.add(compra);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return compras;
    }
 
    public Compra getCompra(int Id) {
        Compra compra = new Compra();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from COMPRA where ID=?");
            preparedStatement.setInt(1, Id);
            ResultSet rs = preparedStatement.executeQuery();
 
            if (rs.next()) {
                compra.setId(rs.getInt("ID"));
                compra.setCliente(cliDao.getCliente(rs.getInt("CLIENTE")));
                compra.setProduto(prodDao.getProduto(rs.getInt("PRODUTO")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return compra;
    }
}
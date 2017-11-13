package br.servlet.dao;
 
import java.sql.*;
import java.util.*;
import br.servlet.model.Cliente;
import br.servlet.extra.Database;
 
public class ClienteDao {
 
    private Connection connection;
 
    public ClienteDao() {
        connection = Database.getConnection();
    }
 

    public void addCliente(Cliente cliente) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into CLIENTE (NOME, ENDERECO, CEP, ESTADO, REFERENCIA, CPF, RG, TELEFONE, CELULAR, CARTAO, BANDEIRA) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getEndereco());
            preparedStatement.setString(3, cliente.getCep());
            preparedStatement.setString(4, cliente.getEstado());
            preparedStatement.setString(5, cliente.getReferencia());
            preparedStatement.setString(6, cliente.getCpf());
            preparedStatement.setString(7, cliente.getRg());
            preparedStatement.setString(8, cliente.getTelefone());
            preparedStatement.setString(9, cliente.getCelular());
            preparedStatement.setString(10, cliente.getCartao());
            preparedStatement.setString(11, cliente.getBandeira());
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public void deleteCliente(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from CLIENTE where ID=?");
            // Parameters start with 1
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public void updateProuto(Cliente cliente) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update CLIENTE set NOME=? , ENDERECO=?, CEP=?, ESTADO=?, REFERENCIA=?, CPF=?, RG=?, TELEFONE=?, CELULAR=?, CARTAO=?, BANDEIRA=?"
                    + "where ID=?");
            // Parameters start with 1
            
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getEndereco());
            preparedStatement.setString(3, cliente.getCep());
            preparedStatement.setString(4, cliente.getEstado());
            preparedStatement.setString(5, cliente.getReferencia());
            preparedStatement.setString(6, cliente.getCpf());
            preparedStatement.setString(7, cliente.getRg());
            preparedStatement.setString(8, cliente.getTelefone());
            preparedStatement.setString(9, cliente.getCelular());
            preparedStatement.setString(10, cliente.getCartao());
            preparedStatement.setString(11, cliente.getBandeira());
            preparedStatement.setInt(12, cliente.getId());
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from CLIENTES");
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("ID"));
                cliente.setEndereco(rs.getString("ENDERECO"));
                cliente.setCep(rs.getString("CEP"));
                cliente.setNome(rs.getString("NOME"));
                cliente.setEstado(rs.getString("ESADO"));
                cliente.setReferencia(rs.getString("REFERENCIA"));
                cliente.setCpf(rs.getString("CPF"));
                cliente.setRg(rs.getString("RG"));
                cliente.setTelefone(rs.getString("TELEFONE"));
                cliente.setCelular(rs.getString("CELULAR"));
                cliente.setCartao(rs.getString("CARTAO"));
                cliente.setBandeira(rs.getString("BANDEIRA"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return clientes;
    }
 
    public Cliente getCliente(int Id) {
        Cliente cliente = new Cliente();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from CLIENTE where ID=?");
            preparedStatement.setInt(1, Id);
            ResultSet rs = preparedStatement.executeQuery();
 
            if (rs.next()) {
                cliente.setId(rs.getInt("ID"));
                cliente.setEndereco(rs.getString("ENDERECO"));
                cliente.setCep(rs.getString("CEP"));
                cliente.setNome(rs.getString("NOME"));
                cliente.setEstado(rs.getString("ESADO"));
                cliente.setReferencia(rs.getString("REFERENCIA"));
                cliente.setCpf(rs.getString("CPF"));
                cliente.setRg(rs.getString("RG"));
                cliente.setTelefone(rs.getString("TELEFONE"));
                cliente.setCelular(rs.getString("CELULAR"));
                cliente.setCartao(rs.getString("CARTAO"));
                cliente.setBandeira(rs.getString("BANDEIRA"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return cliente;
    }
}
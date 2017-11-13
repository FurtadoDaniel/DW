package br.servlet.controller;
 
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import br.servlet.dao.ClienteDao;
import br.servlet.model.Cliente;
 
public class ClienteController extends HttpServlet {
    private ClienteDao dao;
 
    public ClienteController() {
        super();
        dao = new ClienteDao();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        
        if (!request.getParameterMap().containsKey("id")) {
            request.setAttribute("clientees", dao.getClientes());
            request.getRequestDispatcher("/tabelaCliente.jsp").forward(request, response);
        }
        
        else if(request.getParameter("id") == "0"){
            request.setAttribute("cliente", new Cliente());
            request.getRequestDispatcher("/jsp.jsp").forward(request, response);
        }
        
        else {
            request.setAttribute("cliente", dao.getCliente(Integer.parseInt(request.getParameter("id"))));
            request.getRequestDispatcher("/jsp.jsp").forward(request, response);
        }
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cliente cliente = new Cliente();
        cliente.setNome(request.getParameter("nome"));
        cliente.setEndereco(request.getParameter("endereco"));
        cliente.setCep(request.getParameter("cep"));
        cliente.setEstado(request.getParameter("estado"));
        cliente.setReferencia(request.getParameter("referencia"));
        cliente.setCpf(request.getParameter("cpf"));
        cliente.setRg(request.getParameter("rg"));
        cliente.setTelefone(request.getParameter("telefone"));
        cliente.setCelular(request.getParameter("celular"));
        cliente.setCartao(request.getParameter("cartao"));
        cliente.setBandeira(request.getParameter("bandeira"));
        if (request.getParameter("id") == "0"){
            dao.addCliente(cliente);
        }
        else {
            dao.updateProuto(cliente);
        }
        
        request.setAttribute("clientees", dao.getClientes());
        request.getRequestDispatcher("/jsp.jsp").forward(request, response);
    }
    
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        dao.deleteCliente(Integer.parseInt(request.getParameter("id")));
       
        request.setAttribute("clientees", dao.getClientes());
        request.getRequestDispatcher("/jsp.jsp").forward(request, response);
    }
}
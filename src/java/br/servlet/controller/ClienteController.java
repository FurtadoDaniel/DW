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
            request.setAttribute("clientes", dao.getClientes());
            request.getRequestDispatcher("/tabelaCliente.jsp").forward(request, response);
        }
        
        else if("0".equals(request.getParameter("id"))){
            request.setAttribute("cliente", new Cliente());
            request.getRequestDispatcher("/formCliente.jsp").forward(request, response);
        }
        
        else {
            request.setAttribute("cliente", dao.getCliente(Integer.parseInt(request.getParameter("id"))));
            request.getRequestDispatcher("/formCliente.jsp").forward(request, response);
        }
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        if(!request.getParameterMap().containsKey("deleta_id")){
        
            Cliente cliente = new Cliente();
            String nome = request.getParameter("nome");
            String end = request.getParameter("endereco");
            String cep = request.getParameter("cep");
            String est = request.getParameter("estado");
            String ref = request.getParameter("referencia");
            String cpf = request.getParameter("cpf");
            String rg = request.getParameter("rg");
            String tel = request.getParameter("telefone");
            String cel = request.getParameter("celular");
            String cart = request.getParameter("cartao");
            String band = request.getParameter("bandeira");
            
            cliente.setNome(nome);
            cliente.setEndereco(end);
            cliente.setCep(cep);
            cliente.setEstado(est);
            cliente.setReferencia(ref);
            cliente.setCpf(cpf);
            cliente.setRg(rg);
            cliente.setTelefone(tel);
            cliente.setCelular(cel);
            cliente.setCartao(cart);
            cliente.setBandeira(band);
            
            if ("0".equals(request.getParameter("id"))){
                dao.addCliente(cliente);
            }
            else {
                String id = request.getParameter("id");
                cliente.setId(Integer.parseInt(id));
                dao.updateCliente(cliente);
            }
        }
        
        else {
            String deleta = request.getParameter("deleta_id");
            dao.deleteCliente(Integer.parseInt(deleta));
        }
        
        request.setAttribute("clientes", dao.getClientes());
        request.getRequestDispatcher("/tabelaCliente.jsp").forward(request, response);
    }
}
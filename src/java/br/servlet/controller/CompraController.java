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
 
import br.servlet.dao.CompraDao;
import br.servlet.model.Compra;

import br.servlet.dao.ClienteDao;
import br.servlet.dao.ProdutoDao;
 
public class CompraController extends HttpServlet {
    private CompraDao dao;
    private ClienteDao cli_dao;
    private ProdutoDao prod_dao;
 
    public CompraController() {
        super();
        dao = new CompraDao();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        
        if (!request.getParameterMap().containsKey("id")) {
            request.setAttribute("compraes", dao.getCompras());
            request.getRequestDispatcher("/tabelaCompra.jsp").forward(request, response);
        }
        
        else if(request.getParameter("id") == "0"){
            request.setAttribute("compra", new Compra());
            request.getRequestDispatcher("/jsp.jsp").forward(request, response);
        }
        
        else {
            request.setAttribute("compra", dao.getCompra(Integer.parseInt(request.getParameter("id"))));
            request.getRequestDispatcher("/jsp.jsp").forward(request, response);
        }
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Compra compra = new Compra();
        compra.setCliente(cli_dao.getCliente(Integer.parseInt(request.getParameter("cliente"))));
        compra.setProduto(prod_dao.getProduto(Integer.parseInt(request.getParameter("produto"))));
        if (request.getParameter("id") == "0"){
            dao.addCompra(compra);
        }
        else {
            dao.updateProuto(compra);
        }
        
        request.setAttribute("compraes", dao.getCompras());
        request.getRequestDispatcher("/jsp.jsp").forward(request, response);
    }
    
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        dao.deleteCompra(Integer.parseInt(request.getParameter("id")));
       
        request.setAttribute("compraes", dao.getCompras());
        request.getRequestDispatcher("/jsp.jsp").forward(request, response);
    }
}
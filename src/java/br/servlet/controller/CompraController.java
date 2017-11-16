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
        cli_dao = new ClienteDao();
        prod_dao = new ProdutoDao();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        
        if (!request.getParameterMap().containsKey("id")) {
            request.setAttribute("compras", dao.getCompras());
            request.getRequestDispatcher("/tabelaCompras.jsp").forward(request, response);
        }
        
        else if("0".equals(request.getParameter("id"))){
            request.setAttribute("produtos", prod_dao.getProdutos());
            request.setAttribute("clientes", cli_dao.getClientes());
            request.setAttribute("compra", new Compra());
            request.getRequestDispatcher("/formCompra.jsp").forward(request, response);
        }
        
        else {
            
            request.setAttribute("produtos", prod_dao.getProdutos());
            request.setAttribute("clientes", cli_dao.getClientes());
            request.setAttribute("compra", dao.getCompra(Integer.parseInt(request.getParameter("id"))));
            request.getRequestDispatcher("/formCompra.jsp").forward(request, response);
        }
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        if(!request.getParameterMap().containsKey("deleta_id")){
        
            Compra compra = new Compra();
            String cli = request.getParameter("cliente");
            String prod = request.getParameter("produto");
            compra.setCliente(cli_dao.getCliente(Integer.parseInt(cli)));
            compra.setProduto(prod_dao.getProduto(Integer.parseInt(prod)));
            if ("0".equals(request.getParameter("id"))){
                dao.addCompra(compra);
            }
            else {
                String id = request.getParameter("id");
                compra.setId(Integer.parseInt(id));
                dao.updateCompra(compra);
            }
        }
        
        else {
            dao.deleteCompra(Integer.parseInt(request.getParameter("deleta_id")));
        }
        
        request.setAttribute("compras", dao.getCompras());
        request.getRequestDispatcher("/tabelaCompras.jsp").forward(request, response);
    }
}
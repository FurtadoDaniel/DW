package br.servlet.controller;

import br.servlet.dao.CategoriaDao;
import br.servlet.dao.ProdutoDao;
import br.servlet.model.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CarrinhoController extends HttpServlet {


    private ProdutoDao dao;
    private CategoriaDao cat_dao;
 
    public CarrinhoController() {
        super();
        dao = new ProdutoDao();
        cat_dao = new CategoriaDao();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        request.setAttribute("carrinho", (List<Produto>) session.getAttribute("carrinho"));
        request.getRequestDispatcher("/carrinho.jsp").forward(request, response);
        
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setAttribute("cliente", null);
        request.getRequestDispatcher("/formCliente.jsp").forward(request, response);
    }
    
}
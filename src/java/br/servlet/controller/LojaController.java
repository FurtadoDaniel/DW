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


public class LojaController extends HttpServlet {


    private ProdutoDao dao;
    private CategoriaDao cat_dao;
 
    public LojaController() {
        super();
        dao = new ProdutoDao();
        cat_dao = new CategoriaDao();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        
        request.setAttribute("categorias", cat_dao.getCategorias());
        
        if (!request.getParameterMap().containsKey("filtro")) {
            request.setAttribute("produtos", dao.getProdutos(request.getParameter("filtro")));
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        
        else if (!request.getParameterMap().containsKey("categoria")) {
            request.setAttribute("produtos", dao.getProdutos(request.getParameter("categoria")));
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        
        else {
            request.setAttribute("produtos", dao.getProdutos());
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        List<Produto> produtos = new ArrayList<Produto>();
        produtos = null;
        Object carrinho = session.getAttribute("carrinho");
        if (carrinho != null) {
            produtos = (List<Produto>) carrinho;
        }
        produtos.add(dao.getProduto(Integer.parseInt(request.getParameter("produto"))));
        session.setAttribute("carrinho", produtos);
        request.getRequestDispatcher("/carrinho.jsp").forward(request, response);
    }
    
}
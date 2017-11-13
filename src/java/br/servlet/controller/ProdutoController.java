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
 
import br.servlet.dao.ProdutoDao;
import br.servlet.model.Produto;

import br.servlet.dao.CategoriaDao;
 
public class ProdutoController extends HttpServlet {
    private ProdutoDao dao;
    private CategoriaDao cat_dao;
 
    public ProdutoController() {
        super();
        dao = new ProdutoDao();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        
        if (!request.getParameterMap().containsKey("id")) {
            request.setAttribute("produtoes", dao.getProdutos());
            request.getRequestDispatcher("/tabelaProduto.jsp").forward(request, response);
        }
        
        else if(request.getParameter("id") == "0"){
            request.setAttribute("produto", new Produto());
            request.getRequestDispatcher("/jsp.jsp").forward(request, response);
        }
        
        else {
            request.setAttribute("produto", dao.getProduto(Integer.parseInt(request.getParameter("id"))));
            request.getRequestDispatcher("/jsp.jsp").forward(request, response);
        }
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Produto produto = new Produto();
        produto.setValor(Float.parseFloat(request.getParameter("valor")));
        produto.setCategoria(cat_dao.getCategoria(Integer.parseInt(request.getParameter("categoria"))));
        produto.setNome(request.getParameter("nome"));
        produto.setDescricao(request.getParameter("descricao"));
        if (request.getParameter("id") == "0"){
            dao.addProduto(produto);
        }
        else {
            dao.updateProuto(produto);
        }
        
        request.setAttribute("produtoes", dao.getProdutos());
        request.getRequestDispatcher("/jsp.jsp").forward(request, response);
    }
    
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        dao.deleteProduto(Integer.parseInt(request.getParameter("id")));
       
        request.setAttribute("produtoes", dao.getProdutos());
        request.getRequestDispatcher("/jsp.jsp").forward(request, response);
    }
}
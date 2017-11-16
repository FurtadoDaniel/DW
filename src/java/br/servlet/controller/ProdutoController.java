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
        cat_dao = new CategoriaDao();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        
        if (!request.getParameterMap().containsKey("id")) {
            request.setAttribute("produtos", dao.getProdutos());
            request.getRequestDispatcher("/tabelaProduto.jsp").forward(request, response);
        }
        
        else if("0".equals(request.getParameter("id"))){
            request.setAttribute("categorias", cat_dao.getCategorias());
            request.setAttribute("produto", new Produto());
            request.getRequestDispatcher("/formProduto.jsp").forward(request, response);
        }
        
        else {
            request.setAttribute("categorias", cat_dao.getCategorias());
            request.setAttribute("produto", dao.getProduto(Integer.parseInt(request.getParameter("id"))));
            request.getRequestDispatcher("/formProduto.jsp").forward(request, response);
        }
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        if(!request.getParameterMap().containsKey("deleta_id")){
        
            Produto produto = new Produto();
            String desc = request.getParameter("descricao");
            String nome = request.getParameter("nome");
            String cat = request.getParameter("categoria");
            String val = request.getParameter("valor");
            produto.setDescricao(desc);
            produto.setCategoria(cat_dao.getCategoria(Integer.parseInt(cat)));
            produto.setNome(nome);
            produto.setValor(Float.parseFloat(val.replace(',', '.')));
            if ("0".equals(request.getParameter("id"))){
                dao.addProduto(produto);
            }
            else {
                String id = request.getParameter("id");
                produto.setId(Integer.parseInt(id));
                dao.updateProduto(produto);
            }
        }
        
        else {
            dao.deleteProduto(Integer.parseInt(request.getParameter("deleta_id")));
        }
        
        request.setAttribute("produtos", dao.getProdutos());
        request.getRequestDispatcher("/tabelaProduto.jsp").forward(request, response);
    }
    
}
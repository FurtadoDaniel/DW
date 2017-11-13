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
 
import br.servlet.dao.CategoriaDao;
import br.servlet.model.Categoria;
 
public class CategoriaController extends HttpServlet {
    private CategoriaDao dao;
 
    public CategoriaController() {
        super();
        dao = new CategoriaDao();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        
        if (!request.getParameterMap().containsKey("id")) {
            request.setAttribute("categoriaes", dao.getCategorias());
            request.getRequestDispatcher("/tabelaCategoria.jsp").forward(request, response);
        }
        
        else if(request.getParameter("id") == "0"){
            request.setAttribute("categoria", new Categoria());
            request.getRequestDispatcher("/jsp.jsp").forward(request, response);
        }
        
        else {
            request.setAttribute("categoria", dao.getCategoria(Integer.parseInt(request.getParameter("id"))));
            request.getRequestDispatcher("/jsp.jsp").forward(request, response);
        }
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Categoria categoria = new Categoria();
        categoria.setDescricao(request.getParameter("descricao"));
        if (request.getParameter("id") == "0"){
            dao.addCategoria(categoria);
        }
        else {
            dao.updateProuto(categoria);
        }
        
        request.setAttribute("categoriaes", dao.getCategorias());
        request.getRequestDispatcher("/jsp.jsp").forward(request, response);
    }
    
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        dao.deleteCategoria(Integer.parseInt(request.getParameter("id")));
       
        request.setAttribute("categoriaes", dao.getCategorias());
        request.getRequestDispatcher("/jsp.jsp").forward(request, response);
    }
}
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
            request.setAttribute("categorias", dao.getCategorias());
            request.getRequestDispatcher("/tabelaCategoria.jsp").forward(request, response);
        }
        
        else if("0".equals(request.getParameter("id"))){
            request.setAttribute("categoria", new Categoria());
            request.getRequestDispatcher("/formCategoria.jsp").forward(request, response);
        }
        
        else {
            request.setAttribute("categoria", dao.getCategoria(Integer.parseInt(request.getParameter("id"))));
            request.getRequestDispatcher("/formCategoria.jsp").forward(request, response);
        }
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        if(!request.getParameterMap().containsKey("deleta_id")){
        
            Categoria categoria = new Categoria();
            String desc = request.getParameter("descricao");
            categoria.setDescricao(desc);
            if ("0".equals(request.getParameter("id"))){
                System.out.println(categoria.getDescricao());
                dao.addCategoria(categoria);
            }
            else {
                String id = request.getParameter("id");
                categoria.setId(Integer.parseInt(id));
                dao.updateCategoria(categoria);
            }
        }
        
        else {
            dao.deleteCategoria(Integer.parseInt(request.getParameter("deleta_id")));
        }
        
        request.setAttribute("categorias", dao.getCategorias());
        request.getRequestDispatcher("/tabelaCategoria.jsp").forward(request, response);
    }
}
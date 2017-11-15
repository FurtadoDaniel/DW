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
 
import br.servlet.dao.AdministradorDao;
import br.servlet.model.Administrador;



public class AdministradorController extends HttpServlet {
    private AdministradorDao dao;
 
    public AdministradorController() {
        super();
        dao = new AdministradorDao();
    }
 
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

          
        
        
        if (!request.getParameterMap().containsKey("id")) {
            request.setAttribute("administradores", dao.getAdministradors());
            request.getRequestDispatcher("/tabelaAdministrador.jsp").forward(request, response);
        }
        
        else { 
            if(request.getParameter("id") == "0"){
                request.setAttribute("administrador", new Administrador());
                request.getRequestDispatcher("/formAdm.jsp").forward(request, response);
            }

            else {
                request.setAttribute("administrador", dao.getAdministrador(Integer.parseInt(request.getParameter("id"))));
                request.getRequestDispatcher("/formAdm.jsp").forward(request, response);
            }
        }
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Administrador administrador = new Administrador();
        administrador.setUsuario(request.getParameter("usuario"));
        administrador.setSenha(request.getParameter("senha"));
        if (request.getParameter("id") == "0"){
            dao.addAdministrador(administrador);
        }
        else {
            dao.updateProuto(administrador);
        }
        
        request.setAttribute("administradores", dao.getAdministradors());
        request.getRequestDispatcher("/tabelaAdministrador.jsp").forward(request, response);
    }
    
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        dao.deleteAdministrador(Integer.parseInt(request.getParameter("id")));
       
        request.setAttribute("administradores", dao.getAdministradors());
        request.getRequestDispatcher("/tabelaAdministrador.jsp").forward(request, response);
    }
}
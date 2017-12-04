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
import javax.servlet.http.HttpSession;



public class AdministradorController extends HttpServlet {
    private AdministradorDao dao;
 
    public AdministradorController() {
        super();
        this.dao = new AdministradorDao();
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
            
        if(!request.getParameterMap().containsKey("deleta_id")){
        
            Administrador administrador = new Administrador();
            String user = request.getParameter("user");
            String pass = request.getParameter("senha");
            administrador.setUsuario(user);
            administrador.setSenha(pass);
            if ("0".equals(request.getParameter("id"))){
                dao.addAdministrador(administrador);
            }
            else {
                String id = request.getParameter("id");
                administrador.setId(Integer.parseInt(id));
                dao.updateAdministrador(administrador);
            }
        }
        
        else {
            dao.deleteAdministrador(Integer.parseInt(request.getParameter("deleta_id")));
        }
        
        HttpSession sessao = request.getSession();
        Object logado = sessao.getAttribute("adm");
        if (logado != null) {
            String aux = (String) logado;
            if (aux.equals("logado")) {
                request.setAttribute("administradores", dao.getAdministradors());
                request.getRequestDispatcher("/tabelaAdministrador.jsp").forward(request, response);
            }
            else {
                response.sendRedirect("/Sucesso.jsp");
            }
        }
        
        else {
           response.sendRedirect("/Sucesso.jsp"); 
        }
        
        
    }
}
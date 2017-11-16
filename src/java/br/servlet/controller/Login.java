
package br.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.servlet.dao.AdministradorDao;

public class Login extends HttpServlet {
    
    AdministradorDao dao = new AdministradorDao();;
    

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.sendRedirect("index.jsp");
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id_user = dao.getAdministrador(request.getParameter("user"), request.getParameter("password"));
        
        if ( id_user == 0) {
            response.sendRedirect("index.jsp");
            
            
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("adm", "logado");
            
            response.sendRedirect("homeAdm.jsp");
        }
    }

}

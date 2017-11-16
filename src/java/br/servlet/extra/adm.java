package br.servlet.extra;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class adm implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpSession sessao = ((HttpServletRequest) request).getSession(true);
        Object logado = sessao.getAttribute("adm");
        if (logado != null) {
            String aux = (String) logado;
            if (aux.equals("logado")) {
                chain.doFilter(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                rd.forward(request, response);
            }
        } else {

            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);

        }
    }

    @Override
    public void destroy() {  }

    @Override
    public void init(FilterConfig filterConfig) {   

    }







}

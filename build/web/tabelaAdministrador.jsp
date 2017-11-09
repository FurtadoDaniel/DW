<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.servlet.model.Administrador"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" type="text/css" href="style.css">

        <title>Administrador</title>
    </head>

    <body>
        <table>
            <thead>
                <th>Login</th>
                <th>Senha</th>
                <th>Excluir</th>
            </thead>

            <tbody>
                <%
                    ArrayList<Administrador> resultado = (ArrayList) request.getAttribute("administradores");
                    for (int i = 0; i < resultado.size(); i++) {
                        Administrador aux = (Administrador)resultado.get(i);
                    
                %>
                <tr>
                    
                    <td><%=aux.getUsuario()%></td>
                    <td><%=aux.getSenha()%></td>
                    <td>
                        <form action="AdministradorController" method="delete" name="deletar" id="del" autocomplete="off">
                             <input type="hidden" name="id" value="<%=aux.getId()%>">
                             <input type="submit" id="nocss" value="Deletar" >
                        </form>
                    </td>
                </tr>
                <%
                    }
                %>

        </table>
    </body>
</html>
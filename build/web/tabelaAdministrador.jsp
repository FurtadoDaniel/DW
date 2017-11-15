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
                <tr>
                    <th colspan="3"><div name="topnav" id="topnav">
                        <a href="tabelaAdministrador.jsp">Adms</a>
                        <a href="tabelaCategoria.jsp">Categorias</a>
                        <a href="tabelaCliente.jsp">Clientes</a>
                        <a href="tabelaCompras.jsp">Compras</a>
                        <a href="tabelaProduto.jsp">Produtos</a>
                    </div></th>
                </tr>
                <tr>
                    <th>Id</th>
                    <th>Login</th>
                    <th>Senha</th>
                    <th>Excluir</th>
                </tr>
            </thead>

            <tbody>
                <%
                    ArrayList<Administrador> resultado = (ArrayList) request.getAttribute("administradores");
                    for (int i = 0; i < resultado.size(); i++) {
                        Administrador aux = (Administrador)resultado.get(i);

                %>
                <tr>
                    <td><a href="administrador?id=<%=aux.getId()%>"><%=aux.getId()%></a></td>
                    <td><%=aux.getUsuario()%></td>
                    <td><%=aux.getSenha()%></td>
                    <td>
                        <form action="/adm/administrador" method="post" name="deletar" id="del" autocomplete="off">
                             <input type="hidden" name="deleta_id" value="<%=aux.getId()%>">
                             <input type="submit" id="nocss" value="Deletar" >
                        </form>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>

            <tfoot>
                <th></th><th></th>
                <th><a href="/adm/administrador?id=0">Adcionar</a></th>
            </tfoot>
        </table>
    </body>
</html>

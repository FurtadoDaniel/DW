<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.servlet.model.Categoria"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" type="text/css" href="/style.css">

        <title>Categorias</title>
    </head>

    <body>
        <table>
            <thead>
                <tr>
                    <th colspan="4"><div name="topnav" id="topnav">
                        <a href="/adm/administrador">Adms</a>
                        <a href="/adm/categoria">Categorias</a>
                        <a href="/adm/cliente">Clientes</a>
                        <a href="/adm/compra">Compras</a>
                        <a href="/adm/produto">Produtos</a>
                    </div></th>
                </tr>
                <tr>
                    <th>Id</th>
                    <th>Descricao</th>
                    <th>Excluir</th>
                </tr>
            </thead>

            <tbody>
                <%
                    ArrayList<Categoria> resultado = (ArrayList) request.getAttribute("categorias");
                    for (int i = 0; i < resultado.size(); i++) {
                        Categoria aux = (Categoria)resultado.get(i);

                %>
                <tr>
                    <td><a href="/adm/categoria?id=<%=aux.getId()%>"><%=aux.getId()%></a></td>
                    <td><%=aux.getDescricao()%></td>
                    <td>
                        <form action="/adm/categoria" method="post" name="deletar" id="del" autocomplete="off">
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
                <th><a href="/adm/categoria?id=0">Adcionar</a></th>
            </tfoot>
        </table>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.servlet.model.Compra"%>
<%@page import="br.servlet.model.Produto"%>
<%@page import="br.servlet.model.Cliente"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" type="text/css" href="style.css">

        <title>Compras</title>
    </head>

    <body>
        <table>
            <thead>
                <tr>
                    <th colspan="3"><div name="topnav" id="topnav">
                        <a href="/adm/administrador">Adms</a>
                        <a href="/adm/categoria">Categorias</a>
                        <a href="/adm/cliente">Clientes</a>
                        <a href="/adm/compra">Compras</a>
                        <a href="/adm/produto">Produtos</a>
                    </div></th>
                </tr>
                <tr>
                    <th>Id</th>
                    <th>Cliente</th>
                    <th>Produto</th>
                    <th>Excluir</th>
                </tr>
            </thead>

            <tbody>
                <%
                    ArrayList<Compra> resultado = (ArrayList) request.getAttribute("compras");
                    for (int i = 0; i < resultado.size(); i++) {
                        Compra aux = (Compra)resultado.get(i);

                %>
                <tr>
                    <td><a href="/adm/compra?id=<%=aux.getId()%>"><%=aux.getId()%></a></td>
                    <td><%=aux.getCliente().getNome()%></td>
                    <td><%=aux.getProduto().getNome()%></td>
                    <td>
                        <form action="/adm/compra" method="post" name="deletar" id="del" autocomplete="off">
                             <input type="hidden" name="deleta_id" value="<%=aux.getId()%>">
                             <input type="submit" id="nocss" value="Deletar" >
                        </form>
                    </td>
                </tr>
                <%
                    }
                %>

        </table>
    </body>
    <tfoot>
                <th></th><th></th>
                <th><a href="/adm/compra?id=0">Adicionar</a></th>
    </tfoot>
</html>

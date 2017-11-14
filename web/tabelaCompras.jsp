<!DOCTYPE html>
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
                        <a href="tabelaAdministrador.jsp">Adms</a>
                        <a href="tabelaCategoria.jsp">Categorias</a>
                        <a href="tabelaCliente.jsp">Clientes</a>
                        <a href="tabelaCompras.jsp">Compras</a>
                        <a href="tabelaProduto.jsp">Produtos</a>
                    </div></th>
                </tr>
                <tr>
                    <th>Id</th>
                    <th>IdCliente</th>
                    <th>IdProduto</th>
                </tr>
            </thead>

            <tbody>
                <%
                    <!-- codigo java aqui -->
                %>
                <tr>
                    <td><%=aux.getId()%></td>
                    <td><%=aux.getIdCliente()%></td>
                    <td><%=aux.getIdProduto()%></td>
                </tr>
                <%
                    }
                %>

        </table>
    </body>
</html>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" type="text/css" href="style.css">

        <title>Produto</title>
    </head>

    <body>
        <table>
            <thead>
                <th>Id</th>
                <th>IdCategoria</th>
                <th>Nome</th>
                <th>Descrição</th>
                <th>Valor</th>
            </thead>

            <tbody>
                <%
                    <!-- codigo java aqui -->
                %>
                <tr>
                    <td><%=aux.getId()%></td>
                    <td><%=aux.getIdCategoria()%></td>
                    <td><%=aux.getNome()%></td>
                    <td><%=aux.getDescription()%></td>
                    <td><%=aux.getValor()%></td>
                </tr>
                <%
                    }
                %>

        </table>
    </body>
</html>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" type="text/css" href="style.css">

        <title>Categorias</title>
    </head>

    <body>
        <table>
            <thead>
                <th>Id</th>
                <th>Descrição</th>
            </thead>

            <tbody>
                <%
                    <!-- codigo java aqui -->
                %>
                <tr>
                    <td><%=aux.getId()%></td>
                    <td><%=aux.getDescription()%></td>
                </tr>
                <%
                    }
                %>
                
        </table>
    </body>
</html>

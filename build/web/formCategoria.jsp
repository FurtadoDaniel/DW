<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.servlet.model.Categoria"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" type="text/css" href="/style.css">

        <script type="text/javascript" src="validacao.js"></script>

        <title>Cadastro | Categoria</title>
    </head>

    <body>
        <form  action="categoria" method="post"  name="produto" id="produto" autocomplete="on">
            <%
                   Categoria aux = (Categoria) request.getAttribute("categoria");

                %>
				<table>
                    <tr hidden>
						<th>Id:</th>
						<th><input type="number" name="id" id="id" placeholder="12345578" onchange="validarNum('id')" value="<%=aux.getId()%>"></th>
					</tr>
					<tr>
						<th>Descricao:</th>
						<th><input type="text" name="descricao" id="descricao"  onchange="validarAlphaNum('descricao')" value="<%=aux.getDescricao()%>"></th>
					</tr>
                    <tr>
						<th colspan="2" name="submit"><button type="submit" id="submit"  onclick="checkEmpty()">Enviar</button></th>
					</tr>

				</table>
        </form>

    </body>
</html>

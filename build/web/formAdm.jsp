<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.servlet.model.Administrador"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" type="text/css" href="/style.css">

        <script type="text/javascript" src="validacao.js"></script>

        <title>Cadastro | Administrador</title>
    </head>

    <body>
        <form action="administrador" method="post" name="produto" id="produto" autocomplete="on">
            <%
                   Administrador aux = (Administrador) request.getAttribute("administrador");

                %>
				<table>
                    <tr hidden>
						<th>Id:</th>
						<th><input type="number" name="id" id="id" placeholder="12345578" onchange="validarNum('id')" value="<%=aux.getId()%>"></th>
					</tr>
					<tr>
						<th>Login:</th>
						<th><input type="text" name="user" id="user" autofocus onchange="validarTexto('user')" value="<%=aux.getUsuario()%>"></th>
					</tr>
					<tr>
						<th>Senha:</th>
						<th><input type="password" name="senha" id="senha" onchange="validarNum('valor')" value="<%=aux.getSenha()%>"></th>
					</tr>
                    <tr>
						<th colspan="2" name="submit"><button type="submit" id="submit"  onclick="checkEmpty()">Enviar</button></th>
					</tr>

				</table>
        </form>

    </body>
</html>

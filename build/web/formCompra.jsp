<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.servlet.model.Compra"%>
<%@page import="br.servlet.model.Produto"%>
<%@page import="br.servlet.model.Cliente"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" type="text/css" href="/style.css">

        <script type="text/javascript" src="validacao.js"></script>

        <title>Cadastro | Categoria</title>
    </head>

    <body>
        <form  action="compra" method="post"  name="produto" id="produto" autocomplete="on">
            <%
                   Compra aux = (Compra) request.getAttribute("compra");

                %>
				<table>
                    <tr hidden>
						<th>Id:</th>
						<th><input type="number" name="id" id="id" placeholder="12345578" onchange="validarNum('id')" value="<%=aux.getId()%>"></th>
					</tr>
					<tr>
						<th> <select name ="cliente" value="<%=aux.getCliente()%>">
                                                        <%
                                                            ArrayList<Produto> produtos = (ArrayList) request.getAttribute("produtos");
                                                            for (int i = 0; i < produtos.size(); i++) {
                                                                Produto produto = (Produto) produtos.get(i);
                                                            
                                                                %> <option value="<%=produto.getId()%>"> <%=produto.getNome()%> </option> 
                                                            <% }%>
                                                      </select> 
                                                </th>
						<th> <select name ="produto" value="<%=aux.getProduto()%>">
                                                        <%
                                                            ArrayList<Cliente> clientes = (ArrayList) request.getAttribute("clientes");
                                                            for (int i = 0; i < produtos.size(); i++) {
                                                                Cliente cliente = (Cliente) clientes.get(i);
                                                            
                                                                %> <option value="<%=cliente.getId()%>"> <%=cliente.getNome()%> </option> 
                                                            <% }%>
                                                      </select> 
                                                </th>
					</tr>
                    <tr>
						<th colspan="2" name="submit"><button type="submit" id="submit"  onclick="checkEmpty()">Enviar</button></th>
					</tr>

				</table>
        </form>

    </body>
</html>

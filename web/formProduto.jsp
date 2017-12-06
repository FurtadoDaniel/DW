<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.servlet.model.Produto"%>
<%@page import="br.servlet.model.Categoria"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" type="text/css" href="/style.css">

        <script type="text/javascript" src="validacao.js"></script>

        <title>Cadastro | Produto</title>
    </head>

    <body>
        <form action="produto" method="post" name="produto" id="produto" autocomplete="on">
            
            <%
                   Produto aux = (Produto) request.getAttribute("produto");

                %>
				<table>
                    <tr hidden>
						<th>Id:</th>
						<th><input type="number" name="id" id="id" placeholder="12345578" onchange="validarNum('id')" value="<%=aux.getId()%>"></th>
					</tr>
					<tr>
						<th>Nome:</th>
						<th><input type="text" name="nome" id="nome" placeholder="ex.: Nome Produto" autofocus onchange="validarTexto('nome')" value="<%=aux.getNome()%>"></th>
					</tr>
					<tr>
						<th>DescriÃ§Ã£o:</th>
						<th><input type="text" name="descricao" id="descricao"  onchange="validarAlphaNum('descricao')" value="<%=aux.getDescricao()%>"></th>
					</tr>
					<tr>
						<th>Valor:</th>
						<th><input type="number" name="valor" id="valor" placeholder="ex.: 12345578" onchange="validarNum('valor')" value="<%=aux.getValor()%>"></th>
					</tr>
                                        <tr>
                                                <th> <select name="categoria" value="<%=aux.getCategoria()%>">
                                                        <%
                                                            ArrayList<Categoria> catagorias = (ArrayList) request.getAttribute("categorias");
                                                            for (int i = 0; i < catagorias.size(); i++) {
                                                                Categoria catagoria = (Categoria) catagorias.get(i);
                                                            
                                                                %> <option value="<%=catagoria.getId()%>"> <%=catagoria.getDescricao()%> </option> 
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

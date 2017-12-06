<%@page import="br.servlet.model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.servlet.model.Categoria"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" type="text/css" href="/style.css">

        <title>Loja DW</title>

    </head>

    <body>
        <table>
            <thead>
                <tr>
                    <th colspan="3"><div name="topnav" class="topnav">
                            
                        <%
                            ArrayList<Categoria> resultado = (ArrayList) request.getAttribute("categorias");
                            for (int i = 0; i < resultado.size(); i++) {
                                Categoria aux = (Categoria)resultado.get(i);

                        %>
                        <!-- Links do menu -->
                        <a href="/Loja?categoria=<%=aux.getId()%>"><%=aux.getDescricao()%></a>
                        <%
                            }
                        %>

                        <!-- login restrito -->
                        <div id="restrito"><a href="login.jsp">Área Restrita</a></div>
                    </div></th>
                </tr>
                <tr>
                    <th colspan="2"><div id="searchbar">
                        <tr>
                            <th><input type="text" placeholder="Pesquisar..."></th>
                            <th><button type="button">Pesquisar</button></th>
                            <th><input type="image" src="ÍCONES\carrinho.jpg" alt="Carrinho" id="imagem"></th>
                        </tr>
                    </div></th>
                </tr>
            </thead>

            <tbody>
                
                <tr>
                    
                        <%
                            ArrayList<Produto> saida = (ArrayList) request.getAttribute("produtos");
                            for (int i = 0; i < saida.size(); i++) {
                                Produto prd = (Produto)saida.get(i);

                        %>
                    
                        <td colspan="2"> <%=prd.getNome()%> <%=prd.getDescricao()%> - <%=prd.getValor()%> </td>
                        <form action="/Loja" method="post" name="addcarrinho" id="addcarrinho" autocomplete="off">
                             <input type="hidden" name="produto_id" value="<%=prd.getId()%>">
                             <input type="submit" id="nocss" value="COMPRAR" >
                        </form>
                        <%
                            }
                        %>
                </tr>
            </tbody>
        </table>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.servlet.model.Categoria"%>
<%@page import="br.servlet.model.Produto"%>
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
                            <form action="/Loja" method="get" name="addcarrinho" id="addcarrinho" autocomplete="off">
                                <th><input name="filtro" type="text" placeholder="Pesquisar..."></th>
                                <th><button  type="submit">Pesquisar</button></th>
                            </form>
                        <th><a href="/Carrinho"><input type="image" src="ÍCONES\carrinho.jpg" alt="Carrinho" id="imagem"></a></th>
                        </tr>
                    </div></th>
                </tr>
            </thead>

            <tbody>
                
                
                <%

                    ArrayList<Produto> saida = (ArrayList) request.getAttribute("produtos");
                    for (int i = 0; i < saida.size(); i++) {
                        Produto prd = (Produto)saida.get(i);

                %>
                
                <tr>
                        <td colspan="2"> <%=prd.getNome()%> <%=prd.getDescricao()%> - R$ <%=prd.getValor()%> </td>
                        <td><a><form action="/Loja" method="post" name="addcarrinho" id="addcarrinho" autocomplete="off">
                             <input type="hidden" name="produto" value="<%=prd.getId()%>">
                             <input type="submit" id="nocss" value="COMPRAR" >
                                </form></a></td>
                        
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>

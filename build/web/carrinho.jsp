<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.servlet.model.Produto"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" type="text/css" href="style.css">

        <title>Loja DW | Minhas Compras</title>

    </head>

    <body>
        <table>
            <thead>
                <tr>
                    <th colspan="2"><h3>Minhas Compras</h3></th>
                </tr>
            </thead>

            <tbody>
                <%
                    float total = 0;
                    ArrayList<Produto> saida = (ArrayList) request.getAttribute("carrinho");
                    for (int i = 0; i < saida.size(); i++) {
                        Produto prd = (Produto)saida.get(i);
                        total = total + prd.getValor();

                %>
                <tr>
                    <td><%=prd.getNome()%> <%=prd.getDescricao()%> - R$ <%=prd.getValor()%></td>
                    <td><form action="/Carrinho" method="post" name="deletar" id="del" autocomplete="off">
                             <input type="hidden" name="deleta_id" value="<%=prd.getId()%>">
                             <input type="submit" id="nocss" value="Remover" >
                        </form></td>
                </tr>
                <%
                    }
                %>
                <!-- apos listas todos os produtos -->
                <tr>
                    <td>Total da compra: R$ <%=total%></td>
            </tbody>

            <tfoot>
                <tr>
                    <td><form action="/Loja" method="get"> <input type="submit" id="nocss" value="Continuar Comprando" ></form></td>
                    <td><a href="/formNovoCliente.jsp"><button type="button">Finalizar Compra</button></a></td>
                </tr>
        </table>
    </body>
</html>

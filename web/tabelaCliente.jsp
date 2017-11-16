<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.servlet.model.Cliente"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" type="text/css" href="style.css">

        <title>Clientes</title>
    </head>

    <body>
        <table>
            <thead>
                <tr>
                    <th colspan="3"><div name="topnav" id="topnav">
                        <a href="/adm/administrador">Adms</a>
                        <a href="/adm/categoria">Categorias</a>
                        <a href="/adm/cliente">Clientes</a>
                        <a href="/adm/compra">Compras</a>
                        <a href="/adm/produto">Produtos</a>
                    </div></th>
                </tr>
                <tr>
                    <th>Id</th>
                    <th>Nome</th>
                    <th>Endereco</th>
                    <th>Cep</th>
                    <th>Estado(UF)</th>
                    <th>Referencia</th>
                    <th>CPF</th>
                    <th>RG</th>
                    <th>Telefone fixo</th>
                    <th>Celular</th>
                    <th>Num do cartao</th>
                    <th>Bandeira</th>
                    <th>Excluir</th>
                </tr>
            </thead>

            <tbody>
                <%
                    ArrayList<Cliente> resultado = (ArrayList) request.getAttribute("clientes");
                    for (int i = 0; i < resultado.size(); i++) {
                        Cliente aux = (Cliente)resultado.get(i);

                %>
                <tr>
                    <td><a href="/adm/cliente?id=<%=aux.getId()%>" ><%=aux.getId()%></a></td>
                    <td><%=aux.getNome()%></td>
                    <td><%=aux.getEndereco()%></td>
                    <td><%=aux.getCep()%></td>
                    <td><%=aux.getEstado()%></td>
                    <td><%=aux.getReferencia()%></td>
                    <td><%=aux.getCpf()%></td>
                    <td><%=aux.getRg()%></td>
                    <td><%=aux.getTelefone()%></td>
                    <td><%=aux.getCelular()%></td>
                    <td><%=aux.getCartao()%></td>
                    <td><%=aux.getBandeira()%></td>
                    <td>
                        <form action="/adm/cliente" method="post" name="deletar" id="del" autocomplete="off">
                             <input type="hidden" name="deleta_id" value="<%=aux.getId()%>">
                             <input type="submit" id="nocss" value="Deletar" >
                        </form>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>

            <tfoot>
                <th></th><th></th>
                <th><a href="/adm/cliente?id=0">Adcionar</a></th>
            </tfoot>
        </table>
    </body>
</html>

<!DOCTYPE html>
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
                        <a href="tabelaAdministrador.jsp">Adms</a>
                        <a href="tabelaCategoria.jsp">Categorias</a>
                        <a href="tabelaCliente.jsp">Clientes</a>
                        <a href="tabelaCompras.jsp">Compras</a>
                        <a href="tabelaProduto.jsp">Produtos</a>
                    </div></th>
                </tr>
                <tr>
                    <th>Id</th>
                    <th>Nome</th>
                    <th>Endereço</th>
                    <th>Bairro</th>
                    <th>Cidade</th>
                    <th>Cep</th>
                    <th>Estado(UF)</th>
                    <th>Referência</th>
                    <th>CPF</th>
                    <th>RG</th>
                    <th>Telefone fixo</th>
                    <th>Celular</th>
                    <th>Num do cartão</th>
                    <th>Bandeira</th>
                </tr>
            </thead>

            <tbody>
                <%
                    <!-- codigo java aqui -->
                %>
                <tr>
                    <td><%=aux.getId()%></td>
                    <td><%=aux.getNome()%></td>
                    <td><%=aux.getEndereco()%></td>
                    <td><%=aux.getBairro()%></td>
                    <td><%=aux.getCidade()%></td>
                    <td><%=aux.getCep()%></td>
                    <td><%=aux.getEstado()%></td>
                    <td><%=aux.getReferencia()%></td>
                    <td><%=aux.getCpf()%></td>
                    <td><%=aux.getRg()%></td>
                    <td><%=aux.getTelFixo()%></td>
                    <td><%=aux.getCelular()%></td>
                    <td><%=aux.getCard()%></td>
                    <td><%=aux.getBandeira()%></td>
                </tr>
                <%
                    }
                %>
            </tbody>

            <tfoot>
                <th></th><th></th>
                <th><button type="button" id="novo"><a href="formCliente.jsp">Adcionar</a></button></th>
            </tfoot>
        </table>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" type="text/css" href="/style.css">

        <script type="text/javascript" src="validacao.js"></script>

        <title>Cadastro | Cliente</title>
    </head>

    <body>
        <form action="Carrinho" method="post" name="produto" id="produto" autocomplete="on">
            
				<table>
                    <tr hidden>
						<th>Id:</th>
						<th><input type="number" name="id" id="id" placeholder="12345578" onchange="validarNum('id')" value=""></th>
					</tr>
					<tr>
						<th>Nome:</th>
						<th><input type="text" name="nome" id="nome" placeholder="ex.: Nome Produto" autofocus onchange="validarTexto('nome')" value=""></th>
					</tr>
                    <tr>
						<th>EndereÃ§o:</th>
						<th><input type="text" name="endereco" id="endereÃ§o" placeholder="ex.: Ruas dos Alfeneiros 4" onchange="validarAlphaNum('endereÃ§o')" value=""></th>
					</tr>
					<tr>
						<th>Cep:</th>
						<th><input type="number" name="cep" id="cep" placeholder="ex.: 12345578" onchange="validarNum('cep', 8)" value=""></th>
					</tr>
					<tr>
						<th>Estado(UF):</th>
						<th><select name="estado" value="">
									<option value="ac">Acre</option>
									<option value="al">Alagoas</option>
									<option value="ap">AmapÃ¡</option>
									<option value="am">Amazonas</option>
									<option value="ba">Bahia</option>
									<option value="ce">CearÃ¡</option>
									<option value="df">Distrito Federal</option>
									<option value="es">EspÃ­rito Santo</option>
									<option value="go">GoiÃ¡s</option>
									<option value="ma">MaranhÃ£o</option>
									<option value="mt">Mato Grosso</option>
									<option value="ms">Mato Grosso do Sul</option>
									<option value="mg">Minas Gerais</option>
									<option value="pa">ParÃ¡</option>
									<option value="pb">ParaÃ­ba</option>
									<option value="pr">ParanÃ¡</option>
									<option value="pe">Pernambuco</option>
									<option value="pi">PiauÃ­</option>
									<option value="rj">Rio de Janeiro</option>
									<option value="rn">Rio Grande do Norte</option>
									<option value="rs">Rio Grande do Sul</option>
									<option value="ro">RondÃ´nia</option>
									<option value="rr">Roraima</option>
									<option value="sc">Santa Catarina</option>
									<option value="sp">SÃ£o Paulo</option>
									<option value="se">Sergipe</option>
									<option value="to">Tocantins</option>
						</select></th>
					</tr>
					<tr>
						<th>ReferÃªcia:</th>
						<th><textarea rows="1" name="referencia" id="referencia" value=""></textarea></th>
					</tr>
					<tr>
						<th>CPF:</th>
						<th><input type="text" name="cpf" id="cpf" placeholder="ex.: 12345678901" onchange="validarNum('cpf', 11)" value=""></th>
					</tr>
					<tr>
						<th>RG(identidade):</th>
						<th><input type="text" name="rg" id="rg" placeholder="ex.: 123456789" onchange="validarNum('rg',9)" value=""></th>
					</tr>
					<tr>
						<th>Telefone fixo:</th>
						<th><input type="text" name="telefone" id="telefone" placeholder="ex.: 2112345678" onchange="validarNum('tel', 10)" value=""></th>
					</tr>
					<tr>
						<th>Celular:</th>
						<th><input type="text" name="celular" id="celular" placeholder="ex.: 21912345678" onchange="validarNum('cel', 11)" value=""></th>
					</tr>
					<tr>
						<th>NÃ¹mero do cartÃ£o de crÃ©dito:</th>
						<th><input type="text" name="cartao" id="cartao" autocomplete="off" onchange="validarNum('catao')" value=""></th>
					</tr>
					<tr>
						<th>Bandeira do cartÃ£o de crÃ©dito:</th>
						<th><select name="bandeira" id="bandeira" value="">
									<option value="american">American Express</option>
									<option value="discover">Discover Network</option>
									<option value="elo">Elo</option>
									<option value="mastercard">Mastercard</option>
									<option value="visa">Visa</option>
									<option value="outra">Outra</option>
							</select></th>
					</tr>
                    <tr>
						<th colspan="2" name="submit"><button type="submit" id="submit"  onclick="checkEmpty()">Enviar</button></th>
					</tr>

				</table>
        </form>

    </body>
</html>

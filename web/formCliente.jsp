<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" type="text/css" href="style.css">

        <script type="text/javascript" src="validacao.js"></script>

        <title>Cadastro | Produto</title>
    </head>

    <body>
        <form name="produto" id="produto" autocomplete="on">
				<table>
                    <tr hidden>
						<th>Id:</th>
						<th><input type="number" name="id" id="id" placeholder="12345578" onchange="validarNum('id')"></th>
					</tr>
					<tr>
						<th>Nome:</th>
						<th><input type="text" name="nome" id="nome" placeholder="ex.: Nome Produto" autofocus onchange="validarTexto('nome')"></th>
					</tr>
                    <tr>
						<th>Endereço:</th>
						<th><input type="text" name="endereço" id="endereço" placeholder="ex.: Ruas dos Alfeneiros 4" onchange="validarAlphaNum('endereço')"></th>
					</tr>
					<tr>
						<th>Bairro:</th>
						<th><input type="text" name="bairro" id="bairro" onchange="validarTexto('bairro')"></th>
					</tr>
					<tr>
						<th>Cidade:</th>
						<th><input type="text" name="cidade" id="cidade" placeholder="ex.: Littlewing" onchange="validarTexto('cidade')"></th>
					</tr>
					<tr>
						<th>Cep:</th>
						<th><input type="number" name="cep" id="cep" placeholder="ex.: 12345578" onchange="validarNum('cep', 8)"></th>
					</tr>
					<tr>
						<th>Estado(UF):</th>
						<th><select name="estado">
									<option value="ac">Acre</option>
									<option value="al">Alagoas</option>
									<option value="ap">Amapá</option>
									<option value="am">Amazonas</option>
									<option value="ba">Bahia</option>
									<option value="ce">Ceará</option>
									<option value="df">Distrito Federal</option>
									<option value="es">Espírito Santo</option>
									<option value="go">Goiás</option>
									<option value="ma">Maranhão</option>
									<option value="mt">Mato Grosso</option>
									<option value="ms">Mato Grosso do Sul</option>
									<option value="mg">Minas Gerais</option>
									<option value="pa">Pará</option>
									<option value="pb">Paraíba</option>
									<option value="pr">Paraná</option>
									<option value="pe">Pernambuco</option>
									<option value="pi">Piauí</option>
									<option value="rj">Rio de Janeiro</option>
									<option value="rn">Rio Grande do Norte</option>
									<option value="rs">Rio Grande do Sul</option>
									<option value="ro">Rondônia</option>
									<option value="rr">Roraima</option>
									<option value="sc">Santa Catarina</option>
									<option value="sp">São Paulo</option>
									<option value="se">Sergipe</option>
									<option value="to">Tocantins</option>
						</select></th>
					</tr>
					<tr>
						<th>Referêcia:</th>
						<th><textarea rows="1" name="refencia" id="referencia"></textarea></th>
					</tr>
					<tr>
						<th>CPF:</th>
						<th><input type="text" name="cpf" id="cpf" placeholder="ex.: 12345678901" onchange="validarNum('cpf', 11)"></th>
					</tr>
					<tr>
						<th>RG(identidade):</th>
						<th><input type="text" name="rg" id="rg" placeholder="ex.: 123456789" onchange="validarNum('rg')"></th>
					</tr>
					<tr>
						<th>Telefone fixo:</th>
						<th><input type="text" name="tel" id="tel" placeholder="ex.: 2112345678" onchange="validarNum('tel', 10)"></th>
					</tr>
					<tr>
						<th>Celular:</th>
						<th><input type="text" name="cel" id="cel" placeholder="ex.: 21912345678" onchange="validarNum('cel', 11)"></th>
					</tr>
					<tr>
						<th>Nùmero do cartão de crédito:</th>
						<th><input type="text" name="cartao" id="cartao" autocomplete="off" onchange="validarNum('catao')"></th>
					</tr>
					<tr>
						<th>Bandeira do cartão de crédito:</th>
						<th><select name="bandeira" id="bandeira">
									<option value="american">American Express</option>
									<option value="discover">Discover Network</option>
									<option value="elo">Elo</option>
									<option value="mastercard">Mastercard</option>
									<option value="visa">Visa</option>
									<option value="outra">Outra</option>
							</select></th>
					</tr>
                    <tr>
						<th colspan="2" name="submit"><button type="button" id="submit"  onclick="checkEmpty()">Enviar</button></th>
					</tr>

				</table>
        </form>

    </body>
</html>

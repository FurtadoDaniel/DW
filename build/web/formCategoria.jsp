<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" type="text/css" href="style.css">

        <script type="text/javascript" src="validacao.js"></script>

        <title>Cadastro | Categoria</title>
    </head>

    <body>
        <form name="produto" id="produto" autocomplete="on">
				<table>
                    <tr hidden>
						<th>Id:</th>
						<th><input type="number" name="id" id="id" placeholder="12345578" onchange="validarNum('id')"></th>
					</tr>
					<tr>
						<th>Descrição:</th>
						<th><input type="text" name="descricao" id="descricao"  onchange="validarAlphaNum('descricao')"></th>
					</tr>
                    <tr>
						<th colspan="2" name="submit"><button type="button" id="submit"  onclick="checkEmpty()">Enviar</button></th>
					</tr>

				</table>
        </form>

    </body>
</html>

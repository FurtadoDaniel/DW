<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" type="text/css" href="style.css">

        <title>Login</title>

    </head>

    <body>
        <form action="Login" method="post" name="login" id="login" autocomplete="off">
            <table>
                <tr>
                    <th colspan="2" name="titulo" id="titulo"><h2>Efetuar login</h2></th>
                </tr>
                <tr>
                    <th>Usuario</th>
                    <th><input type="text" name="user" id="user" placeholder="usuario"></th>
                </tr>
                <tr>
                    <th>Senha</th>
                    <th><input type="password" name="password" id="password"></th>
                </tr>
                <tr>
                    <th colspan="2" name="submit"><input type="submit" value="Entrar" ></th>
                </tr>
            </table>
        </form>
    </body>
</html>

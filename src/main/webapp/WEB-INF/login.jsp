<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <style>
        .all {
            background-color: beige;
            margin-top: 40px;
            margin-left: 20%;
            margin-right: 10%;
            margin-bottom: 20px;
        }
    </style>
    <title>login</title>
</head>
<body class="all">
<h1>login!</h1>
<form method="post" action="/login_success">
        <table>
            <tr>
                <td>userName：</td>
                <td>
                    <input type="text" name="username">
                </td>
            </tr>
            <tr>
                <td> password：</td>
                <td><input type="password" name="password"></td>
            </tr>
        </table>
        <input type="submit" value="submit">
</form>
</body>
</html>
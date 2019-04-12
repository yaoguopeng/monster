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

        .box {
            width: 70%;
        }
    </style>
    <title>uploadJoke</title>
</head>
<body class="all">
<h1>input joke information please!</h1>
<form method="post" action="/island_upload/joke" enctype="multipart/form-data">
    <div>
        content：<br>
        <textarea rows="10" class="box" name="content">
        </textarea><br>
        <table>
            <tr>
                <td>
                    jokeImage:
                </td>
                <td>
                    <input type="file" name="jokeImage">
                </td>
            </tr>
        </table>
        <input type="submit" value="submit">
    </div>
</form>
</body>
</html>
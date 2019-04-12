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
    <title>uploadPainting</title>
</head>
<body class="all">
<h1>input painting information please!</h1>
<form method="post" action="/island_upload/painting" enctype="multipart/form-data">
    <div>
        painting:<input type="file" name="painting"><br>
        <table>
            <tr>
                <td> paintingAuthor：</td>
                <td><input type="text" name="paintingAuthor"></td>
            </tr>
            <tr>
                <td> showingDate：</td>
                <td><input type="date" name="showingDate"></td>
            </tr>
            <tr  hidden="hidden">
                <td> createdBy：</td>
                <td><input type="text" name="createdBy" value="jsp" hidden="hidden"></td>
            </tr>
        </table>
        paintingInfo：<br>
        <textarea rows="10" class="box" name="paintingInfo">
        </textarea><br>
        <input type="submit" value="submit">
    </div>
</form>
</body>
</html>
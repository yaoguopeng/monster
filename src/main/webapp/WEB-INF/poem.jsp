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
    <title>uploadPoem</title>
</head>
<body class="all">
<h1>input poem information please!</h1>
<form method="post" action="/island_upload/poem" enctype="multipart/form-data">
    <div>
        <table>
            <tr>
                <td> poemTitle：</td>
                <td><input type="text" name="poemTitle"></td>
            </tr>
            <tr>
                <td> poemType：</td>
                <td><input type="text" name="poemType"></td>
            </tr>
            <tr>
                <td> poemAuthor：</td>
                <td><input type="text" name="poemAuthor"></td>
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
        poemContent：<br>
        <textarea rows="10" class="box" name="poemContent">
        </textarea><br>
        poemNote：<br>
        <textarea rows="10" class="box" name="poemNote">
        </textarea><br>
        poemExplaination：<br>
        <textarea rows="10" class="box" name="poemExplaination">
        </textarea><br>
        poemAppreciation：<br>
        <textarea rows="10" class="box" name="poemAppreciation">
        </textarea><br>
        <input type="submit" value="submit">
    </div>
</form>
</body>
</html>
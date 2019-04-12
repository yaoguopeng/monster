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
    <title>uploadIndex</title>
</head>
<body class="all">
<h1>input index information please!</h1>
<form method="post" action="/island_upload/index" enctype="multipart/form-data">
    <div class="content">
        content：<br>
        <textarea rows="10" class="box" name="content">
        </textarea><br>
        <table>
            <tr>
                <td>author：</td>
                <td>
                    <input type="text" name="author">
                </td>
            </tr>
            <tr hidden="hidden">
                <td> createdBy：</td>
                <td><input type="text" name="createdBy" value="jsp" hidden="hidden"></td>
            </tr>
            <tr>
                <td> showingDateBegin：</td>
                <td><input type="date" name="showingDateBegin"></td>
            </tr>
            <tr>
                <td> showingDateEnd：</td>
                <td><input type="date" name="showingDateEnd"></td>
            </tr>
        </table>
        <input type="submit" value="submit">
    </div>
</form>
</body>
</html>
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
    <title>uploadBackground</title>
</head>
<body class="all">
<h1>input background information please!</h1>
<form method="post" action="/island_upload/background" enctype="multipart/form-data">
    <table>
        <tr>
            <td>
                backgroundImage:
            </td>
            <td>
                <input type="file" name="backgroundImage">
            </td>
        </tr>
        <tr  hidden="hidden">
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
        <tr>
            <td>
                backgroundType：
            </td>
            <td>
                <select name="backgroundType">
                    <option value="INDEX">INDEX</option>
                    <option value="MOTTO">MOTTO</option>
                    <option value="MUSIC">MUSIC</option>
                    <option value="PAINTING">PAINTING</option>
                    <option value="PASSAGE">PASSAGE</option>
                    <option value="POEM">POEM</option>
                    <option value="JOKE">JOKE</option>
                    <option value="MOVIE">MOVIE</option>
                    <option value="LANDSCAPE">LANDSCAPE</option>
                </select>
            </td>
        </tr>
    </table>
    <input type="submit" value="submit">
</form>
</body>
</html>
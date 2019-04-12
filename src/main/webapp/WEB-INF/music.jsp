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
    <title>uploadMusic</title>
</head>
<body class="all">
<h1>input music information please!</h1>
<form method="post" action="/island_upload/music" enctype="multipart/form-data">
    <div>
        <table>
            <tr>
                <td> musicImage：</td>
                <td><input type="file" name="musicImage"></td>
            </tr>
            <tr>
                <td> music：</td>
                <td><input type="file" name="music"></td>
            </tr>
            <tr>
                <td> musicName：</td>
                <td><input type="text" name="musicName"></td>
            </tr>
            <tr>
                <td> musicSinger：</td>
                <td><input type="text" name="musicSinger"></td>
            </tr>
            <tr>
                <td> musicAlbum：</td>
                <td><input type="text" name="musicAlbum"></td>
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
        <input type="submit" value="submit">
    </div>
</form>
</body>
</html>
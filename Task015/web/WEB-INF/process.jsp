<%--
  Created by IntelliJ IDEA.
  User: Denis
  Date: 22.03.16
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/process" method="POST">
        <textarea name="text"></textarea>
        <select name="operat">
            <option value="symbols">Количество символов</option>
            <option value="words" >Количество слов</option>
            <option value="sentences">Количество предложений</option>
            <option value="paragraphs">Количество абзацев</option>
        </select>
        <input type="submit" value="Process">
    </form>
</body>
</html>

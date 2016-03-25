<%--
  Created by IntelliJ IDEA.
  User: Denis
  Date: 22.03.16
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${action}">
        <input type="text" value="${search}" name="${name}">
        <input type="submit" value="Поиск на ${address}">
    </form>
</body>
</html>

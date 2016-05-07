<#ftl encoding="utf-8">
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />

<html>
<head>
    <title>Sign In</title>
</head>
<body>
<h1>Spring Security</h1>


<@security.authorize access="isAuthenticated()">
<a href="/logout">Выйти</a>
</@security.authorize>

</body>
</html>
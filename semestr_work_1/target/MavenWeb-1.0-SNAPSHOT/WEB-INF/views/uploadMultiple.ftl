<#ftl encoding="utf-8">
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />

<html>
<head>
    <title>Upload Multiple File Request Page</title>
</head>
<body>

<form method="POST" action="uploadMultipleFile" enctype="multipart/form-data">
    File1 to upload: <input type="file" name="file"><br />
    Name1: <input type="text" name="name"><br /> <br />
    File2 to upload: <input type="file" name="file"><br />
    Name2: <input type="text" name="name"><br /> <br />
    <input type="submit" value="Upload"> Press here to upload the file!
</form>

</body>
</html>

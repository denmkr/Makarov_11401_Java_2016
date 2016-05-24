<#ftl encoding="utf-8">
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />

<form method="POST" style="margin: 0 3%;text-align: left;" action="uploadMultipleFile" enctype="multipart/form-data">
    <a style="font-size: 20px;">Файл import.xml:</a> <input type="file" name="file" style="font-size: 16px;margin-left: 30px;margin-bottom: 10px;"><br />
    <a style="font-size: 20px;">Файл offers.xml:</a> <input type="file" name="file" style="font-size: 16px;margin-left: 30px;"><br />
    <input style="font-size: 16px;
padding: 10px 20px;
background: #3f4755;
color: #fff;
margin-top: 60px;" type="submit" value="Обновить товары">
</form>
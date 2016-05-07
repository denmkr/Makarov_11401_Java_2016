<#ftl encoding="utf-8">
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />

<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>Интернет-магазин</title>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
    <link href="/css/admin_style.css" rel="stylesheet" />
    <link href="/css/animate.css" rel="stylesheet" />
    <script type="text/javascript" src="/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="/js/javascript.js"></script>
</head>
<body>

<!-- Прелоадер -->
<div class="loader">
    <div class="cssload-container">
        <div class="cssload-double-torus"></div>
    </div>
</div>

<!-- Панель покупателя -->
<div class="shop-header-container">
    <div class="shop-header">
        <div class="inside">
        <@security.authorize access="hasRole('ROLE_ADMIN')">
            <div class="admin">
                <img src="/images/admin.png">
                <span class="title">Панель администратора</span>
            </div>
        </@security.authorize>
        <@security.authorize access="isAnonymous()">
            <a href="/signin">
                <div class="user">
                    <img src="/images/user.png">
                    <span>Войти</span>
                </div>
            </a>
        </@security.authorize>
        <@security.authorize access="isAuthenticated()">
            <div class="user">
                <img src="/images/user.png">
                <a href="/user">${username}</a>
            </div>
        </@security.authorize>
        </div>
    </div>
</div>

<!-- Боковая панель -->
<aside class="animated slideInLeft">
    <div class="logo">
        <div class="logo_text">
            <div class="logo_text_head">Отражение</div>
        </div>
    </div>
    <ul class="menu">
        <li><a class="elem"><img src="/images/paying.png">
            Информация</a></li>
        <li><a class="elem"><img src="/images/shipping.png">
            Пользователи</a></li>
        <li><a href="/contacts" class="elem"><img src="/images/contacts.png">
            Заказы</a></li>
        <li>
            <div class="elem selected"><img src="/images/catalog.png">
                <a href="/catalog">Товары</a>
                <div class="menu_icon closed"></div>
            </div>
            <ul class="sub_menu">
                <li><div class="elem"><a>Добавление товаров</a></div></li>
                <li><div class="elem"><a>Удаление товаров</a></div></li>
                <li><div class="elem"><a>Загрузка товаров</a></div></li>
            </ul>
        </li>
    </ul>
</aside>

<div class="main">
    <header>
        <div class="user">
            <img class="img" src="/images/user.png">
            <div class="text">
                Информация
            </div>
        </div>

    </header>

    <div class="table_panel">
    </div>

    <footer>
        <div>© 2016 Отражение
        </div>
    </footer>

</div>
</body>
</html>
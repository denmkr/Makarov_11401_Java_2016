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
    <script type="text/javascript" src="/js/admin_javascript.js"></script>
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
            <a href="/">
                <div class="home">
                    <img src="/images/home.png">
                    <span class="title">Перейти на сайт</span>
                </div>
            </a>
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
<aside>
    <div class="logo">
        <div class="logo_text">
            <div class="logo_text_head">Отражение</div>
            <div class="logo_text_sub">Админ панель</div>
        </div>
    </div>
    <ul class="menu">
        <li><a rel="information" class="elem"><img src="/images/info.png">
            Информация</a></li>
        <li>
            <div rel="users" class="elem">
                <img src="/images/users.png">
                <a>Пользователи</a>
                <div class="menu_icon closed"></div>
            </div>
            <ul class="sub_menu">
                <li><div class="elem"><a>Добавление пользователя</a></div></li>
                <li><div class="elem"><a>Удаление пользователя</a></div></li>
                <li><div class="elem"><a>Изменение роли пользователя</a></div></li>
            </ul>
        </li>
        <li><a rel="orders" class="elem"><img src="/images/orders.png">
            Заказы</a></li>
        <li>
            <div rel="products" class="elem">
                <img src="/images/products.png">
                <a>Товары</a>
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
            <div class="text">
                Информация
            </div>
        </div>

    </header>

    <div class="table_panel">
        <#include "ajax/orders_content.ftl">
    </div>

    <footer>
        <div>© 2016 Отражение
        </div>
    </footer>

</div>
</body>
</html>
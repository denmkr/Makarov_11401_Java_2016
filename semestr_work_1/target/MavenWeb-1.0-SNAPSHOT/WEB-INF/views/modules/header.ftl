<#ftl encoding="utf-8">
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />

<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>Интернет-магазин</title>
    <link href="/css/animate.css" rel="stylesheet" />
    <link href="/css/style.css" rel="stylesheet" />
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,700&subset=latin,cyrillic-ext,cyrillic' rel='stylesheet' type='text/css'>
    <script type="text/javascript" src="/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="/js/jquery.sticky.js"></script>
    <script type="text/javascript" src="/js/jquery.stellar.js"></script>
    <script type="text/javascript" src="/js/javascript.js"></script>

</head>
<body>

<!-- Прелоадер -->
<div class="loader">
    <div class="cssload-container">
        <div class="cssload-double-torus"></div>
    </div>
</div>

<div class="wrapper">
    <div class="wrapper-content">

    <!-- Панель покупателя -->
    <div class="shop-header-container">
        <div class="shop-header">
            <div class="inside">
            <@security.authorize access="hasRole('ROLE_ADMIN')">
                <a href="/admin">
                <div class="admin">
                    <img src="/images/admin.png">
                    <span class="title">Панель администратора</span>
                </div>
                </a>
            </@security.authorize>
                <a href="/cart">
                    <div class="cart">
                        <img src="/images/cart.png">
                        <span class="size">
                            <#include "../ajax/cart_size.ftl">
                        </span>
                        <span class="title">Корзина</span>
                    </div>
                </a>
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

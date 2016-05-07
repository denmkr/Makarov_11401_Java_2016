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

<!-- Панель покупателя -->
<div class="shop-header-container">
    <div class="shop-header">
        <div class="inside">
            <a href="#">
                <div class="cart">
                    <img src="/images/cart.png">
                    <a class="size">${cart_size}</a>
                    <span class="title">Корзина</span>
                </div>
            </a>
            <div class="user">
                <img src="/images/user.png">
            <@security.authorize access="isAuthenticated()">
                <a href="/user">${username}</a>
            </@security.authorize>
            <@security.authorize access="isAnonymous()">
                <span>Войти</span>
            </@security.authorize>
            </div>
        </div>
    </div>
</div>

<!-- Окно авторизации -->
<div class="auth">
    <div class="auth-container">
    </div>
    <div class="auth-content">
        <div class="logo animated fadeInDown">
            <div class="head">Отражение</div>
            <div class="sub">интернет-магазин</div>
        </div>
        <div class="modal animated flipInXSmall">
            <div class="title">Авторизация</div>
            <form id="signin_form" action="j_spring_security_check" id="auth" method="POST">
                <input type="text" name="j_username" placeholder="Логин">
                <input type="password" name="j_password" placeholder="Пароль">
                <input style="display: none;" type="checkbox" name="remember-me" checked="checked" />
                <div class="button" onkeydown="" onclick="document.getElementById('auth').submit();">Войти</div>
            </form>
            <#if error??>
                <div class="wrong_data">
                    Неправильный логин или пароль
                </div>
            </#if>
            <div class="reg">
                Впервые у нас? <a href="/signup">Зарегистрируйтесь</a>
            </div>
        </div>
        <a href="/home">
            <div class="close animated fadeInUp">
                <img src="/images/back_button.png">
                <div>Вернуться на главную</div>
            </div>
        </a>
    </div>
</div>


</body>
</html>

<#ftl encoding="utf-8">
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />

<#include "modules/header.ftl">

<!-- Шапка -->
<header>
    <div class="inside">
        <div class="logo">
            <div class="text">Отражение</div>
        </div>
        <ul class="menu">
            <a href="/home"><li>Главная</li></a>
            <a href="/catalog"><li>Каталог</li></a>
            <a href="/shipping"><li>Доставка</li></a>
            <a href="/contacts"><li>Контакты</li></a>
        </ul>
    </div>
</header>

<!-- Главный блок -->
<div class="main">
    <div class="back shipping" data-stellar-background-ratio="0.5">
        <div class="title">Доставка</div>
    </div>

    <div class="catalog">
        Доставка
    </div>
</div>

<#include "modules/footer.ftl">
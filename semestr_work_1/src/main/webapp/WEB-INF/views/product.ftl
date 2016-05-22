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
            <a href="/"><li>Главная</li></a>
            <a href="/catalog"><li>Каталог</li></a>
            <a href="/shipping"><li>Доставка</li></a>
            <a href="/contacts"><li>Контакты</li></a>
        </ul>
    </div>
</header>

<!-- Главный блок -->
<div class="main">
    <div class="back contacts" data-stellar-background-ratio="0.5">
        <div class="title">Товар</div>
    </div>

    <div>
        <div><#if product.productGroup.parentGroup.parentGroup??>${product.productGroup.parentGroup.parentGroup.name}</#if> <#if product.productGroup.parentGroup??>${product.productGroup.parentGroup.name}</#if> ${product.productGroup.name}</div>
        <div>${product.name}</div>
        <div>${product.articule}</div>
        <div>${product.stock}</div>
        <div>${product.price}</div>
        <div>${product.currency}</div>
    </div>
</div>

<#include "modules/footer.ftl">

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
    <div class="back catalog" data-stellar-background-ratio="0.5">
        <div class="title">Корзина</div>
    </div>
    <div class="inside">
        <div style="width: 94%;" class="content">
            <#if cart.products??>
                <#if cart.size!=0>
                    <#include "ajax/cart_content.ftl">
                <#else>
                    <div style="text-align: center;">
                        <div style="font-size: 24px;color: #666;margin-top: 40px;">Ваша корзина пустая</div>
                        <div style="margin-top: 50px;"><img style="width: 200px;" src="/images/emptycart.png"></div>

                        <a href="/catalog"><div style="margin: 0 3%;
margin-top: 100px;
font-size: 1.1rem;
color: #3c6689;
padding: 20px 50px;
display: inline-block;
border: 1px solid #3c6689;
transition: all 0.3s ease-out;
cursor: pointer;">Перейти к каталогу</div></a>
                    </div>
                </#if>
            </#if>

        </div>
    </div>
</div>

<#include "modules/footer.ftl">


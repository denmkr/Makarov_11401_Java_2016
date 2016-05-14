<#ftl encoding="utf-8">

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
        <div class="title">Главная</div>
    </div>

    <div class="inside">
        <div style="margin-top: 60px;">
            <div style="display: inline-block;
vertical-align: top;
width: 33%;
text-align: center;">
                <div style="font-size: 36px;
margin: 40px 0;
color: #444;">МФУ</div>
                <img style="width: 300px;" src="/images/mfu.png">
            </div>
            <div style="display: inline-block;
vertical-align: top;
width: 33%;text-align: center;"><div style="font-size: 36px;
margin: 40px 0;
color: #444;">Принтеры</div><img style="width: 300px;" src="/images/printer.png"></div>
            <div style="display: inline-block;
vertical-align: top;
width: 33%;text-align: center;"><div style="font-size: 36px;
margin: 40px 0;
color: #444;">Кондиционеры</div><img style="width: 300px;" src="/images/conditioner.png"></div>
            <div style="font-size: 40px;margin: 40px 0;">Расходные материалы</div>
        </div>
    </div>
</div>

<#include "modules/footer.ftl">

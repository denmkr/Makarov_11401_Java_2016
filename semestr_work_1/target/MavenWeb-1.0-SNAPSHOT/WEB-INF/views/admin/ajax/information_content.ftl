<#ftl encoding="utf-8">
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />

<div class="info_panel">
    <div class="block red">
        <div class="number">${users_count}</div>
        <div class="text">Пользователей</div>
    </div>

    <div class="block green">
        <div class="number">135</div>
        <div class="text">Посетителей сегодня</div>
    </div>

    <div class="block blue">
        <div class="number">${orders_count}</div>
        <div class="text">Заказов сегодня</div>
    </div>

    <div class="block blackblue">
        <div class="number">2</div>
        <div class="text">Заявки на партнерство</div>
    </div>
</div>


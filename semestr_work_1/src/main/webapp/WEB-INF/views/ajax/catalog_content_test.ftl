<#ftl encoding="utf-8">

<ul class="breadcrumbs">
    <li><a href="">МФУ</a></li>
    <li><img src="/images/down.png"></li>
    <li><a href="">OKI</a></li>
</ul>
<div class="info">Показано ${products.totalElements} товаров</div>

<table class="table">
    <thead>
    <th>Артикул</th>
    <th>Название</th>
    <th>Количество</th>
    <th>Цена</th>
    <th>В корзину</th>
    </thead>
    <tbody>
        <#list products.content as product>
        <tr>
            <td><a>${product.articule}</a></td>
            <td><a style="color: #4e7fa9; text-decoration: underline;" href="/product/${product.articule}">${product.name}</a></td>
            <td><a>${product.stock}</a> шт.</td>
            <td><a>${product.price}</a> ${product.currency}</td>
            <td onclick="addToCart('${product.articule}')" class="into_cart">
                <a>Добавить</a>
            </td>
        </tr>
        </#list>
    </tbody>
</table>
<ul class="paginator">
<#if products.totalElements != 0>
    <#if beginIndex != currentIndex>
        <li rel="${currentIndex - 1}">Предыдущая</li>
    </#if>
    <#list beginIndex..endIndex as i>
        <#if i == currentIndex>
            <li rel="${i}" class="active">${i}</li>
        <#else>
            <li rel="${i}">${i}</li>
        </#if>
    </#list>
    <#if products.totalPages != currentIndex>
        <li rel="${currentIndex + 1}">Следующая</li>
    </#if>
</#if>
</ul>
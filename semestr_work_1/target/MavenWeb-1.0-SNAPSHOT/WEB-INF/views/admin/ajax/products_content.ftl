<#ftl encoding="utf-8">
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />

        <table class="table">
            <thead>
            <th>id</th>
            <th>Артикул</th>
            <th>Наименование</th>
            <th>Наличие</th>
            <th>Цена</th>
            <th>Валюта</th>
            </thead>
            <tbody>
            <#list products as product>
            <tr>
                <td><a>${product.id}</a></td>
                <td><a>${product.articule}</a></td>
                <td><a>${product.name}</a></td>
                <td><a>${product.stock}</a></td>
                <td><a>${product.price}</a></td>
                <td><a>${product.currency}</a></td>
            </tr>
            </#list>
            </tbody>
        </table>
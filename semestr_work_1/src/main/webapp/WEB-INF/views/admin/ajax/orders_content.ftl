<#ftl encoding="utf-8">
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />

        <table class="table">
            <thead>
            <th>Username</th>
            <th>Наименование</th>
            <th>Количество</th>
            <th>Дата</th>
            </thead>
            <tbody>
            <#list orders as order>
            <tr>
                <td><a><#if order.user??>${order.user.username}</#if></a></td>
                <td><a>${order.product.name}</a></td>
                <td><a>${order.count}</a></td>
                <td><a>${order.date}</a></td>
            </tr>
            </#list>
            </tbody>
        </table>


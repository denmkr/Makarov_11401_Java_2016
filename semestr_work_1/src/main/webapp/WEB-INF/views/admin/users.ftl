<#ftl encoding="utf-8">
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />

        <table class="table">
            <thead>
            <th>id</th>
            <th>Username</th>
            <th>Email</th>
            <th>Дата регистрации</th>
            </thead>
            <tbody>
                <#list users as user>
                <tr>
                    <td><a>${user.id}</a></td>
                    <td><a>${user.username}</a></td>
                    <td><a>${user.email}</a></td>
                    <td><a></a></td>
                </tr>
                </#list>
            </tbody>
        </table>

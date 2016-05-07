<#ftl encoding="utf-8">
<ul class="paginator">
<#if pagesCount != 0>
    <#list 1..pagesCount as i>
        <li rel="${i}">${i}</li>
    </#list>
</#if>
</ul>
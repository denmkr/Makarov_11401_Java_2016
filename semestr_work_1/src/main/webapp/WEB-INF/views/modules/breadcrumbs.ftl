<#ftl encoding="utf-8">
<#if breadCrumbs??>
<ul class="breadcrumbs">
    <#list breadCrumbs as breadCrumbs>
        <li><a href="${breadCrumbs.href}">${breadCrumbs.name}</a></li>
        <#if breadCrumbs_has_next>
            <li><img src="/images/down.png"></li>
        </#if>
    </#list>
</ul>
</#if>
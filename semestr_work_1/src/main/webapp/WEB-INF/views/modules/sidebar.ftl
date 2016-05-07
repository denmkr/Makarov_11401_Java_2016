<#ftl encoding="utf-8">
<!-- Боковая панель -->
<aside>
    <div class="logo">
        <div class="logo_text">
            <div class="logo_text_head">Отражение</div>
            <div class="logo_text_sub">интернет-магазин</div>
        </div>
    </div>
    <ul class="menu">
        <li><a class="elem"><img src="/images/paying.png">
            Оплата</a></li>
        <li><a class="elem"><img src="/images/shipping.png">
            Доставка</a></li>
        <li><a href="/contacts" class="elem"><img src="/images/contacts.png">
            Контакты</a></li>
        <li>
            <div class="elem selected"><img src="/images/catalog.png">
                <a href="/catalog">Каталог</a>
                <div class="menu_icon closed"></div>
            </div>

            <ul class="sub_menu">
                <#if groups??>
                    <#list groups as groups>
                        <li>
                            <a class="elem" onclick="getProducts('${groups.id}')" >
                                ${groups.name}
                            </a>
                        </li>
                    </#list>
                </#if>
                <li>
                    <div class="elem"><a>Brother</a>
                        <div class="menu_icon closed"></div>
                    </div>
                    <ul class="sub_menu">
                        <li><div class="elem"><a>Brother</a>
                            <div class="menu_icon closed"></div>
                        </div>
                            <ul class="sub_menu">
                                <li><div class="elem"><a>Samsung</a></div></li>
                                <li><div class="elem"><a>Samsung</a></div></li>
                                <li><div class="elem"><a>Samsung</a></div></li>
                                <li><div class="elem"><a>Samsung</a></div></li>
                                <li><div class="elem"><a>Samsung</a></div></li>
                                <li><div class="elem"><a>Samsung</a></div></li>
                                <li><div class="elem"><a>Brother Brother авыа аывdBrother sdasdsd</a></div></li>
                                <li><div class="elem"><a>Samsung</a></div></li>
                                <li><div class="elem"><a>Samsung</a></div></li>
                            </ul></li>
                        <li><div class="elem"><a>Samsung</a></div></li>
                    </ul>
                </li>
                <li><div class="elem"><a>Samsung</a></div></li>
                <li><div class="elem"><a>Samsung</a></div></li>
                <li><div class="elem"><a>Samsung</a></div></li>
            </ul>
        </li>
    </ul>
</aside>
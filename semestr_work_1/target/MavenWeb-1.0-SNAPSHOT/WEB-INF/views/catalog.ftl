<#ftl encoding="utf-8">
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />

<#include "modules/header.ftl">

        <!-- Шапка -->
        <header class="catalog">
            <div class="inside">
                <div class="logo">
                    <div class="text">Отражение</div>
                </div>
                <ul class="menu">
                    <a href="/home"><li>Главная</li></a>
                    <a href="/catalog"><li>Каталог</li></a>
                    <a href="/shipping"><li>Доставка</li></a>
                    <a href="/contacts"><li>Контакты</li></a>
                </ul>
            </div>
        </header>

        <!-- Главный блок -->
        <div class="main">
            <div class="inside">
                <div class="aside-container">
                    <aside>
                        <div class="title">Категории</div>
                        <ul class="aside_menu">
                            <li><a class="elem">МФУ</a></li>
                            <li><a class="elem">Кондиционеры</a></li>
                            <li><a href="/contacts" class="elem">Принтеры</a></li>
                            <li>
                                <div class="elem selected">
                                    <a href="/catalog">Расходные материалы</a>
                                    <div class="menu_icon closed"></div>
                                </div>
                                <ul class="sub_menu">
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
                                                    <li><div class="elem"><a>Samsung</a></div></li>
                                                    <li><div class="elem"><a>Samsung</a></div></li>
                                                    <li><div class="elem"><a>Samsung</a></div></li>
                                                    <li><div class="elem"><a>Samsung</a></div></li>
                                                    <li><div class="elem"><a>Samsung</a></div></li>
                                                    <li><div class="elem"><a>Samsung</a></div></li>
                                                    <li><div class="elem"><a>Samsung</a></div></li>
                                                    <li><div class="elem"><a>Samsung</a></div></li>
                                                    <li><div class="elem"><a>Samsung</a></div></li>
                                                    <li><div class="elem"><a>Samsung</a></div></li>
                                                    <li><div class="elem"><a>Samsung</a></div></li>
                                                    <li><div class="elem"><a>Samsung</a></div></li>
                                                    <li><div class="elem"><a>Brother Brother Brother</a></div></li>
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
                </div>
                <div class="content">
                    <div class="table_panel">
                        <div class="panel">

                            <div class="filter">

                                <form class="filter_form" action="/catalog" method="GET">

                                    <div class="stock">
                                        <a class="stock_form_title">Фильтры</a>
                                        <div class="both"></div>
                                        <div class="stock_form_checkbox">
                                            <input onchange="filterProducts()" id="check" name="stock" class="stock_form_input" type="checkbox">
                                            <label for="check">В наличии</label>
                                        </div>
                                    </div>

                                    <div class="order">
                                        <a class="order_form_title">Сортировка по</a>
                                        <div class="both"></div>
                                        <div class="order_form_select_div">
                                            <select name="sort" onchange="filterProducts()">
                                                <option value="name_ASC">Наименованию (возр.)</option>
                                                <option value="name_DESC">Наименованию (убыв.)</option>
                                                <option value="price_ASC">Цене (возр.)</option>
                                                <option value="price_DESC">Цене (убыв.)</option>
                                                <option value="stock_ASC">Наличию (возр.)</option>
                                                <option value="stock_DESC">Наличию (убыв.)</option>
                                                <option value="articule_ASC">Артикулу (возр.)</option>
                                                <option value="articule_DESC">Артикулу (убыв.)</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="search">
                                        <input type="text" name="search" onkeyup="filterProducts()" placeholder="Поиск">
                                        <img src="/images/search.png" class="search_img" >
                                        <div class="both"></div>
                                        <div class="search_mode_form">
                                            <div class="search_mode_form_select_div">
                                                <select>
                                                    <option>Текущий каталог</option>
                                                    <option>Весь каталог</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>

                                </form>

                            </div>

                        </div>

                        <div class="catalog-container">
                            <#include "ajax/catalog_content_test.ftl">
                        </div>

                    </div>
                </div>
            </div>
        </div>

<#include "modules/footer.ftl">
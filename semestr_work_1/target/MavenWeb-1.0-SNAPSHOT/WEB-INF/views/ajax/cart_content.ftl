<#ftl encoding="utf-8">

<#if cart.products??>
    <#if cart.size!=0>
        <div class="table_panel">
            <table class="cart_table">
                <thead>
                <th>Артикул</th>
                <th>Название</th>
                <th>Цена</th>
                <th>Из корзины</th>
                </thead>
                <tbody>
                    <#list cart.products as product>
                    <tr>
                        <td><a>${product.articule}</a></td>
                        <td><a style="color: #4e7fa9; text-decoration: underline;" href="/catalog/product/${product.articule}">${product.name}</a></td>
                        <td><a>${product.price}</a> ${product.currency}</td>
                        <td onclick="removeFromCart('${product.articule}')" class="into_cart">
                            <a>Удалить</a>
                        </td>
                    </tr>
                    </#list>
                </tbody>
            </table>
        </div>
        <a href="/placeorder"><div style="margin: 0 3%;
margin-top: 100px;
font-size: 1.1rem;
color: #3c6689;
padding: 20px 50px;
display: inline-block;
border: 1px solid #3c6689;
transition: all 0.3s ease-out;
cursor: pointer;">Оформить заказ</div></a>
    <#else>
    <div style="text-align: center;">
        <div style="font-size: 24px;color: #666;margin-top: 40px;">Ваша корзина пустая</div>
        <div style="margin-top: 50px;"><img style="width: 200px;" src="/images/emptycart.png"></div>

        <a href="/catalog"><div style="margin: 0 3%;
margin-top: 100px;
font-size: 1.1rem;
color: #3c6689;
padding: 20px 50px;
display: inline-block;
border: 1px solid #3c6689;
transition: all 0.3s ease-out;
cursor: pointer;">Перейти к каталогу</div></a>
    </div>
    </#if>
</#if>

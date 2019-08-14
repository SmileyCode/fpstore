<#import "parts/common.ftl" as c>

    <@c.page>

    <div class="title-block">
        <div class="container">
            <div class="row">
                <div class="col-md-12"><center>КОРЗИНА</center></div>
            </div>
        </div>
    </div>

    <#list carts as cart>
    <center>
        <div class="cartitem-block">
            <div class="container">
                <div class="row">
                    <div class="col-md-3"><img src="/static/img/item6_2.jpg" alt="Товар"></div>
                    <div class="col-md-6">
                        <div class="itemName">${cart.itemId.itemname}</div>
                        <div class="row">
                            <div class="col-md-6 itemInfo">Продавец:</div>
                            <div class="col-md-6 itemSeller">${cart.itemId.sellerName}</div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 itemInfo">Цена:</div>
                            <div class="col-md-6 itemSeller">${cart.itemId.price} руб.</div>
                        </div>
                        <div class="pb-3"></div>
                    </div>
                    <div class="col-md-3">
                        <form action="cart/delete" method="post">
                            <input type="hidden" name="id" value="${cart.id}" />
                            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                            <button class="pull-left ed itemBtns" type="button"><input type="submit" value="Удалить"/></button>
                        </form>
                        <form action="cart/buy" method="post">
                            <input type="hidden" name="id" value="${cart.id}" />
                            <input type="hidden" name="itemId" value="${cart.itemId.id}" />
                            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                            <button class="pull-left ed itemBtns" type="button"><input type="submit" value="Оплатить"/></button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </center>
        <#else>
            No items
    </#list>

    <#list carts as cart>
        <div>
            <b>${cart.itemId.id}</b>
            <span>${cart.itemId.itemname}</span>
            <i>${cart.itemId.description}</i>
            <strong>${cart.itemId.price}</strong>
            <strong>${cart.itemId.sellerName}</strong>
            <form action="cart/delete" method="post">
                <input type="hidden" name="id" value="${cart.id}" />
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div><input type="submit" value="Delete"/></div>
            </form>
            <form action="cart/buy" method="post">
                <input type="hidden" name="id" value="${cart.id}" />
                <input type="hidden" name="itemId" value="${cart.itemId.id}" />
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div><input type="submit" value="Buy"/></div>
            </form>
        </div>
        <#else>
            No items
    </#list>

</@c.page>
<#import "parts/common.ftl" as c>

    <@c.page>


    <div class="title-block bgts">
        <div class="container">
            <div class="row shadow bgw">
                <div class="col-md-12 path">HOME / ${item.category} / ${item.itemname} <a href="/item/edit?id=${item.id}">${message?ifExists}</a></div>
            </div>
        </div>
    </div>

    <#if message??>
    <div class="title-block bgts">
        <div class="container">
            <div class="row shadow bgg">
                <div class="col-md-12 path">
                    <form action="/discount" method="post">
                        Скидка <div class="bgw"><input type="number" min="0" max="99" step="1" name="discount" value="0"/></div>
                        <input type="hidden" name="id" value="${item.id}" />
                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                        <button class="ed" type="button"><input type="submit" value="Save"/></button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    </#if>

    <div class="main-block">
        <div class="container">

            <div class="row">
                <div class="col-md-9">
                    <div class="img-block shadowd text-center bgw">
                        <img src="/img/${item.image}" alt="">
                        <div class="pb-3"></div>
                        <div class="row miniBar">
                            <div class="col-md-12">
                                <img src="/img/${item.image}" alt="">
                                <img src="/static/img/item6.jpg" alt="">
                            </div>
                        </div>
                    </div>
                    <div class="itemstat-block shadowd">
                        <div class="row">
                            <div class="col-md-8">
                                ${item.price} руб.
                            </div>
                            <div class="col-md-4"><div class="text-right">Продавец: ${item.sellerName}</div></div>

                        </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="container bgw shadowd">
                        <div class="cart">
                            <div class="row text-center align-items-center">
                                <div class="col-md-6"><img src="/static/img/cart-icon.gif" alt=""></div>
                                <div class="col-md-6">
                                    <div class="blackT">
                                        <form action="/item" method="post">
                                            <input type="hidden" name="id" value="${item.id}" />
                                            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                                            <div><input type="submit" value="В корзину"/></div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="pb-3"></div>

                    <div class="container bgw shadowd pd20 Tahoma12">
                        <li><img class="mg5" src="/static/img/ok-symbol.gif" alt="">
                            Бесплатная доставка по Москве</li>
                        <li><img class="mg5" src="/static/img/ok-symbol.gif" alt="">
                            Гарантия 3 года</li>
                        <li><img class="mg5" src="/static/img/ok-symbol.gif" alt="">
                            Скидка: ${item.discount} %</li>
                    </div>
                </div>
            </div>

        </div>
    </div>

    <div class="desc">
        <div class="container">
            <div class="row shadowd bgw">
                <div class="col-md-12">
                    <div class="descText">
                        ${item.description}
                    </div>
                </div>
            </div>
        </div>
    </div>

    <#if addNewReview??>
        <#if !(addNewReview.revText)??>
                <form action="/item/addreview" method="post">
                    <div class="container shadowd bgg pd20">
                        <textarea class = "form-control" rows = "3" type="text" name="revText"></textarea>
                        <input type="hidden" name="itemId" value="${item.id}" />
                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                        <div class="col-md-12 text-right"><button class="bgw mg15-top"><input type="submit" value="Отправить"/></button></div>
                    </div>
                </form>
        </#if>
    </#if>

    <div class="comments-block">
        <div class="container bgw shadowd pd20">

            <#list reviews as review>
                <div class="row">
                    <div class="col-md-3">
                        <img class="commentPhoto" src="/img/${review.buyerId.avatar}" alt="">
                    </div>
                    <div class="col-md-9">
                        <div class="descText">
                            <b>${review.buyerId.username}</b>, ${review.revText}
                        </div>
                    </div>
                </div>

                <hr size="8">

                <#else>
                    No reviews
            </#list>

        </div>
    </div>

</@c.page>
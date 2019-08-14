<#macro cat catId>
<div class="col-md-3">
    <div class="category">
        <div class="row align-items-center">
            <div class="col"><img src="/static/img/img-category.gif" alt="Категория"></div>
            <div class="col"><a href="${catId}" title="link">Категория</a></div>
        </div>
    </div>
</div>
</#macro>

<#macro itms>
    <div class="items-block">
        <div class="container">
            <#list items?chunk(3) as row>
                <div class="row">
                    <#list row as item>
                        <div class="col-md-4">
                            <div class="item">
                                <a href="/item?id=${item.id}"><img src="/img/${item.image}" alt="Товар"></a>
                                <div class="price">${item.price} руб.</div>
                            </div>
                        </div>
                    </#list>
                </div>
                <#else>
                    <div class="something">No items</div>
            </#list>
        </div>
    </div>
</#macro>
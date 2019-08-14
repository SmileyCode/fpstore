<#import "parts/common.ftl" as c>
    <#import "parts/shortcuts.ftl" as s>

    <@c.page>

    <center>
        <form action="/advsearch" method="get">
        <div class="advsearch-block">
            <div class="container bgw">
                <div class="row">
                        <div class="col-md-4"><input type="text" name="search"></div>
                        <div class="col-md-4"><input type="checkbox" name="discountOnly"> Скидки</div>
                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                        <div class="col-md-4"><button type="submit">Найти</button></div>
                </div>
            </div>
        </div>
        </form>
    </center>

    <@s.itms />

</@c.page>
<#import "parts/common.ftl" as c>

    <@c.page>

    <div class="container shadowd bgg pd20 mg15-top">
        <form action="/forgot/" method="post">
            <div><label> E-mail : <div class="bgw"><input type="text" name="email"/></div> </label></div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="center"><button class="bgw mg15-top"><input type="submit" value="Отправить"/></button></div>
        </form>
    </div>

</@c.page>
<#import "parts/common.ftl" as c>

    <@c.page>

    <div class="container shadowd bgg pd20 mg15-top">
        <form action="/addavatar" method="post" enctype="multipart/form-data">
            <div><input type="file" name="file"></div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="center"><button class="bgw mg15-top"><input type="submit" value="Отправить"/></button></div>
        </form>
    </div>

</@c.page>
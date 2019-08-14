<#import "parts/common.ftl" as c>

<@c.page>

        <div class="container shadowd bgg pd20 mg15-top">
            <form action="/login" method="post">
                <div><label> E-mail : <div class="bgw"><input type="text" name="username"/></div> </label></div>
                <div><label> Password: <div class="bgw"><input type="password" name="password"/></div> </label></div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div class="center"><button class="bgw mg15-top"><input type="submit" value="Войти"/></button></div>
            </form>
            <a href="/registration">Регистрация</a>
            <a href="/forgot">Забыл пароль</a>
        </div>

</@c.page>
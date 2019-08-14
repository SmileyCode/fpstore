<#import "parts/common.ftl" as c>

<@c.page>

    <div class="container shadowd bgg pd20 mg15-top">
        ${message?ifExists}
        <form action="/registration" method="post">
            <div><label> User Name : <div class="bgw"><input type="text" name="username"/></div></label></div>
            <div><label> E-mail: <div class="bgw"><input type="text" name="mail"/></div></label></div>
            <div><label> Name: <div class="bgw"><input type="text" name="realname"/></div></label></div>
            <div><label> Surname: <div class="bgw"><input type="text" name="surname"/></div></label></div>
            <div><label> Add. name: <div class="bgw"><input type="text" name="addname"/></div></label></div>
            <div><label> Adress: <div class="bgw"><input type="text" name="adress"/></div></label></div>
            <div><label> Post code: <div class="bgw"><input type="text" name="postcode"/> </label></div>
            <div><label> City: <div class="bgw"><input type="text" name="city"/></div></label></div>
            <div><label> Country: <div class="bgw"><input type="text" name="country"/></div></label></div>
            <div><label> Phone number: <div class="bgw"><input type="text" name="phonenumber"/></div></label></div>
            <div><label> Password: <div class="bgw"><input type="password" name="password"/></div></label></div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="center"><button class="bgw mg15-top"><input type="submit" value="Регистрация"/></button></div>
        </form>
    </div></div>

</@c.page>

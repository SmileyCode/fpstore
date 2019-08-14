<#import "parts/common.ftl" as c>

<@c.page>

    <div class="container shadowd bgg pd20 mg15-top">
        <form action="/additem" method="post">
            <div><label> Itemname: <div class="bgw"><input type="text" name="itemname"/></div></label></div>
            <div><label> Description: <div class="bgw"><input type="text" name="description"/></div></label></div>
            <div><label> Category: <div class="bgw"><input type="text" name="category"/></div></label></div>
            <div><label> Price: <div class="bgw"><input type="number" min="0" step="1" name="price"/></div></label></div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="center"><button class="bgw mg15-top"><input type="submit" value="Добавить"/></button></div>
        </form>
    </div>


    Add item
    <form action="/additem" method="post">
        <div><label> Itemname: <input type="text" name="itemname"/></label></div>
        <div><label> Description: <input type="text" name="description"/></label></div>
        <div><label> Price: <input type="number" min="0" step="1" name="price"/></label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div><input type="submit" value="Add"/></div>
    </form>
</@c.page>
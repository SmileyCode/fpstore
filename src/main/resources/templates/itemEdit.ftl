<#import "parts/common.ftl" as c>

<@c.page>
<center>
    <div class="profile-block shadowd bgg">
        <div class="container">
            <div class="info">
                <form action="/item/edit" method="post" enctype="multipart/form-data">
                    <li><label> Item Name : <div class="bgw"><input type="text" name="itemname" value="${item.itemname}"/></div></label></li>
                    <li><label> Description : <div class="bgw"><input type="text" name="description" value="${item.description}"/></div></label></li>
                    <li><label> Category: <div class="bgw"><input type="text" name="category" value="${item.category}"/></div></label></li>
                    <li><label> Price: <div class="bgw"><input type="number" min="0" step="1" name="price" value="${item.price}"/></div></label></li>
                    <li><label> Image: <div class="bgw"><input type="file" name="file"></div></label></li>
                    <input type="hidden" name="id" value="${item.id}" />
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <button class="pull-left ed" type="button"><input type="submit" value="Save"/></button>
                </form>
            </div>

        </div>
    </div>
</center>

</@c.page>
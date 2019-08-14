<#import "parts/common.ftl" as c>

    <@c.page>

    <div class="title-block">
        <div class="container">
            <div class="row">
                <div class="col-md-12"><center>ПРОФИЛЬ</center></div>
            </div>
        </div>
    </div>

    <center>
        <div class="profile-block shadowd bgg">
            <div class="container">
                        <div class="info">
                            <form action="/profile/edit" method="post">
                                <li><label> User Name : <div class="bgw"><input type="text" name="username" value="${loggedInUser.user.username}"/></div></label></li>
                                <li><label> Name: <div class="bgw"><input type="text" name="realname" value="${loggedInUser.user.realname}"/></div></label></li>
                                <li><label> Surname: <div class="bgw"><input type="text" name="surname" value="${loggedInUser.user.surname}"/></div></label></li>
                                <li><label> Add. name: <div class="bgw"><input type="text" name="addname" value="${loggedInUser.user.addname}"/></div></label></li>
                                <li><label> Adress: <div class="bgw"><input type="text" name="adress" value="${loggedInUser.user.adress}"/></div></label></li>
                                <li><label> Post code: <div class="bgw"><input type="text" name="postcode" value="${loggedInUser.user.postcode}"/></div></label></li>
                                <li><label> City: <div class="bgw"><input type="text" name="city"  value="${loggedInUser.user.city}"/></div></label></li>
                                <li><label> Country: <div class="bgw"><input type="text" name="country" value="${loggedInUser.user.country}"/></div></label></li>
                                <li><label> Phone number: <div class="bgw"><input type="text" name="phonenumber" value="${loggedInUser.user.phonenumber}"/></div></label></li>
                                <li><label> Password: <div class="bgw"><input type="password" name="password" value="${loggedInUser.user.password}"/></div></label></li>
                                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                                <button class="pull-left ed" type="button"><input type="submit" value="Save"/></button>
                        </div>

            </div>
        </div>
    </center>


</@c.page>
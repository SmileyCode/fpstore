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
        <div class="profile-block">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <a href="/addavatar"><img class="profilePhoto" src="/img/${loggedInUser.user.avatar}" alt="photo"></a>
                    </div>
                    <div class="col-md-6">
                        <div class="info">
                            <li>${loggedInUser.user.surname} ${loggedInUser.user.realname} ${loggedInUser.user.addname}</li>
                            <li>Логин: ${loggedInUser.user.username}</li>
                            <li>E-mail: ${loggedInUser.user.mail}</li>
                            <li>${loggedInUser.user.postcode}, ${loggedInUser.user.city}, ${loggedInUser.user.adress}</li>
                            <li>${loggedInUser.user.phonenumber}</li>
                        </div>
                        <a href="/profile/edit"><button class="pull-left ed" type="button">Изменить</button></a>


                    </div>
                </div>
            </div>
        </div>
    </center>

</@c.page>
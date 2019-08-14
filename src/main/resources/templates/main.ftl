<#import "parts/common.ftl" as c>
<#import "parts/shortcuts.ftl" as s>

<@c.page>


    <div class="title-block">
        <div class="container">
            <div class="row">
                <div class="col-md-12"><center>КАТЕГОРИИ</center></div>
            </div>
        </div>
    </div>

    <div class="cat-block">
        <div class="container">
            <div class="row">
                <@s.cat "/category?category=first" />
                <@s.cat "/category?category=second" />
                <@s.cat "/category" />
                <@s.cat "/category" />
            </div>
        </div>
        <div class="container">
            <div class="row">
                <@s.cat "/category" />
                <@s.cat "/category" />
                <@s.cat "/category" />
                <@s.cat "/category" />
            </div>
        </div>
        <div class="container">
            <div class="row">
                <@s.cat "/category" />
                <@s.cat "/category" />
                <@s.cat "/category" />
                <@s.cat "/category" />
            </div>
        </div>
    </div>

    <div class="pb-5"></div><!--отступ-->
    <div class="title-block">
        <div class="container">
            <div class="row">
                <div class="col-md-12"><center>ТОВАРЫ</center></div>
            </div>
        </div>
    </div>

    <@s.itms />

    <div class="block-stat">
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="stat">
                        <tr>
                            <td><div class="col"><img src="/static/img/stat-items.gif" alt="Товары"></div></td>
                            <td><div class="col greenT">${itemCount}</div></td>
                            <td><div class="col blackT">товаров</div></td>
                        </tr>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="stat">
                        <tr>
                            <td><div class="col"><img src="/static/img/stat-sellers.gif" alt="Покупки"></div></td>
                            <td><div class="col greenT">${reviewCount}</div></td>
                            <td><div class="col blackT">покупок</div></td>
                        </tr>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="stat">
                        <tr>
                            <td><div class="col"><img src="/static/img/stat-users.gif" alt="Пользователи"></div></td>
                            <td><div class="col greenT">${userCount}</div></td>
                            <td><div class="col blackT">пользователей</div></td>
                        </tr>
                    </div>
                </div>
            </div>
        </div>
    </div>


</@c.page>
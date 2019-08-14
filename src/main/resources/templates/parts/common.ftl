<#include "security.ftl">


<#macro page>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Fpstore</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/static/mystyle.css">
</head>
<body>

<center>
    <div class="top-block">
        <header>
            <div class="container">
                <div class="row">
                    <div class="col-md-3"><a href="/"><img src="/static/img/LOGO.gif" alt="logo"></a></div>
                    <div class="col-md-6">
                        <form action="/search" method="get">
                            <div class="searcher-block">
                                <center>

                                        <input type="text" name="search"/>
                                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                                        <button type="submit"><img src="/static/img/btn-search.gif" alt="search"></button>
                                </center>
                            </div>
                        </form>
                    </div>
                    <div class="col-md-3">
                        <form action="#">
                            <div class="login-block">
                                <div class="container">
                                    <#if name != "unknown">
                                        <div class="row">

                                                <nav>
                                                    <ul>
                                                        <li><a href="/profile">Мой профиль</a></li>
                                                        <li><a href="/cart">Корзина</a></li>
                                                        <li><a href="/logout">Выйти</a></li>
                                                    </ul>
                                                </nav>
                                        </div>
                                        <#else>
                                            <nav>
                                                <ul>
                                                    <li><a href="/login">Войти</a></li>
                                                    <li><a href="/registration">Регистрация</a></li>
                                                </ul>
                                            </nav>
                                    </#if>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </header>
    </div>
</center>

<#nested>

    <footer>
        <div class="footer-block">

            <div class="container">
                <div class="row">
                    <div class="col-md-2">
                        <li><a href="#" title="link" class="a">FAQ</a></li>
                        <li><a href="#" title="link" class="a">О нас</a></li>
                        <li><a href="#" title="link" class="a">Как заказать</a></li>
                        <li><a href="#" title="link" class="a">Доставка</a></li>
                        <li><a href="#" title="link" class="a">Сотрудничество</a></li>
                    </div>
                    <div class="col-md-2">
                        <li><a href="#" title="link" class="a">Реклама</a></li>
                        <li><a href="#" title="link" class="a">Защита покупателей</a></li>
                        <li><a href="/additem" title="link" class="a">Добавить товар</a></li>
                    </div>
                    <div class="col-md-6"></div>
                </div>
            </div>
        </div>
        <div class="container author">© 2018 с-ИБС-2. ALL RIGHTS RESERVED</div>
    </footer>
</body>
</html>
</#macro>
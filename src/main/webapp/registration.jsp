<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <!--[if lt IE 9]>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script><![endif]-->
    <title></title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <link href="resources/style.css" rel="stylesheet">
</head>

<body>

<div class="wrapper">

    <header class="header"><a href="/">Главная</a></header><!-- .header-->

    <div class="middle">

        <div class="container">
            <main class="content">

                <form action="/registration" accept-charset="UTF-8" method="post">
                    <a>Логин:</a><br>
                    <input type="text" size="25" name="insertLogin" required><br>
                    <a>Пароль:</a><br>
                    <input type="password" size="25" name="insertPassword" required><br>
                    <a>Подтвердите пароль:</a><br>
                    <input type="password" size="25" name="insertPassword2" required><br>
                    <a>Имя:</a><br>
                    <input type="text" size="25" name="inserFirst" required><br>
                    <a>Фамилия:</a><br>
                    <input type="text" size="25" name="inserLast" required><br>
                    <a>Телефон:</a><br>
                    <input id="telNo" type="tel"
                           placeholder="+7(XXX)XXX-XX-XX" size="25" name="inserPhone" required><br>
                    <a>E-mail:</a><br>
                    <input type="email" placeholder="default@example.com" size="25" name="inserEmail" required><br>
                    <a>Адрес:</a><br>
                    <input type="text" size="25" name="inserAddress" required><br>
                    <%
                        if (("" + request.getParameter("errorCode")).equals("errPassword")) {
                    %>
                    <a style="color: red">Пароли не совпадают!</a>
                    <%}%>
                    <br>
                    <input type="submit" value="Зарегистрироваться">
                </form>

            </main><!-- .content -->
        </div><!-- .container-->

    </div><!-- .middle-->

</div><!-- .wrapper -->

<footer class="footer">
    <strong></strong>
</footer><!-- .footer -->

</body>
</html>

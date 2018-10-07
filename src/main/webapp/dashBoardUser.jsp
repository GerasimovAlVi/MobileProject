<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link href="/resources/style.css" rel="stylesheet">
</head>

<body>

<div class="wrapper">

    <header class="header">
        <strong></strong>
        <div>
            <%if (request.getSession().getAttribute("login") != null) {%>
            Вы вошли как: <%=request.getSession().getAttribute("login")%>
            &nbsp;<a href="/login?action=logout">Выйти</a>
            <%
                }%>
        </div>
    </header><!-- .header-->

    <div class="middle">

        <div class="container">
            <main class="content">

                <strong>...</strong>
            </main><!-- .content -->
        </div><!-- .container-->

        <aside class="left-sidebar">
            <strong></strong>
            <ul>
                <a href="/user/brand">Телефоны по марке</a><br>
                <a href="/user/shoppingCart">Корзина</a><br>
                <a href="/user/orderList">Мои заказы</a>
            </ul>
            <br>

        </aside><!-- .left-sidebar -->

    </div><!-- .middle-->

</div><!-- .wrapper -->

<footer class="footer">
    <strong></strong>
</footer><!-- .footer -->

</body>
</html>

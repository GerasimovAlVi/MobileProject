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
        <br><a href="/user/dashBoard">на главную</a>
    </header><!-- .header-->

    <div class="middle">

        <div class="container">
            <main class="content">

                <%
                    double sumPrice = (double) request.getAttribute("sumPrice");
                    if (sumPrice != 0) {
                %>
                <p>Сумма заказа ${sumPrice} рублей</p><br>
                <form action="/user/order" method="post">
                    <a>Доставка:</a><br>
                    <div>
                        <input type="radio" id="deliveryYes" name="delivery" value="Yes" checked>
                        <label for="deliveryYes">курьером</label>

                        <input type="radio" id="deliveryNo" name="delivery" value="No">
                        <label for="deliveryNo">самовывоз</label>
                    </div>

                    <a>Оплата:</a><br>
                    <div>
                        <input type="radio" id="paidYes" name="paid" value="Yes" checked>
                        <label for="paidYes">на сайте</label>

                        <input type="radio" id="paidNo" name="paid" value="No">
                        <label for="paidNo">при получении</label>
                    </div>

                    <div>
                        <br>
                        <button type="submit">Заказать</button>
                    </div>
                </form>
                <%
                } else {%>
                <br><a>Корзина пуста!</a><br>
                <%}%>

            </main><!-- .content -->
        </div><!-- .container-->

        <aside class="left-sidebar">
            <strong></strong>
            <ul>
                <a href="/user/shoppingCart"><-- назад</a>
            </ul>

        </aside><!-- .left-sidebar -->

    </div><!-- .middle-->

</div><!-- .wrapper -->

<footer class="footer">
    <strong></strong>
</footer><!-- .footer -->

</body>
</html>

<%@ page import="pojo.Smartphone" %>
<%@ page import="java.util.List" %>
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
                <table>
                    <tr>
                        <th>Модель</th>
                        <th>Цена, руб</th>
                        <th>Оперативная память, Гб</th>
                        <th>Встроенная память, Гб</th>
                        <th>Размер экрана, дюйм</th>
                        <th>Разрешение экрана</th>
                        <th>Тип экрана</th>
                        <th>Основная камера, Мп</th>
                        <th>Фронтальная камера, Мп</th>
                        <th>Емкость аккумулятора, мАч</th>
                        <th>Количество SIM-карт</th>
                        <th>Размеры, В×Ш×Т</th>
                        <th>Цвет</th>
                        <th></th>
                    </tr>

                    <%
                        List<Smartphone> smartphoneList = (List<Smartphone>) request.getAttribute("smartphone");
                        for (Smartphone i : smartphoneList) {
                    %>
                    <tr>
                        <td align="center"><%=i.getName()%>
                        </td>
                        <td align="center"><%=i.getPrice()%>
                        </td>
                        <td align="center"><%=i.getRam()%>
                        </td>
                        <td align="center"><%=i.getRom()%>
                        </td>
                        <td align="center"><%=i.getDiagonal()%>
                        </td>
                        <td align="center"><%=i.getScreenResolution()%>
                        </td>
                        <td align="center"><%=i.getScreen().getName()%>
                        </td>
                        <td align="center"><%=i.getCamera()%>
                        </td>
                        <td align="center"><%=i.getCameraFront()%>
                        </td>
                        <td align="center"><%=i.getBatteryCapacity()%>
                        </td>
                        <td align="center"><%=i.getSimCount()%>
                        </td>
                        <td align="center"><%=i.getSize()%>
                        </td>
                        <td align="center"><%=i.getColor()%>
                        </td>
                        <form action="/user/smartphone?id=<%=i.getBrand().getId()%>" method="post">
                            <input type="hidden" name="addInBasket" value="<%=i.getId()%>"/>
                            <td align="center"><input type="submit" value="в корзину"></td>
                        </form>
                    </tr>
                    <%
                        }%>
                </table>
            </main><!-- .content -->
        </div><!-- .container-->

        <aside class="left-sidebar">
            <strong></strong>
            <ul>
                <a href="/user/shoppingCart">корзина</a><br>
                <br>
                <a href="/user/brand"><-назад</a><br>
            </ul>

        </aside><!-- .left-sidebar -->

    </div><!-- .middle-->

</div><!-- .wrapper -->

<footer class="footer">
    <strong></strong>
</footer><!-- .footer -->

</body>
</html>

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
                <%
                    List<Smartphone> smartphoneList = (List<Smartphone>) request.getAttribute("shoppingCartViev");
                    if (smartphoneList != null) {
                %>
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
                    <% for (Smartphone i : smartphoneList) {%>

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
                        <form action="/user/shoppingCart" method="post">
                            <input type="hidden" name="deleteInBasket" value="<%=i.getId()%>"/>
                            <td align="center"><input type="submit" value="удалить"></td>
                        </form>
                    </tr>
                    <%
                        }
                    } else {%>
                    <br><a>Корзина пуста!</a>
                    <%}%>
                </table>
            </main><!-- .content -->
        </div><!-- .container-->

        <aside class="left-sidebar">
            <strong></strong>
            <ul>
                <a href="/user/order">Оформить заказ</a><br><br>
                <a href="/user/dashBoard">на главную</a>
            </ul>

        </aside><!-- .left-sidebar -->

    </div><!-- .middle-->

</div><!-- .wrapper -->

<footer class="footer">
    <strong></strong>
</footer><!-- .footer -->

</body>
</html>

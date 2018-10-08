<%@ page import="pojo.Order" %>
<%@ page import="pojo.Smartphone" %>
<%@ page import="java.util.List" %>
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
                    List<Order> orderList = (List<Order>) request.getAttribute("order");
                    for (int i = 0; i < orderList.size(); i++) {
                        double summ = 0;
                %>
                <p>Заказ № <%=orderList.get(i).getId()%>
                </p>
                <table>
                    <tr>
                        <th>Марка</th>
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
                    </tr>
                    <%
                        List<Smartphone> smartphoneList = (List<Smartphone>) request.getAttribute("smartphone" + orderList.get(i).getId());
                        for (Smartphone j : smartphoneList) {
                            summ += j.getPrice();
                    %>
                    <tr>
                        <td align="center"><%=j.getBrand().getName()%>
                        </td>
                        <td align="center"><%=j.getName()%>
                        </td>
                        <td align="center"><%=j.getPrice()%>
                        </td>
                        <td align="center"><%=j.getRam()%>
                        </td>
                        <td align="center"><%=j.getRom()%>
                        </td>
                        <td align="center"><%=j.getDiagonal()%>
                        </td>
                        <td align="center"><%=j.getScreenResolution()%>
                        </td>
                        <td align="center"><%=j.getScreen().getName()%>
                        </td>
                        <td align="center"><%=j.getCamera()%>
                        </td>
                        <td align="center"><%=j.getCameraFront()%>
                        </td>
                        <td align="center"><%=j.getBatteryCapacity()%>
                        </td>
                        <td align="center"><%=j.getSimCount()%>
                        </td>
                        <td align="center"><%=j.getSize()%>
                        </td>
                        <td align="center"><%=j.getColor()%>
                        </td>
                    </tr>
                    <%}%>
                    <p>Сумма заказа: <%=summ%>
                    </p>
                    <form action="/user/orderList" method="post">
                        <input type="hidden" name="cancel" value="<%=orderList.get(i).getId()%>"/>
                        <input type="submit" value="отменить">
                    </form>
                </table>
                <br><br>
                <%}%>

            </main><!-- .content -->
        </div><!-- .container-->

        <aside class="left-sidebar">
            <strong></strong>
            <ul>
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


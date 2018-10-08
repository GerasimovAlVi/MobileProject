<%@ page import="pojo.Brand" %>
<%@ page import="pojo.Screen" %>
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
        <br><a href="/admin/dashBoard">на главную</a>
    </header><!-- .header-->

    <div class="middle">

        <div class="container">
            <main class="content">
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
                        <th>Количество на складе</th>
                    </tr>

                    <%
                        List<Smartphone> smartphoneList = (List<Smartphone>) request.getAttribute("smartphone");
                        for (Smartphone i : smartphoneList) {
                    %>
                    <tr>
                        <td align="left"><%=i.getBrand().getName()%>
                        </td>
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
                        <td align="right"><%=i.getCount()%>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </table>

            </main><!-- .content -->
        </div><!-- .container-->

        <aside class="left-sidebar">
            <strong></strong>
            <ul>
                <form action="/admin/smartphone" method="post">
                    <a>Добавить:</a><br><br>
                    <a>Марка:</a><br>
                    <select name="inserBrand">
                        <%
                            List<Brand> brandList = (List<Brand>) request.getAttribute("brand");
                            for (Brand i : brandList) {
                        %>
                        <option><%=i.getName()%>
                        </option>
                        <%}%>
                    </select><br>
                    <a>Модель:</a><br>
                    <input type="text" size="16" name="insertName"><br>
                    <a>Цена, руб:</a><br>
                    <input type="text" size="16" name="inserPrace"><br>
                    <a>Оперативная память, Гб:</a><br>
                    <input type="text" size="16" name="inserRam"><br>
                    <a>Встроенная память, Гб:</a><br>
                    <input type="text" size="16" name="inserRom"><br>
                    <a>Размер экрана, дюйм:</a><br>
                    <input type="text" size="16" name="inserDiagonal"><br>
                    <a>Разрешение экрана:</a><br>
                    <input type="text" size="16" name="inserScreenResolution"><br>
                    <a>Тип экрана:</a><br>
                    <select name="inserScreen">
                        <%
                            List<Screen> screenList = (List<Screen>) request.getAttribute("screen");
                            for (Screen i : screenList) {
                        %>
                        <option><%=i.getName()%>
                        </option>
                        <%}%>
                    </select><br>
                    <a>Основная камера, Мп:</a><br>
                    <input type="text" size="16" name="inserCamera"><br>
                    <a>Фронтальная камера, Мп:</a><br>
                    <input type="text" size="16" name="inserCameraFront"><br>
                    <a>Емкость аккумулятора, мАч:</a><br>
                    <input type="text" size="16" name="inserBatteryCapacity"><br>
                    <a>Количество SIM-карт:</a><br>
                    <input type="text" size="16" name="inserSimCount"><br>
                    <a>Размеры, В×Ш×Т:</a><br>
                    <input type="text" size="16" name="inserSize"><br>
                    <a>Цвет:</a><br>
                    <input type="text" size="16" name="inserColor"><br>
                    <a>Количество на складе:</a><br>
                    <input type="text" size="16" name="inserCount"><br>
                    <input type="submit" value="Добавить">
                </form>
                <br><a href="/admin/brand"><-назад</a>
            </ul>

        </aside><!-- .left-sidebar -->

    </div><!-- .middle-->

</div><!-- .wrapper -->

<footer class="footer">
    <strong></strong>
</footer><!-- .footer -->

</body>
</html>

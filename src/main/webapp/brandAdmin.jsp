<%@ page import="pojo.Brand" %>
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
                <strong>...</strong>
            </main><!-- .content -->
        </div><!-- .container-->

        <aside class="left-sidebar">
            <strong></strong>
            <ul>
                <table>
                    <tr>
                        <th>Марка</th>
                    </tr>

                    <%
                        List<Brand> brandList = (List<Brand>) request.getAttribute("brand");
                        for (Brand i : brandList) {
                    %>
                    <tr>
                        <td><a href="/admin/smartphone?id=<%=i.getId()%>"><%=i.getName()%>
                        </a></td>
                    </tr>
                    <%
                        }
                    %>
                </table>
                <br>
                <form action="/admin/brand" method="post">
                    <a>Добавить:</a><br>
                    <input type="text" size="16" name="insertBrand">
                    <input type="submit" value="Добавить"><br><br>
                    <a href="/admin/dashBoard"><-назад</a><br>
                </form>
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

<%@ page import="pojo.Brand" %>
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
    <link href="resources/style.css" rel="stylesheet">
</head>

<body>

<div class="wrapper">

    <header class="header"><a href="/">Главная</a></header><!-- .header-->

    <div class="middle">

        <div class="container">
            <main class="content">
                <strong>...</strong>
            </main><!-- .content -->
        </div><!-- .container-->

        <aside class="left-sidebar">
            <strong>Марка:</strong>
            <br>
            <table>
                <%
                    List<Brand> brandList = (List<Brand>) request.getAttribute("brand");
                    for (Brand i : brandList) {
                %>
                <tr>
                    <td><a href="/smartphone?id=<%=i.getId()%>"><%=i.getName()%>
                    </a></td>
                </tr>
                <%
                    }
                %>
            </table>
            <br>
            <a href="/"><-назад</a>

        </aside><!-- .left-sidebar -->

    </div><!-- .middle-->

</div><!-- .wrapper -->

<footer class="footer">
    <strong></strong>
</footer><!-- .footer -->

</body>
</html>

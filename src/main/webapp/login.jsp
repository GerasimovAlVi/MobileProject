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

    <header class="header">
        <strong></strong>
        <form action="/login" method="post">
            <br>
            <a>Логин:</a>
            <%
                switch ("" + request.getParameter("errorCode")) {
                    case "wrongLogin":
            %>
            <a style="color: red">Пользователь не найден!</a>
            <% break;
                case "accessDenied":%>
            <a style="color: red">:Доступ запрещен!</a>
            <% break;
            }
            %>
            <a><font color="red">${error}</font></a>
            <br>
            <input type="text" name="login"><br>
            <a>Пароль:</a><br>
            <input type="password" name="password"><br><br>
            <input type="submit">
        </form>
    </header><!-- .header-->

    <div class="middle">

        <div class="container">
            <main class="content">

<%@include file="footer.jsp" %>
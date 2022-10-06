<%@ page import="model.Users" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 05/10/2022
  Time: 11:31 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Index</title>
    <%@include file="css.jsp"%>
<%--<link rel="stylesheet" type="text/css" href="css/styles.css">--%>
    <style type="text/css">
        .back-img{
            background: url("img/e-wallet-service-isometric.jpg");
            height: 70vh;
            width: 100%;
            background-size: cover;
        }
        .crd-ho:hover{
            background-color: #f5f5f5;
        }
        H2{

            color: #F34093;
        }
    </style>

</head>
<body>
<%--<body style="background-color: #dec3c3">--%>

<%
    Users u=(Users)session.getAttribute("userobj");
%>

<%@include file="navbar.jsp"%>
<div class="container-fluid back-img">
    <h2 class="text-center">E-Wallet Management System</h2>
</div>

<section class="services" id="services">
    <div class="center">
        <h3>WHAT WE HAVE ?</h3>
    </div>
    <div class="service-content">
        <div class="col">
            <i class="bx bx-cast"></i>
            <h3> Web Development</h3>
            <p>There are many variations of passages of Loem Ipsum variable, but the majority have
                suffered.</p>
        </div>
        <div class="col">
            <i class="bx bx-layer"></i>
            <h3> Web Development</h3>
            <p>There are many variations of passages of Loem Ipsum variable, but the majority have
                suffered.</p>
        </div>
        <div class="col">
            <i class="bx bx-user-voice"></i>
            <h3> Web Development</h3>
            <p>There are many variations of passages of Loem Ipsum variable, but the majority have
                suffered.</p>
        </div>
        <div class="col">
            <i class="bx bx-desktop"></i>
            <h3> Web Development</h3>
            <p>There are many variations of passages of Loem Ipsum variable, but the majority have
                suffered.</p>
        </div>
        <div class="col">
            <i class="bx bx-camera"></i>
            <h3> Web Development</h3>
            <p>There are many variations of passages of Loem Ipsum variable, but the majority have
                suffered.</p>
        </div>
        <div class="col">
            <i class="bx bx-line-chart"></i>
            <h3> Web Development</h3>
            <p>There are many variations of passages of Loem Ipsum variable, but the majority have
                suffered.</p>
        </div>

    </div>
</section>
<div class="container-fluid text-center text-white p-3 mt-2" style="background-color: green">
    <h5><i class="fa-solid fa-copyright"></i> Designed and Developed By Team</h5>
</div>
</body>
</html>

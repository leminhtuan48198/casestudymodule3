<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>DetailMoney Management Application</title>
</head>
<body>
<center>
    <h1>DetailMoney Management</h1>
    <h2>
        <a href="/detailMoneys?action=createIn">Add New  Money Input </a>
    </h2>
    <h2>
        <a href="/detailMoneys?action=createOut">Add New  Money Output </a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of DetailMoneys</h2></caption>
        <tr>
            <th>idDetail</th>
            <th>id_wallet</th>
            <th>money</th>
            <th>id_category</th>
            <th>note</th>
            <th>date</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="detailMoney" items="${listDetailMoney}">
            <tr>
                <td><c:out value="${detailMoney.idDetail}"/></td>
                <td><c:out value="${detailMoney.id_wallet}"/></td>
                <td><c:out value="${detailMoney.money}"/></td>
                <td><c:out value="${detailMoney.id_category}"/></td>
                <td><c:out value="${detailMoney.note}"/></td>
                <td><c:out value="${detailMoney.date}"/></td>
                <td>
                    <a href="/detailMoneys?action=edit&id=${detailMoney.idDetail}">Edit</a>
                    <a href="/detailMoneys?action=delete&id=${detailMoney.idDetail}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
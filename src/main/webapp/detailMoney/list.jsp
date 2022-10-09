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
        <a href="/detailMoneys?action=createIn">Add New  Money Income </a>
    </h2>
    <h2>
        <a href="/detailMoneys?action=createOut">Add New  Money Outcome </a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of DetailMoneys</h2></caption>
        <tr>
            <th>idDetail</th>
            <th>wallet</th>
            <th>money</th>
            <th>category</th>
            <th>note</th>
            <th>date</th>
            <th>Actions</th>
        </tr>
        <c:forEach  var="detailMoney" items="${listDetailMoney}">
            <tr>
                <td><c:out value="${detailMoney.idDetail}"/></td>
                <td><c:out value="${detailMoney.name_wallet}"/></td>
                <td><c:out value="${detailMoney.money}"/></td>

                <td><c:if test="${detailMoney.money<0}">
                    <c:out value="${detailMoney.name_category}"/>
                </c:if>

                </td>
                <td><c:out value="${detailMoney.note}"/></td>
                <td><c:out value="${detailMoney.date}"/></td>
                <td><c:if test="${detailMoney.money>0}">
                    <a href="/detailMoneys?action=editAdd&id=${detailMoney.idDetail}">Change Add
                    </a>
                </c:if>
                    <c:if test="${detailMoney.money<0}">
                        <a href="/detailMoneys?action=editSub&id=${detailMoney.idDetail}">Change Sub</a>
                    </c:if>


                    <a href="/detailMoneys?action=delete&id=${detailMoney.idDetail}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<a href="/detailMoneys?action=sortByDate" >sort By Date Increase </a>
<br>
<a href="/detailMoneys?action=reverseDate">sort By Date Decrease</a>
<br>
<a href="detailMoneys?action=statisticRangeDate">statistic Range Date</a>
</body>
</html>
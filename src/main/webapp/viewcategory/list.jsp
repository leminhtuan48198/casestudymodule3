<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Insert title here</title>
  <%@include file="/css.jsp"%>
  <styte>
    table {
    width: 100%;
    font-family: arial, sans-serif;
    border-collapse: collapse;
    }
    th, td {
    padding: 8px;
    text-align: left;
    border-top: 1px solid #dee2e6;
    }
  </styte>
</head>
<body style="background-color: #f0fcff;">
<c:if test="${empty userobj }">
  <c:redirect url="/login.jsp"></c:redirect>
</c:if>

<%@include file="/navbar.jsp"%>
<h1 align="center" >Category Manager</h1>
<div class="wrapper" align="center" >
  <h2 style="text-align: right " > <a href="/categorys?action=create"> Create new category </a></h2>
  <table border="1px"  width="700px"  style="font-size: 30px ">
    <%--    <caption><h2>List Catalog </h2></caption>--%>
    <tr align="center" >
      <th align="center">Name</th>
      <th align="center">Note</th>
      <th align="center">Function</th>
    </tr>
    <c:forEach var="category" items="${categoryList}">
      <tr>
        <td style="text-align: left" ><c:out value="${category.name}"/></td>
        <td style="text-align: left"><c:out value="${category.note}"/></td>
        <td align="center">
          <a href="/categorys?action=edit&idCategory=${category.idCategory}">Edit</a>
          <a href="/categorys?action=delete&idCategory=${category.idCategory}">Delete</a>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>

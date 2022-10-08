<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Insert title here</title>
  <%@include file="/css.jsp"%>
</head>
<body style="background-color: #f0fcff;">
<c:if test="${empty userobj }">
  <c:redirect url="/login.jsp"></c:redirect>
</c:if>

<%@include file="/navbar.jsp"%>
<h1 align="center" >Catalog Manager</h1>
<div align="center" >
  <h2><a href="/categorys?action=create"> Create new category </a></h2>
  <table border="1">
    <caption><h2>List Catalog </h2></caption>
    <tr>
      <th>Catalog</th>
      <th>Note</th>
      <th>Function</th>
    </tr>
    <c:forEach var="category" items="${categoryList}">
      <tr>
        <td><c:out value="${category.name}"/></td>
        <td><c:out value="${category.note}"/></td>
        <td>
          <a href="/categorys?action=edit&idCategory=${category.idCategory}">Edit</a>
          <a href="/categorys?action=delete&idCategory=${category.idCategory}">Delete</a>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>

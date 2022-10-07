<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
  <title>List Catalog</title>
</head>
<body>
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
          <a href="/categorys?action=edit&id=${category.idCategory}">Edit</a>
          <a href="/categorys?action=delete&id=${category.idCategory}">Delete</a>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>

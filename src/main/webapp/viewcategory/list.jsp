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
<h1 align="center" >Category Manager</h1>
<div class="wrapper" align="center" >
  <h2 align="center" > <a href="/categorys?action=create"> <input type="button" value="Create new category">  </a></h2>
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
          <a href="/categorys?action=edit&idCategory=${category.idCategory}"> <input type="button" value="Edit"> </a>
          <a href="/categorys?action=delete&idCategory=${category.idCategory}">  <input type="button" value="Delete"></a>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>
<div class="container-fluid text-center text-white p-3 mt-2" style="background-color: green">
  <h5><i class="fa-solid fa-copyright"></i> Designed and Developed By Team</h5>
</div>
</body>
</html>

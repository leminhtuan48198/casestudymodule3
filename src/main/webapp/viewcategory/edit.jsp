<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Category</title>
</head>
<body>
<center>
    <h1>Edit</h1>
    <h2>
        <a href="/categorys?action=categorys">Return Category</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <c:if test="${showCategory != null}">
                <input type="hidden" name="idCategory" value="<c:out value='${showCategory.idCategory}' />"/>
            </c:if>
            <tr>
                <th>Category Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${showCategory.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Category Note:</th>
                <td>
                    <input type="text" name="note" size="45"
                           value="<c:out value='${showCategory.note}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

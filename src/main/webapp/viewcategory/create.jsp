<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Category</title>
</head>
<body>
<div>
    <h1>Create New Category </h1>
    <h2>   <a href="/categorys?action=categorys">Return Category</a> </h2>
    <div align="center">
        <form method="post">
            <table>
                <tr>
                    <th>Name:</th>
                    <td>
                        <input type="text" name="name" id="name" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>Note:</th>
                    <td>
                        <input type="text" name="note" id="note" size="45"/>
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
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2/4/2023
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<c:forEach items="${condimentList}" var="condimentlist">
    <table>
        <tr>
            <c:forEach items="${condimentlist}" var="condiment">
                <td>
                        ${condiment}
                </td>
            </c:forEach>
        </tr>
    </table>

</c:forEach>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2/6/2023
  Time: 8:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Settings</h2>
<form:form method="post" action="/result" modelAttribute="setting">
    <table>
        <tr>
            <td><label>Languages: </label></td>
            <td>
                <form:select path="languages">
                    <form:options items="${listLanguage}"></form:options>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><label>Page size: </label></td>
            <td>
                <form:select path="size">
                    <form:options items="${listSize}"></form:options>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><label>Spams filter: </label></td>
            <td>
                <form:checkboxes path="filter" items="${filter}"></form:checkboxes>
            </td>
        </tr>
        <tr>
            <td><label>Signature: </label></td>
            <td><form:input path="signature"></form:input></td>
        </tr>
        <tr>
            <td></td>
            <td style="text-align: right"><form:button>Update</form:button></td>
        </tr>
    </table>
</form:form>
</body>
</html>

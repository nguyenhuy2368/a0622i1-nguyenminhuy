<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2/11/2023
  Time: 4:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Tờ khai</title>
    <style>
        .full{
            width: 100%;
        }
        .half{
            width: 50%;
        }

    </style>
</head>
<body>
<h2 style="width: 100%; text-align: center">TỜ KHAI Y TẾ</h2>



<form:form action="/save" method="post" modelAttribute="medical">
    <div class="full">
        <span>Họ tên (ghi chữ IN HOA)</span>
        <span> (*)</span>
        <form:input path="name" cssClass="full" required="required"></form:input>
    </div>
    <br><br>
    <div class="full">
        <div style="width: 33.33%">
            <span>Năm sinh</span>
            <span class="red">(*)</span>
            <form:select path="yearBirth" cssClass="full">
                <form:options items="${yearBirth}"></form:options>
            </form:select>
        </div>

        <div style="width: 33.33%">
            <span>Giới tính</span>
            <span>(*)</span>
            <form:select path="gender" cssClass="full">
                <form:option value="true">Nam</form:option>
                <form:option value="false">Nữ</form:option>
            </form:select>
        </div>

        <div style="width: 33.33%">
            <span>Quốc gia</span>
            <span>(*)</span>
            <form:select path="nationality" cssClass="full">
                <form:options items="${nationality}"></form:options>
            </form:select>
        </div>
    </div>
    <br><br><br><br>

    <div class="full">
        <span>Số hộ chiếu hoặc số CCCD hoặc giấy thông hành hợp pháp khác</span>
        <span> (*)</span>
        <form:input path="citizenId" cssClass="full" required="required"/>
    </div>
    <br><br>
    <div class="full">
        <span>Thông tin đi lại</span>
        <span> (*)</span> <br>
        <form:radiobuttons path="vehicle" items="${vehicle}" required="required"></form:radiobuttons>
    </div>
    <br><br>
    <div class="full">
        <span>Số hiệu phương tiện</span>
        <form:input path="vehicleId" cssClass="full"></form:input>
    </div>
    <br><br><br><br>
    <div class="full">
        <div class="half">
            <span>Ngày khời hành</span>
            <span> (*)</span>
            <form:input path="startDate" type="date" cssClass="full" required="required"></form:input>
        </div>
        <div class="half">
            <span>Ngày kết thúc</span>
            <span> (*)</span>
            <form:input path="endDate" type="date" cssClass="full" required="required"></form:input>
        </div>
    </div>
    <br><br>
    <form:button>Save</form:button>
</form:form>
</body>
</html>

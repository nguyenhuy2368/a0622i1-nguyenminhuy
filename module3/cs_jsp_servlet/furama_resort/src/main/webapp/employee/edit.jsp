<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 1/6/2023
  Time: 12:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        .container {
            margin: auto;
            width: 60%;
        }

        #h3 {
            width: 380px;
            color: goldenrod;
            padding-bottom: 20px;
            border-top-width: 20px;
        }
    </style>
</head>
<body>
<div class="container-fluid mt-3 container">
    <h3 class="mb-2 container" id="h3">Edit Employee</h3>
    <form method="post" action="/employee?action=edit">
        <input type="hidden" value="${employee.getId()}" name="id">
        <div class="form-row">
            <div class="form-group col-sm-4">
                <label>Name</label>
                <input type="text" class="form-control" name="name" value="${employee.getName()}">
            </div>
            <div class="form-group col-sm-4">
                <label>Email</label>
                <input type="email" class="form-control" name="email" value="${employee.getEmail()}">
            </div>
            <div class="form-group col-sm-4">
                <label>Id-Card</label>
                <input type="text" class="form-control" name="idCard" value="${employee.getIdCard()}">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-sm-4">
                <label>Number Phone</label>
                <input type="text" class="form-control" name="phone" value="${employee.getPhone()}">
            </div>
            <div class="form-group col-sm-5">
                <label>Date-brithday</label>
                <div class="form-group">
                    <div id="filterDate2">
                        <!-- Datepicker as text field -->
                        <div class="input-group date" data-date-format="yyyy/mm/dd">
                            <input type="text" class="form-control" name="birthday" value="${employee.getBirthday()}">
                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-th"></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-group col-sm-3">
                <label>Username</label>
                <select class="form-control" name="username">
                    <c:choose>
                        <c:when test='${employee.getUser().getUsername()=="admin"}'>
                            <option selected value="admin">Admin...</option>
                        </c:when>
                        <c:when test='${employee.getUser().getUsername()=="employee"}'>
                            <option selected value="employee">Employee...</option>
                        </c:when>
                        <c:when test='${employee.getUser().getUsername()=="manager"}'>
                            <option selected value="manager">Manager...</option>
                        </c:when>
                    </c:choose>
                    <option value="admin">Admin</option>
                    <option value="employee">Employee</option>
                    <option value="manager">Manager</option>
                </select>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-sm-9">
                <%--@declare id="inputaddress"--%><label for="inputAddress">Address</label>
                <input type="text" class="form-control" id="myAddress" name="address" value="${employee.getAddress()}">
            </div>
            <div class="form-group col-sm-3">
                <label>Salary</label>
                <input type="number" class="form-control" name="salary" value="${employee.getSalary()}">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-sm-4">
                <label>Position</label>
                <select class="form-control" name="positionId">

                    <c:choose>
                        <c:when test="${employee.getPosition().getId()==1}">
                            <option selected value="1">Lễ tân...</option>
                        </c:when>
                        <c:when test="${employee.getPosition().getId()==2}">
                            <option selected value="2">Phục vụ...</option>
                        </c:when>
                        <c:when test="${employee.getPosition().getId()==3}">
                            <option selected value="3">Chuyên viên...</option>
                        </c:when>
                        <c:when test="${employee.getPosition().getId()==4}">
                            <option selected value="4">Giám sát...</option>
                        </c:when>
                        <c:when test="${employee.getPosition().getId()==5}">
                            <option selected value="5">Quản lý...</option>
                        </c:when>
                        <c:when test="${employee.getPosition().getId()==6}">
                            <option selected value="6">Giám đốc...</option>
                        </c:when>
                    </c:choose>
                    <option value="1">Lễ tân</option>
                    <option value="2">Phục vụ</option>
                    <option value="3">Chuyên viên</option>
                    <option value="4">Giám sát</option>
                    <option value="5">Quản lý</option>
                    <option value="6">Giám đốc</option>
                </select>
            </div>
            <div class="form-group col-sm-4">
                <label>Education Degree</label>
                <select class="form-control" name="educationDegreeId">
                    <c:choose>
                        <c:when test="${employee.getEducationDegree().getId()==1}">
                            <option selected value="1">Trung cấp...</option>
                        </c:when>
                        <c:when test="${employee.getEducationDegree().getId()==2}">
                            <option selected value="2">Cao đẳng...</option>
                        </c:when>
                        <c:when test="${employee.getEducationDegree().getId()==3}">
                            <option selected value="3">Đại học...</option>
                        </c:when>
                        <c:when test="${employee.getEducationDegree().getId()==4}">
                            <option selected value="4">sau Đại học...</option>
                        </c:when>
                    </c:choose>
                    <option value="1">Trung cấp</option>
                    <option value="2">Cao đẳng</option>
                    <option value="3">Đại học</option>
                    <option value="4">sau Đại học</option>
                </select>
            </div>
            <div class="form-group col-sm-4">
                <label>Divition</label>
                <select class="form-control" name="divitionId">
                    <c:choose>
                        <c:when test="${employee.getDivition().getId()==1}">
                            <option selected value="1">Sale-Marketing...</option>
                        </c:when>
                        <c:when test="${employee.getDivition().getId()==2}">
                            <option selected value="2">Hành chính...</option>
                        </c:when>
                        <c:when test="${employee.getDivition().getId()==3}">
                            <option selected value="3">Phục vụ...</option>
                        </c:when>
                        <c:when test="${employee.getDivition().getId()==4}">
                            <option selected value="4">Quản lý...</option>
                        </c:when>
                    </c:choose>
                    <option value="1">Sale-Marketing</option>
                    <option value="2">Hành chính</option>
                    <option value="3">Phục vụ</option>
                    <option value="4">Quản lý</option>
                </select>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-sm-11 button_top">
                <a href="/employee">
                    <button type="button" class="btn btn-secondary">Back</button>
                </a>
            </div>
            <div class="form-group col-sm-1 button_top form-row">
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Update</button>
                </div>
            </div>
        </div>

    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
</body>
</html>

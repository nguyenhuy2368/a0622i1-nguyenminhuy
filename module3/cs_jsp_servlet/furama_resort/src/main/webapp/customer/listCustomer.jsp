<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 1/4/2023
  Time: 6:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Customers</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        .button_top {
            text-align: center;
            padding-top: 50px;
            padding-bottom: 50px;
        }

        .content_table {
            text-align: center;
        }

        .form_search {
            margin-left: 500px;
            margin-right: 500px;
        }

    </style>
</head>
<body>
<div class="button_top">
    <a href="/homePage">
        <button type="button" class="btn btn-secondary">Back to Home Page</button>
    </a>
    <a href="/customer?action=create">
        <button type="button" class="btn btn-success" style="color: yellow">Create
            customer
        </button>
    </a>

</div>
<form class="d-flex form_search" method="post" action="/customer?action=findCustomerById">
    <input class="form-control me-2" type="text" placeholder="Search Name" name="name" value="${findName}" aria-label="Search">
    <button class="btn btn-outline-success" type="submit">Search</button>
</form>

<div class="content_table">
    <h3 style="color: darkred; padding-bottom: 20px">List customers</h3>
    <table id="tableCustomer" class="table table-hover table-bordered" style="width: 100%">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Type</th>
            <th>Birthday</th>
            <th>Gender</th>
            <th>Email</th>
            <th>Address</th>
            <th></th>
            <th></th>
            <td></td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listCustomer}" var="customer">
            <tr>
                <td>${customer.getId()}</td>
                <td>${customer.getName()}</td>
                <td>${customer.getCustomerType().getName()}</td>
                <td>${customer.getBirthday()}</td>
                <td>
                    <c:choose>
                        <c:when test="${customer.getGender()==0}">Female</c:when>
                        <c:when test="${customer.getGender()==1}">Male</c:when>
                        <c:when test="${customer.getGender()==2}">LGBT</c:when>
                    </c:choose>
                </td>
                <td>${customer.getEmail()}</td>
                <td>${customer.getAddress()}</td>
                <td>
                    <a class="btn btn-primary" id="show" href="" data-toggle="modal"
                       data-target="#modelShow"
                       onclick="Value('${customer.getId()}','${customer.getName()}','${customer.getCustomerType().getName()}','${customer.getBirthday()}','${customer.getGender()}','${customer.getIdCard()}','${customer.getPhone()}','${customer.getEmail()}','${customer.getAddress()}')">
                        Show</a>
                </td>
                <td>
                    <a href="/customer?action=edit&id=${customer.getId()}">
                        <button class="btn btn-warning">Edit</button>
                    </a>
                </td>
                <td>
                    <a class="btn btn-danger" href="#" role="button" data-toggle="modal"
                       data-target="#modelDelete"
                       onClick="onDelete('${customer.getId()}');nameDelete('${customer.getName()}')">
                        Delete
                    </a>
                </td>
            </tr>
        </c:forEach>
        <c:if test="${listCustomerFindByName!=null}">
            <c:forEach items="${listCustomerFindByName}" var="customer">
                <tr>
                    <td>${customer.getId()}</td>
                    <td>${customer.getName()}</td>
                    <td>${customer.getCustomerType().getName()}</td>
                    <td>${customer.getBirthday()}</td>
                    <td>
                        <c:choose>
                            <c:when test="${customer.getGender()==0}">Female</c:when>
                            <c:when test="${customer.getGender()==1}">Male</c:when>
                            <c:when test="${customer.getGender()==2}">LGBT</c:when>
                        </c:choose>
                    </td>
                    <td>${customer.getEmail()}</td>
                    <td>${customer.getAddress()}</td>
                    <td>
                        <a class="btn btn-primary" id="show" href="" data-toggle="modal"
                           data-target="#modelShow"
                           onclick="Value('${customer.getId()}','${customer.getName()}','${customer.getCustomerType().getName()}','${customer.getBirthday()}','${customer.getGender()}','${customer.getIdCard()}','${customer.getPhone()}','${customer.getEmail()}','${customer.getAddress()}')">
                            Show</a>
                    </td>
                    <td>
                        <a href="/customer?action=edit&id=${customer.getId()}">
                            <button class="btn btn-warning">Edit</button>
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-danger" href="#" role="button" data-toggle="modal"
                           data-target="#modelDelete"
                           onClick="onDelete('${customer.getId()}');nameDelete('${customer.getName()}')">
                            Delete
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
</div>

<div class="modal fade" id="modelShow" tabindex="-1" role="dialog"
     aria-labelledby="modelTitleId" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Information Customer</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <table class="table table-striped table-hover">
                    <%--@declare id=""--%>
                    <tr>
                        <th><label for="">ID:</label></th>
                        <td><span id="idShow"></span></td>
                    </tr>
                    <tr>
                        <th><label for="">Name:</label></th>
                        <td><span id="nameShow"></span></td>
                    </tr>
                    <tr>
                        <th><label for="">Type:</label></th>
                        <td><span id="typeNameShow"></span></td>
                    </tr>
                    <tr>
                        <th><label for="">Date:</label></th>
                        <td><span id="birthdayShow"></span></td>
                    </tr>
                    <tr>
                        <th><label for="">Gender:</label></th>
                        <td><span id="genderShow"></span></td>
                    </tr>
                    <tr>
                        <th><label for="">Id card:</label></th>
                        <td><span id="idCardShow"></span></td>
                    </tr>
                    <tr>
                        <th><label for="">Number phone:</label></th>
                        <td><span id="phoneShow"></span></td>
                    </tr>
                    <tr>
                        <th><label for="">Email:</label></th>
                        <td><span id="emailShow"></span></td>
                    </tr>
                    <tr>
                        <th><label for="">Address:</label></th>
                        <td><span id="addressShow"></span></td>
                    </tr>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>


<!-- Modal Delete-->
<div class="modal fade" id="modelDelete" tabindex="-1" role="dialog"
     aria-labelledby="modelTitleId" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Xác nhận xóa khách hàng</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="/customer">
                <input type="hidden" name="id" id="idCustomer">
                <input type="hidden" name="action" value="delete">

                <div class="modal-body">
                    <p id="body"></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">
                        Cancel
                    </button>
                    <button type="submit" class="btn btn-danger">Delete</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>

<script src="../lib/js/jquery-3.5.1.min.js"></script>
<script src="../lib/js/bootstrap.js"></script>
<script src="../lib/datatables/js/jquery.dataTables.js"></script>
<script src="../lib/datatables/js/dataTables.bootstrap4.js"></script>
<script>
    // show list customer
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            'pageLength': 3
        })
    });

    //show Infomation Customer
    function Value(id, name, typeName, birthday, gender, idCard, phone, email, address) {
        document.getElementById("idShow").innerHTML = id;
        document.getElementById("nameShow").innerHTML = name;
        document.getElementById("typeNameShow").innerHTML = typeName;
        document.getElementById("birthdayShow").innerHTML = birthday;
        document.getElementById("idCardShow").innerHTML = idCard;
        document.getElementById("phoneShow").innerHTML = phone;
        document.getElementById("emailShow").innerHTML = email;
        document.getElementById("addressShow").innerHTML = address;
        switch (gender) {
            case "0":
                gender = "Female";
                break;
            case "1":
                gender = "Male";
                break;
            case "2":
                gender = "LGBT";
                break;
        }
        document.getElementById("genderShow").innerHTML = gender;
    }

    function onDelete(idDelete) {
        document.getElementById("idCustomer").value = idDelete;
    }

    function nameDelete(nameDelete) {
        document.getElementById("body").innerText = "Bạn có muốn xóa: " + nameDelete + " ?";
    }

    // message Create/edit/delete
    window.setTimeout(function () {
        $(".alert").fadeTo(500, 0).slideUp(500, function () {
            $(this).remove();
        });
    }, 4000);
</script>
</body>
</html>

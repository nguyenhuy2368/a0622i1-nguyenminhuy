<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 1/9/2023
  Time: 5:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
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
    <h3 class="mb-2 container" id="h3">Add new Product</h3>

    <%--    <c:if test="${error!=null}">--%>
    <%--        <div class="alert alert-danger" role="alert">--%>
    <%--            Wrong ${error} format... Please re-fill !!!--%>
    <%--        </div>--%>
    <%--    </c:if>--%>
    <%--    <c:if test="${errorNull!=null}">--%>
    <%--        <div class="alert alert-danger" role="alert">${errorNull}</div>--%>
    <%--    </c:if>--%>
    <form method="post" action="/product?action=create">
        <div class="form-row">
            <div class="form-group col-sm-4">
                <label>Name</label>
                <input type="text" class="form-control" name="name" value="${product.getName()}"
                       placeholder="Nguyễn Văn A">
            </div>
            <div class="form-group col-sm-4">
                <label>Count</label>
                <input type="number" class="form-control" name="count" value="${product.getCount()}">
            </div>
            <div class="form-group col-sm-4">
                <label>Amount</label>
                <input type="number" class="form-control" name="amount" value="${product.getAmount()}">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-sm-4">
                <label>Color</label>
                <input type="text" class="form-control" name="color" value="${product.getColor()}">
            </div>
            <div class="form-group col-sm-4">
                <label>Described</label>
                <input type="text" class="form-control" name="described" value="${product.getDescribed()}">
            </div>
            <div class="form-group col-sm-4">
                <label>Category</label>
                <select class="form-control" name="idCategory">
                    <option value="1">Iphone</option>
                    <option value="2">Oppo</option>
                    <option value="3">Nokia</option>
                    <option value="4">SamSung</option>
                    <option value="5">Xiaomi</option>
                </select>
            </div>

            <div class="form-row">
                <div class="form-group col-sm-11 button_top">
                    <a href="/product">
                        <button type="button" class="btn btn-secondary">Back</button>
                    </a>
                </div>
                <div class="form-group col-sm-1 button_top form-row">
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">Create</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
<%--Form--%>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>
</html>

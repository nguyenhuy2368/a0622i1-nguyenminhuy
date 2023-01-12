<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css" />
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <table id="tableStudent" class="table table-striped table-bordered" style="width:100%">
                    <thead>
                        <tr>
                            <th>ProductID</th>
                            <th>ProductName</th>
                            <th>ProductPrice</th>
                            <th>ProductQuantity</th>
                            <th>ProductColor</th>
                            <th>ProductDescription</th>
                            <th>ProductCategoryID</th>
                            <th colspan="2">Functions</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${products}" var="product">
                        <tr>
                            <td>${product.getProductId()}</td>
                            <td>${product.getProductName()}</td>
                            <td>${product.getProductPrice()}</td>
                            <td>${product.getProductQuantity()}</td>
                            <td>${product.getColor()}</td>
                            <td>${product.getProductDescription()}</td>
                            <td>${product.getCategoryId()}</td>
                            <td><a class="btn btn-secondary" href="/testModule3?action=update&productId=${product.getProductId()}">Update</a></td>
                            <td><a class="btn-danger" href="/testModule3?action=delete&productId=${product.getProductId()}">Delete</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <script src="jquery/jquery-3.5.1.min.js"></script>
    <script src="datatables/js/jquery.dataTables.min.js"></script>
    <script src="datatables/js/dataTables.bootstrap5.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#tableStudent').dataTable( {
                "dom": 'lrtip',
                "lengthChange": false,
                "pageLength": 5
            } );
        } );
    </script>
</body>
</html>

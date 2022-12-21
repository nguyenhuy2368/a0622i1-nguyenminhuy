<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 12/12/2022
  Time: 6:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<c:import url="../../navbar.jsp"></c:import>
<h1>Trang danh sách sinh viên</h1>
<a href="/student?action=create">Thêm mới</a>
<p style="color: red">
    ${mess}
</p>
<table class="table table-striped">
    <tr>
        <th>STT</th>
        <th>id</th>
        <th>Name</th>
        <th>Gender</th>
        <th>Point</th>
        <th>Rank</th>
        <th>Class ID</th>
        <th>delete</th>
    </tr>
    <c:forEach var="student" items="${studentList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${student.getId()}</td>
            <td>${student.getName()}</td>
            <c:if test="${student.isGender()}">
                <td>Nam</td>
            </c:if>
            <c:if test="${!student.isGender()}">
                <td>Nữ</td>
            </c:if>

            <td>${student.getPoint()}</td>
            <c:choose>
                <c:when test="${student.getPoint()>=8}">
                    <td>Giỏi</td>
                </c:when>
                <c:when test="${student.getPoint()>=7}">
                    <td>Khá</td>
                </c:when>
                <c:when test="${student.getPoint()>=5}">
                    <td>Trung bình</td>
                </c:when>
                <c:otherwise>
                    <td>Yêu sắc yếu</td>
                </c:otherwise>
            </c:choose>
<%--            <c:forEach var="clazz" items="${clazzList}">--%>
<%--               <c:if test="${clazz.id==student.getClassId()}">--%>
<%--                   <td>${clazz.name}</td>--%>
<%--               </c:if>--%>
<%--            </c:forEach>--%>
            <td>${student.getClazz().getName()}</td>

            <td>
                <button type="button" onclick="deleteInfo('${student.id}','${student.name}')"  class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Delete
                </button>
            </td>
        </tr>
    </c:forEach>
</table>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="/student?action=delete" method="post">
                <div class="modal-body">
                    <input name="deleteId" id="deleteId">
                    <span>Bạn có muốn xoá </span><span style="color: #ff0000" id ="deleteName"></span><span> không?</span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </form>

        </div>
    </div>
</div>
<script>
    function deleteInfo(id,name) {
         document.getElementById("deleteName").innerText=name;
         document.getElementById("deleteId").value=id;
    }
</script>
</body>
</html>

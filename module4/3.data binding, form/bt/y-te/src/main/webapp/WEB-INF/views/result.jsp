<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2/11/2023
  Time: 4:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<body>
<b>Họ tên:</b>
<span>${medical.name}</span><br>
<b>Năm sinh:</b>
<span>${medical.yearBirth}</span><br>
<b>Giới tính:</b>
<span>${medical.gender}</span><br>
<b>Quốc tịch:</b>
<span>${medical.nationality}</span><br>
<b>Số CMND:</b>
<span>${medical.citizenId}</span><br>
<b>Phương tiện đi lại:</b>
<span>${medical.vehicle}</span><br>
<b>Số hiệu phương tiện:</b>
<span>${medical.vehicleId}</span><br>
<b>Ngày khởi hành:</b>
<span>${medical.startDate}</span><br>
<b>Ngày kết thúc:</b>
<span>${medical.endDate}</span><br>
</body>
</html>

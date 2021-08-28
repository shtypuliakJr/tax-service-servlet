<%--
  Created by IntelliJ IDEA.
  User: shtypuliak_r
  Date: 8/28/21
  Time: 1:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Filter</p>
<form action="filter-test" method="get">
    <input type="text" name="id"/><br/>
    <input type="text" name="name"/><br/>
    <input type="submit"/>
</form>

<c:forEach items="${users}" var="i">
    <p>${i}</p>
</c:forEach>

</body>
</html>

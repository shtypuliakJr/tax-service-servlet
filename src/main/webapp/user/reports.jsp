<%--
  Created by IntelliJ IDEA.
  User: shtypuliak_r
  Date: 8/27/21
  Time: 7:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Page</title>
</head>
<body>
<p>Reports</p>
<a href="user/reports-view"></a>
<%= session.getAttribute("user") %>
</body>
</html>

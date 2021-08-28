<%--
  Created by IntelliJ IDEA.
  User: shtypuliak_r
  Date: 8/27/21
  Time: 11:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Report view</title>
</head>
<body>

<%--<%!--%>
<%--    public void method(OutputStream outputStream, String name) {--%>
<%--        System.out.println("Name = " + name);--%>
<%--    }--%>
<%--%>--%>

<%--${reportName}--%>
<%--${reportName} <br>--%>

<c:forEach items="${users}" var="s">
    <p>${s}</p>
    <br/>
</c:forEach>

<%--<c:out value="Hello world"/>--%>

<%--<%--%>
<%--    response.getWriter().println("Name = " + request.getAttribute("reportName").toString());--%>
<%--%>--%>
</body>
</html>

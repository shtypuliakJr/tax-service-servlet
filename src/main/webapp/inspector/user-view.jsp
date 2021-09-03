<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shtypuliak_r
  Date: 9/3/21
  Time: 9:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User view</title>
</head>
<body>
${requestScope.userDTO}
<c:if test="${requestScope.errorInvalidParam != null}">
    <c:out value="${requestScope.errorInvalidParam}"/>
</c:if>
</body>
</html>

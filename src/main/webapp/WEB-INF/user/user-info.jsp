<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <fmt:setLocale value="${sessionScope.lang}"/>
    <fmt:setBundle basename="message"/>

    <meta charset="UTF-8">
    <title><fmt:message key="user.info.information"/></title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
</head>

<body>

<%@include file="user-navbar.html" %>

<div class="container">
    <div style="text-align: center">
        <h1><fmt:message key="user.info.information"/></h1>
    </div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><b><fmt:message key="user.info.fullname"/></b></td>
            <td><span>${sessionScope.user.firstName} ${sessionScope.user.lastName}</span></td>
        </tr>
        <tr>
            <td><b><fmt:message key="user.info.email"/></b></td>
            <td><span>${sessionScope.user.email}</span></td>
        </tr>
        <tr>
            <td><b><fmt:message key="user.info.age"/></b></td>
            <td><span>${sessionScope.user.age}</span></td>
        </tr>
        <tr>
            <td><b><fmt:message key="user.info.registration.date"/></b></td>
            <td><span>${sessionScope.user.dateOfRegistration}</span></td>
        </tr>
        <tr>
            <td><b><fmt:message key="user.info.ipn"/></b></td>
            <td><span>${sessionScope.user.ipn}</span></td>
        </tr>
        <tr>
            <td><b><fmt:message key="user.info.personality"/></b></td>
            <td><span><fmt:message key="user.data.dto.personality.name.${sessionScope.user.personality}"/></span></td>
        </tr>
        <tr>
            <td><b><fmt:message key="user.info.address"/></b></td>
            <td><span>${sessionScope.user.address}</span></td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>


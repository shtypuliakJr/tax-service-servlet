<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.lang}"/>
    <fmt:setBundle basename="message"/>

    <meta charset="UTF-8">
    <title>Reports</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
</head>


<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">

    <div class="form-group row">
        <div class="col-md-5">
            <form style="display: inline;" action="statistic" method="GET">
                <button type="submit" class="btn btn-primary">Statistic</button>
            </form>
        </div>
        <div class="col-md-5">
            <form style="display: inline;" action="reports" method="GET">
                <button type="submit" class="btn btn-primary">Reports</button>
            </form>
        </div>
    </div>

    <div class="navbar-nav ml-auto">
        <div class="form-group row">
            <div class="col-sm-8">
                <span>Inspector</span>
                <p><c:out value="${sessionScope.user.email}"/></p>
            </div>
            <div class="col-sm-4">
                <form style="display: inline;" action="${pageContext.request.contextPath}/logout" method="POST">
                    <input class="btn btn-danger" type="submit" value="Logout"/>
                </form>
            </div>
        </div>
    </div>

</nav>

<div class="container">
    <div style="text-align: center">
        <h1>User Information</h1>
    </div>
    <table class="table table-striped">
        <thead>
        <tr>
            <td class="text-center" colspan="2">
                <c:if test="${requestScope.noUserFoundException != null}">
                    <span><c:out value="${requestScope.noUserFoundException}"/></span>
                </c:if>
                <c:if test="${requestScope.errorInvalidParam != null}">
                    <span><c:out value="${requestScope.errorInvalidParam}"/></span>
                </c:if>
            </td>
        </tr>
        <tr>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${requestScope.userDTO != null}">
        <tr>
            <td><b>Full name: </b></td>
            <td><span>${requestScope.userDTO.firstName} ${requestScope.userDTO.lastName}</span></td>
        </tr>
        <tr>
            <td><b>Email: </b></td>
            <td><span>${requestScope.userDTO.email}</span></td>
        </tr>
        <tr>
            <td><b>Age: </b></td>
            <td><span>${requestScope.userDTO.age}</span></td>
        </tr>
        <tr>
            <td><b>Registration date: </b></td>
            <td><span>${requestScope.userDTO.dateOfRegistration}</span></td>
        </tr>
        <tr>
            <td><b>IPN: </b></td>
            <td><span>${requestScope.userDTO.ipn}</span></td>
        </tr>
        <tr>
            <td><b>Personality: </b></td>
            <td><span>${requestScope.userDTO.personality}</span></td>
        </tr>
        <tr>
            <td><b>Address: </b></td>
            <td><span>${requestScope.userDTO.address}</span></td>
        </tr>
        </tbody>
        </c:if>
    </table>
    <div>
        <form action="${pageContext.request.contextPath}/inspector/reports" method="GET">
            <input type="hidden" id="userId" name="userId" value="${requestScope.userDTO.userId}"/>
            <button type="submit" class="btn btn-outline-primary">
                Show reports
            </button>
        </form>
    </div>

</div>
</body>
</html>

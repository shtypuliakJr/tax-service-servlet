<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <fmt:setLocale value="${sessionScope.lang}"/>
    <fmt:setBundle basename="message"/>

    <title></title>
    <meta charset="UTF-8">
    <title>Tax Service</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="form-group row">
        <div class="col-md-5">
            <form style="display: inline;" action="login" method="GET">
                <button type="submit" class="btn btn-primary">
                    <fmt:message key="main.login"/>
                </button>
            </form>
        </div>
        <div class="col-md-5">
            <form style="display: inline;" action="registration" method="GET">
                <button type="submit" class="btn btn-primary">
                    <fmt:message key="main.registration"/>
                </button>
            </form>
        </div>
    </div>

    <div class="navbar-nav ml-auto">
        <div class="form-group row">
            <div class="col-md-5">
                <a href="?lang=en"><fmt:message key="lang.en"/></a>
            </div>
            <div class="col-md-5">
                <a href="?lang=ua"><fmt:message key="lang.ua"/></a>
            </div>
        </div>
    </div>
</nav>
<div>
    <p><fmt:message key="main.greeting"/></p>
    <br/>
    <br/>
    <br/>
</div>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<br/>
<a href="main">Hello Servlet</a>
<br/>
<a href="user/reports">User Reports</a>
<br/>
<a href="init-param">my servlet</a>
<br/>
<a href="user/reports-view">Reports-view</a>
<br/>
<a href="filter-test">Filter</a>
<br/>
<a href="login">Login</a>
<br/>
<form method="get" action="main">
    <label>Redirect Value
        <input type="text" name="value"/>
    </label>
    <input type="submit"/>
</form>

<%
    out.println(session.getAttribute("lang"));
%>
</body>
</html>
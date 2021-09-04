<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmr" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shtypuliak_r
  Date: 8/28/21
  Time: 10:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <fmt:setBundle basename="message"/>
    <fmt:setLocale value="${param.lang}"/>

    <title><fmt:message key="login.login"/></title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
</head>
<body class="h-100">
<%--<!--<nav class="navbar navbar-expand-lg navbar-light bg-light">-->--%>

<%--<!--&lt;!&ndash;    <div class="navbar-nav ml-auto">&ndash;&gt;-->--%>
<%--<!--&lt;!&ndash;        <div class="form-group row">&ndash;&gt;-->--%>
<%--<!--&lt;!&ndash;            <div class="col-md-5">&ndash;&gt;-->--%>
<%--<!--&lt;!&ndash;                <a th:href="@{?lang=en}" th:text="#{lang.en}"></a>&ndash;&gt;-->--%>
<%--<!--&lt;!&ndash;            </div>&ndash;&gt;-->--%>
<%--<!--&lt;!&ndash;            <div class="col-md-5">&ndash;&gt;-->--%>
<%--<!--&lt;!&ndash;                <a th:href="@{?lang=ua}" th:text="#{lang.ua}"></a>&ndash;&gt;-->--%>
<%--<!--&lt;!&ndash;            </div>&ndash;&gt;-->--%>
<%--<!--&lt;!&ndash;        </div>&ndash;&gt;-->--%>
<%--<!--&lt;!&ndash;    </div>&ndash;&gt;-->--%>
<%--<!--</nav>-->--%>
<div class="container h-100">
    <div class="row h-100 justify-content-center align-items-center">
        <div class="col-10 col-md-8 col-lg-6">
            <div class="container alert alert-primary">
                <form class="form-example" name="f" action="login" method="post">

                    <div style="text-align: center">
                        <h1><fmt:message key="login.login"/></h1>
                    </div>

                    <div class="form-group">
                        <label for="email"><fmr:message key="data.input.email"/></label>
                        <input type="text" id="email" name="email" class="form-control"
                               placeholder="<fmt:message key="data.input.email"/>"
                               value="${requestScope.email}">
                    </div>

                    <div class="form-group">
                        <label for="password"><fmr:message key="data.input.password"/></label>
                        <input type="password" id="password" name="password" class="form-control"
                               placeholder="<fmt:message key="data.input.password"/>">
                    </div>

                    <div class="col text-center">
                        <button type="submit" style="width: 140px" class="btn btn-primary btn-lg">
                            <fmt:message key="login.login"/>
                        </button>
                    </div>
                </form>
                <c:if test="${requestScope.exceptionLogin != null}">
                    <div class="alert alert-error">
                        <div class="alert alert-danger" role="alert">
                            <div style="text-align: center" class="error-invalid">
                                    ${requestScope.exceptionLogin}
                            </div>
                        </div>
                    </div>
                </c:if>
                <a href="registration"><fmt:message key="login.notRegistered"/></a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
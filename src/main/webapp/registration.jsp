<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.lang}"/>
    <fmt:setBundle basename="message"/>

    <meta charset="UTF-8">
    <title><fmt:message key="registration.registration"/></title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="form-group row">
        <div class="col-md-5">
            <form style="display: inline;" action="${pageContext.request.contextPath}/" method="get">
                <button type="submit" class="btn btn-primary">
                    <fmt:message key="main.main"/>
                </button>
            </form>
        </div>
    </div>

    <div class="navbar-nav ml-auto">
        <div class="form-group row">
            <div class="col-md-5">
                <a href="?lang=en">
                    <fmt:message key="lang.en"/>
                </a>
            </div>
            <div class="col-md-5">
                <a href="?lang=ua">
                    <fmt:message key="lang.ua"/>
                </a>
            </div>
        </div>
    </div>
</nav>
<div class="container h-100">
    <div class="row h-100 justify-content-center align-items-center">
        <div class="col-10 col-md-8 col-lg-6">
            <div class="container alert alert-primary">
                <form action="registration" method="post">

                    <div style="text-align: center">
                        <h1><fmt:message key="registration.registration"/></h1>
                    </div>

                    <div class="form-group">
                        <label for="firstName"><fmt:message key="registration.data.firstName"/> </label>
                        <input id="firstName" name="firstName" type="text" class="form-control"
                               placeholder="<fmt:message key="registration.data.input.firstName"/>">
                    </div>

                    <div class="form-group">
                        <label for="lastName"><fmt:message key="registration.data.lastName"/> </label>
                        <input id="lastName" name="lastName" type="text" class="form-control"
                               placeholder="<fmt:message key="registration.data.input.lastName"/>">
                    </div>

                    <div class="form-group">
                        <label for="email"><fmt:message key="registration.data.email"/> </label>
                        <input id="email" name="email" type="text" class="form-control"
                               placeholder="<fmt:message key="registration.data.input.email"/>">
                    </div>

                    <div class="form-group">
                        <label for="password"><fmt:message key="registration.data.password"/> </label>
                        <input id="password" name="password" type="password" class="form-control"
                               placeholder="<fmt:message key="registration.data.input.password"/>">
                    </div>

                    <div class="form-group">
                        <label for="age"><fmt:message key="registration.data.age"/> </label>
                        <input id="age" name="age" type="password" class="form-control"
                               placeholder="<fmt:message key="registration.data.input.age"/>">
                    </div>

                    <div class="form-group">
                        <label for="ipn"><fmt:message key="registration.data.ipn"/> </label>
                        <input id="ipn" name="ipn" type="text" class="form-control"
                               placeholder="<fmt:message key="registration.data.input.ipn"/>">
                    </div>


                    <div class="form-group">
                        <label for="address"><fmt:message key="registration.data.address"/> </label>
                        <input id="address" name="address" type="text" class="form-control"
                               placeholder="<fmt:message key="registration.data.input.address"/>">
                    </div>


                    <div class="form-group">
                        <label for="personality"><fmt:message key="registration.data.personality"/></label>
                        <select id="personality" name="personality">
                            <option value="NATURAL_PERSON">
                                <fmt:message key="user.data.dto.personality.name.NATURAL_PERSON"/>
                            </option>
                            <option value="LEGAL_PERSON">
                                <fmt:message key="user.data.dto.personality.name.LEGAL_PERSON"/>
                            </option>
                        </select>
                    </div>

                    <div class="col text-center">
                        <button type="submit" style="width: 200px"
                                class="btn btn-primary btn-lg">
                            <fmt:message key="registration.data.register"/>
                        </button>
                    </div>
                    <c:if test="${requestScope.errorUserExists}">
                        <div class="alert alert-error">
                            <div class="alert alert-danger" role="alert">
                                <div style="text-align: center" class="error-invalid">
                                    <fmt:message key="registration.data.user.exists"/>
                                </div>
                            </div>
                        </div>
                        <c:out value="${requestScope.errorUserExists}"/>
                    </c:if>

                    <br/>
                    <div>
                        <a href="login">
                            <fmt:message key="registration.data.link.login"/>
                        </a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
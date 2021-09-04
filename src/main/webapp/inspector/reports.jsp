<%@ page import="com.example.taxserviceservlet.entity.TaxPeriod" %>
<%@ page import="com.example.taxserviceservlet.entity.Status" %>
<%@ page import="com.example.taxserviceservlet.web.dto.SortField" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <div class="row">
        <div class="col-4">
            <div class="input-group">
                <form action="search" method="GET">
                    <div class="d-flex flex-row">
                        <input id="search" name="search" value="${search}"
                               class="form-control rounded" placeholder="Enter id, ipn, name, surname"
                               aria-label="Search" aria-describedby="search-addon"/>
                        <button type="submit" class="btn btn-outline-primary">Search</button>
                    </div>
                </form>
            </div>
        </div>
        <%--                <c:set var="periods" value="<%=SortField.values()%>"/>--%>

        <div class="col-8">
            <form action="${pageContext.request.contextPath}/inspector/reports" method="GET">
                <label for="date">
                    Select date:
                    <input type="date" id="date" name="date" min="2010-01-01" max="2021-12-31"
                    value="${sessionScope.date}"
                    />
                </label>
                <select id="period" name="period" class="form-select" aria-label="Default select example">
                    <option selected value="">Select period</option>
                    <c:forEach var="period" items="${TaxPeriod.values()}">
                        <option label="${period}"
                                value="${period}" <c:if test="${period == sessionScope.period}"> selected </c:if>>
                            ..
                        </option>
                    </c:forEach>

                </select>

                <select id="status" name="status" class="form-select" aria-label="Default select example">
                    <option selected value="">Select status</option>
                    <c:forEach var="status" items="${Status.values()}">
                        <option label="${status}"
                                value="${status}" <c:if test="${status == sessionScope.status}"> selected </c:if>>
                            ..
                        </option>
                    </c:forEach>
                </select>

                <select id="sortField" name="sortBy" class="form-select" aria-label="Default select example">
                    <option value="">Select sorting field</option>
                    <c:forEach var="sortField" items="${SortField.values()}">
                        <option label="${sortField}"
                                value="${sortField}" <c:if test="${sortField == sessionScope.sortBy}"> selected </c:if>>
                            ..
                        </option>
                    </c:forEach>

                </select>

                <button type="submit" class="btn btn-outline-primary">Filter</button>
            </form>
        </div>

    </div>
    <div class="row">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Report id</th>
                <th scope="col">User full name</th>
                <th scope="col">IPN</th>
                <th scope="col">Report date</th>
                <th scope="col">Year</th>
                <th scope="col">Period</th>
                <th scope="col">Comment</th>
                <th scope="col">Status</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td class="text-center" colspan="9">
                    <div>
                        <c:if test="${requestScope.noReportsFound != null}">
                            <b><c:out value="${requestScope.noReportsFound}"/></b>
                        </c:if>
                    </div>
            <tbody>
            <c:forEach var="report" items="${requestScope.reports}">

                <tr>
                    <td><span><c:out value="${report.id}"/></span></td>
                    <td><a href="${pageContext.request.contextPath}/inspector/user-view?userId=${report.userId}">
                            ${report.userDTO.firstName} ${report.userDTO.lastName}</a>
                    </td>
                    <td><span><c:out value="${report.userDTO.ipn}"/></span></td>
                    <td><span><c:out value="${report.reportDate}"/></span></td>
                    <td><span><c:out value="${report.year}"/></span></td>
                    <td><span><c:out value="${report.taxPeriod}"/></span></td>
                    <td>
                        <c:if test="${report.comment != null}">
                        <span>Has comment</span>
                        </c:if>
                    <td><span><c:out value="${report.status}"/></span></td>
                    <td>
                        <div>
                            <form action="${pageContext.request.contextPath}/inspector/report-view" method="GET">
                                <input type="hidden" id="report" name="reportId" value="${report.id}">
                                <input type="submit" value="View"/>
                            </form>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
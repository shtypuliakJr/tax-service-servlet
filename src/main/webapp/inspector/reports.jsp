<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
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
                <form action="inspector/search" method="GET">
                    <div class="d-flex flex-row">
                        <input id="search" name="search" value="${search}"
                               class="form-control rounded" placeholder="Enter id, ipn, name, surname"
                               aria-label="Search" aria-describedby="search-addon"/>
                        <button type="submit" class="btn btn-outline-primary">Search</button>
                    </div>
                </form>
            </div>
        </div>

        <div class="col-8">
            <form action="inspector/reports" method="GET">
                <label for="date">
                    Select date:
                    <input type="date" id="date" name="date" min="2010-01-01" max="2021-12-31"/>
                </label>
<%--                <select id="period" name="period" class="form-select" aria-label="Default select example">--%>
<%--                    <option selected value="">Select period</option>--%>
<%--                    <option th:each="period : ${T(com.taxserviceapp.data.entity.TaxPeriod).values()}"--%>
<%--                            th:text="${period.getPeriod()}"--%>
<%--                            th:value="${period.name()}"--%>
<%--                            th:selected="${period} == ${lastSelectedPeriod}">--%>
<%--                        ..--%>
<%--                    </option>--%>
<%--                </select>--%>

<%--                <select id="status" name="status" class="form-select" aria-label="Default select example">--%>
<%--                    <option selected value="">Select status</option>--%>
<%--                    <option th:each="status : ${T(com.taxserviceapp.data.entity.Status).values()}"--%>
<%--                            th:text="${status.getStatusName()}"--%>
<%--                            th:value="${status.name()}"--%>
<%--                            th:selected="${status} == ${lastSelectedStatus}">--%>
<%--                        ..--%>
<%--                    </option>--%>
<%--                </select>--%>

<%--                <select id="sortField" name="sortField" class="form-select" aria-label="Default select example">--%>
<%--                    <option value="">Select sorting field</option>--%>
<%--                    <option th:each="sortField : ${T(com.taxserviceapp.web.dto.SortField).values()}"--%>
<%--                            th:text="${sortField.getSortName()}"--%>
<%--                            th:value="${sortField.name()}"--%>
<%--                            th:selected="${sortField} == ${lastSelectedSort}">--%>
<%--                        ..--%>
<%--                    </option>--%>
<%--                </select>--%>

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
<%--            <tr>--%>
<%--                <td class="text-center" colspan="9">--%>
<%--                    <div th:if="${errorNoResult != null}" th:text="${errorNoResult}">--%>
<%--                        Error no result--%>
<%--                    </div>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr th:each="report: ${reports}">--%>
<%--                <td><span th:text="${report.id}">Report id</span></td>--%>
<%--                <td><a th:href="@{/inspector/user-view(userId=${report.user.id})}"--%>
<%--                       th:text="${report.user.firstName} + ' ' + ${report.user.lastName}">Name Surname</a>--%>
<%--                </td>--%>
<%--                <td><span th:text="${report.user.ipn}">IPN</span></td>--%>
<%--                <td><span th:text="${report.reportDate}">Report Date</span></td>--%>
<%--                <td><span th:text="${report.year}">Year</span></td>--%>
<%--                <td><span th:text="${report.taxPeriod.getPeriod()}">Report Period</span></td>--%>
<%--                <td><span th:text="${report.comment}">Comment</span></td>--%>
<%--                <td><span th:text="${report.status.getStatusName()}">status</span></td>--%>
<%--                <td>--%>
<%--                    <div>--%>
<%--                        <form action="#" th:action="@{/inspector/report-view}" th:method="GET">--%>
<%--                            <input type="hidden" id="report" name="reportId" th:value="${report.id}">--%>
<%--                            <input type="submit" value="View"/>--%>
<%--                        </form>--%>
<%--                    </div>--%>
<%--                </td>--%>
<%--            </tr>--%>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
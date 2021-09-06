<%@ page import="com.example.taxserviceservlet.entity.TaxPeriod" %>
<%@ page import="com.example.taxserviceservlet.entity.Status" %>
<%@ page import="com.example.taxserviceservlet.web.dto.SortField" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reports</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
</head>
<body>

<%@include file="user-navbar.html" %>

<div class="container">
    <div class="row">
        <div class="col-11">
            <form action="${pageContext.request.contextPath}/user/reports" method="GET">
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
        <div class="col-1">
            <form action="${pageContext.request.contextPath}/user/reports" method="GET">
                <input type="hidden" name="date" value=""/>
                <input type="hidden" name="period" value=""/>
                <input type="hidden" name="status" value=""/>
                <input type="hidden" name="sortBy" value=""/>
                <button type="submit" class="btn btn-outline-warning">Drop filter</button>
            </form>
        </div>

    </div>
    <div class="row">
        <table class="table table-striped">
            <thead>
            <tr class="text-center">
                <th scope="col">Income, $</th>
                <th scope="col">Tax rate, %</th>
                <th scope="col">Period</th>
                <th scope="col">Year</th>
                <th scope="col">Report Date</th>
                <th scope="col">Comment</th>
                <th scope="col">Status</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td class="text-center" colspan="9">
                    <div>
                        <c:if test="${requestScope.noReportsFoundException != null}">
                            <b><c:out value="${requestScope.noReportsFoundException}"/></b>
                        </c:if>
                    </div>
                </td>
            </tr>

            <c:forEach var="report" items="${requestScope.reports}">
                <tr>
                    <td><span><c:out value="${report.income}"/></span></td>
                    <td><span><c:out value="${report.taxRate}"/></span></td>
                    <td><span><c:out value="${report.taxPeriod}"/></span></td>
                    <td><span><c:out value="${report.year}"/></span></td>
                    <td><span><c:out value="${report.reportDate}"/></span></td>

                    <td>
                        <c:if test="${report.comment != null}">
                        <span>Has comment</span>
                        </c:if>
                    <td>
                    <td><span><c:out value="${report.status}"/></span></td>
                    <td>
                        <div class="container">
                            <div class="row">

                                <div class="col-6">
                                    <form action="${pageContext.request.contextPath}/user/report-edit"
                                          class='form-inline' method="GET">
                                        <input type="hidden" name="reportId" value="${report.id}">
                                        <input type="submit" value="Edit"/>
                                    </form>
                                </div>

                                <div class="col-6">
                                    <form action="${pageContext.request.contextPath}/user/report-delete"
                                          class='form-inline' method="POST">
                                        <input type="hidden" name="reportId" value="${report.id}">
                                        <input type="submit" value="Delete"/>
                                    </form>
                                </div>

                            </div>
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

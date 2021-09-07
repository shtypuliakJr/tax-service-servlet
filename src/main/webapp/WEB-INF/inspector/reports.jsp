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

<%@include file="inspector-navbar.html" %>

<div class="container">
    <div class="row">
        <div class="col-11">
            <form action="${pageContext.request.contextPath}/inspector/reports" method="GET">
                <input type="hidden" name="userId" value="${sessionScope.userId}"/>
                <label for="date">
                    <fmt:message key="reports.search.select.date"/>
                    <input type="date" id="date" name="date" min="2010-01-01" max="2021-12-31"
                           value="${sessionScope.date}"/>
                </label>
                <select id="period" name="period" class="form-select" aria-label="Default select example">
                    <option selected value=""><fmt:message key="reports.search.select.period"/></option>
                    <c:forEach var="period" items="${TaxPeriod.values()}">
                        <option label="<fmt:message key="reports.period.${period}"/>"
                                value="${period}" <c:if test="${period == sessionScope.period}"> selected </c:if>>
                            ..
                        </option>
                    </c:forEach>

                </select>

                <select id="status" name="status" class="form-select" aria-label="Default select example">
                    <option selected value=""><fmt:message key="reports.search.select.status"/></option>
                    <c:forEach var="status" items="${Status.values()}">
                        <option label="<fmt:message key="reports.status.${status}"/>"
                                value="${status}" <c:if test="${status == sessionScope.status}"> selected </c:if>>
                            ..
                        </option>
                    </c:forEach>
                </select>

                <select id="sortField" name="sortBy" class="form-select" aria-label="Default select example">
                    <option value=""><fmt:message key="reports.search.select.sorting.field"/></option>
                    <c:forEach var="sortField" items="${SortField.values()}">
                        <option label="<fmt:message key="reports.sortField.${sortField}"/>"
                                value="${sortField}" <c:if test="${sortField == sessionScope.sortBy}"> selected </c:if>>
                            ..
                        </option>
                    </c:forEach>
                </select>
                <button type="submit" class="btn btn-outline-primary"><fmt:message key="report.filter"/></button>
            </form>
        </div>
        <div class="col-1">
            <form action="${pageContext.request.contextPath}/inspector/reports" method="GET">
                <input type="hidden" name="userId" value=""/>
                <input type="hidden" name="date" value=""/>
                <input type="hidden" name="period" value=""/>
                <input type="hidden" name="status" value=""/>
                <input type="hidden" name="sortBy" value=""/>
                <button type="submit" class="btn btn-outline-warning"><fmt:message key="report.filter.drop"/></button>
            </form>
        </div>

    </div>
    <div class="row">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col"><fmt:message key="report.report.id"/></th>
                <th scope="col"><fmt:message key="report.user.fullname"/></th>
                <th scope="col"><fmt:message key="report.user.ipn"/></th>
                <th scope="col"><fmt:message key="report.data.col.date"/></th>
                <th scope="col"><fmt:message key="report.data.col.year"/></th>
                <th scope="col"><fmt:message key="report.data.col.period"/></th>
                <th scope="col"><fmt:message key="report.data.col.comment"/></th>
                <th scope="col"><fmt:message key="report.data.col.status"/></th>
                <th scope="col"><fmt:message key="report.data.col.action"/></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td class="text-center" colspan="9">
                    <div>
                        <c:if test="${requestScope.noReportsFound != null}">
                            <b><fmt:message key="reports.error.not.found"/></b>
                        </c:if>
                    </div>
                </td>
            </tr>
            <c:forEach var="report" items="${requestScope.reports}">

                <tr>
                    <td><span><c:out value="${report.id}"/></span></td>
                    <td><a href="${pageContext.request.contextPath}/inspector/user-view?userId=${report.userId}">
                            ${report.userDTO.firstName} ${report.userDTO.lastName}</a>
                    </td>
                    <td><span><c:out value="${report.userDTO.ipn}"/></span></td>
                    <td><span><c:out value="${report.reportDate}"/></span></td>
                    <td><span><c:out value="${report.year}"/></span></td>
                    <td><span><fmt:message key="reports.period.${report.taxPeriod}"/></span></td>
                    <td>
                        <c:if test="${report.comment != null}">
                            <span><fmt:message key="report.has.comment"/></span>
                        </c:if>
                    <td><span><fmt:message key="reports.status.${report.status}"/></span></td>
                    <td>
                        <div>
                            <form action="${pageContext.request.contextPath}/inspector/report-view" method="GET">
                                <input type="hidden" id="report" name="reportId" value="${report.id}">
                                <input type="submit"
                                       value="<fmt:message key="reports.action.view"/>"/>
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
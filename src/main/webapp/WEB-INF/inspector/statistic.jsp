<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.lang}"/>
    <fmt:setBundle basename="message"/>

    <meta charset="UTF-8">
    <title><fmt:message key="inspector.statistic.title"/></title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
</head>
<body>

<%@include file="inspector-navbar.html" %>

<div class="container">
    <div class="col-md">
        <div style="text-align: center;">
            <h1><fmt:message key="inspector.statistic.title"/></h1>
        </div>
    </div>
    <div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><b><fmt:message key="inspector.statistic.inspectors.count"/></b></td>
                <td><span>${requestScope.statisticData.countOfInspectors}</span></td>
            </tr>
            <tr>
                <td><b><fmt:message key="inspector.statistic.users.count"/></b></td>
                <td><span>${requestScope.statisticData.countOfUsers}</span></td>
            </tr>
            <tr>
                <td><b><fmt:message key="inspector.statistic.reports.count"/></b></td>
                <td><span>${requestScope.statisticData.countOfReports}</span></td>
            </tr>
            <tr>
                <td><b><fmt:message key="inspector.statistic.reports.processing"/></b></td>
                <td><span>${requestScope.statisticData.processingReports}</span></td>
            </tr>
            <tr>
                <td><b><fmt:message key="inspector.statistic.reports.approved"/></b></td>
                <td><span>${requestScope.statisticData.approvedReports}</span></td>
            </tr>
            <tr>
                <td><b><fmt:message key="inspector.statistic.reports.disapproved"/></b></td>
                <td><span>${requestScope.statisticData.disapprovedReports}</span></td>
            </tr>
            </tbody>
        </table>

        <br/>
        <div>
            <div style="text-align: center">
                <h1><fmt:message key="inspector.statistic.reports.per.year"/></h1>
            </div>
            <table class="table table-striped">
                <thead>
                <tr>
                    <c:forEach var="year" items="${requestScope.statisticData.countReportsPerYear}">
                        <td>
                            <span>${year.key}</span>
                        </td>
                    </c:forEach>
                </tr>
                </thead>

                <tbody>
                <tr>
                    <c:forEach var="countPerYear" items="${requestScope.statisticData.countReportsPerYear}">
                        <td>
                            <span>${countPerYear.value}</span>
                        </td>
                    </c:forEach>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>

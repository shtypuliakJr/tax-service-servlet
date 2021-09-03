<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>Statistic</title>
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
    <div class="col-md">
        <div style="text-align: center;">
            <h1>Statistic</h1>
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
                <td><b>Inspectors count: </b></td>
                <td><span>${requestScope.statisticData.countOfInspectors}</span></td>
            </tr>
            <tr>
                <td><b>Users count: </b></td>
                <td><span>${requestScope.statisticData.countOfUsers}</span></td>
            </tr>
            <tr>
                <td><b>Reports count: </b></td>
                <td><span>${requestScope.statisticData.countOfReports}</span></td>
            </tr>
            <tr>
                <td><b>Reports processing: </b></td>
                <td><span>${requestScope.statisticData.processingReports}</span></td>
            </tr>
            <tr>
                <td><b>Reports approved: </b></td>
                <td><span>${requestScope.statisticData.approvedReports}</span></td>
            </tr>
            <tr>
                <td><b>Reports disapproved: </b></td>
                <td><span>${requestScope.statisticData.disapprovedReports}</span></td>
            </tr>
            </tbody>
        </table>

        <br/>
        <div>
            <div style="text-align: center">
                <h1>Reports per each year</h1>
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

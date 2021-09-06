<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Report View</title>
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
<c:set var="report" value="${sessionScope.report}" scope="session"/>
<div class="container">
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
                <td><b>Full name: </b></td>
                <td><span>${report.userDTO.firstName} ${report.userDTO.lastName}</span></td>
            </tr>
            <tr>
                <td><b>IPN: </b></td>
                <td><span>${report.userDTO.ipn}</span></td>
            </tr>
            <tr>
                <td><b>Personality: </b></td>
                <td><span>${report.userDTO.personality}</span></td>
            </tr>
            <tr>
                <td><p>Income</p></td>
                <td><span>${report.income}</span></td>
            </tr>
            <tr>
                <td><p>Tax rate</p></td>
                <td><span>${report.taxRate}</span></td>
            </tr>
            <tr>
                <td><p>Report date</p></td>
                <td><span>${report.reportDate}</span></td>
            </tr>
            <tr>
                <td><p>Year</p></td>
                <td><span>${report.year}</span></td>
            </tr>
            <tr>
                <td><p>Period</p></td>
                <td><span>${report.taxPeriod}</span></td>
            </tr>
            </tbody>
        </table>
    </div>

    <div>
        <form name="f" action="${pageContext.request.contextPath}/inspector/report-view" method="post">
            <input type="hidden" id="reportId" name="reportId" value="${report.id}">
            <div class="form-group">
                <label for="comment">Comment</label>
                <textarea id="comment" name="comment" class="form-control rounded-0" rows="3">
                    ${report.comment}
                </textarea>
            </div>
            <div>
                <select id="status" name="status">
                    <option value="">Select status</option>
                    <option value="APPROVED">Approved</option>
                    <option value="DISAPPROVED">Disapproved</option>
<%--                                        <option value="${T(com.taxserviceapp.data.entity.Status).APPROVED.name()}">Approved</option>--%>
                    <%--                    <option value="${TaxPeriod.DISAPPROVED.name()}">Disapproved</option>--%>
                </select>
            </div>

            <div>
<%--                <input type="hidden" id="reportId" name="reportId" value="${report.id}"/>--%>
                <button type="submit" class="btn btn-outline-primary">Add comment</button>
            </div>
        </form>
        <c:if test="${requestScope.error != null}">
            <div class="alert alert-danger">
                <label class="validation-message">${requestScope.error}</label>
            </div>
        </c:if>
    </div>
</div>
</body>
</html>
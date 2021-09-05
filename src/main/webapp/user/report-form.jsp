<%@ page import="com.example.taxserviceservlet.entity.TaxPeriod" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Report form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
</head>

<body>

<%@include file="user-navbar.html" %>

<div class="container">
    <div class="row justify-content-center align-items-center">
        <div class="col-10 col-md-4">
            <div class="container alert alert-primary">
                <div style="text-align: center">
                    <h1>Report form</h1>
                </div>
                <div>
                    <form action="${pageContext.request.contextPath}/user/report-form" method="POST">
                        <div class="form-group">
                            <label for="income">Income:</label>
                            <input type="text" id="income" name="income" class="form-control"
                                   value="${param.get('income')}" required/>
                            <c:if test="${requestScope.fields.hasErrors('isIncomeInvalid') || false}">
                                <div class="alert alert-error">
                                    <div class="alert alert-danger" role="alert">
                                        <div style="text-align: center" class="error-invalid">Invalid income value</div>
                                    </div>
                                </div>
                            </c:if>
                        </div>

                        <div class="form-group">
                            <label for="taxRate">Tax rate,%:</label>
                            <input type="text" id="taxRate" name="taxRate" class="form-control"
                                   value="${param.get('taxRate')}" required/>
                            <c:if test="${requestScope.fields.hasErrors('isTaxRateInvalid')}">
                                <div class="alert alert-error">
                                    <div class="alert alert-danger" role="alert">
                                        <div style="text-align: center" class="error-invalid">Invalid tax rate value
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                        </div>

                        <div class="form-group">
                            <label for="period">Tax period: </label>

                            <select id="period" name="period" class="form-select" aria-label="Default select example">
                                <option selected value="">Select period</option>
                                <c:forEach var="period" items="${TaxPeriod.values()}">
                                    <option label="${period}"
                                            value="${period}"<c:if test="${period == param.get('period')}">
                                        selected </c:if>>
                                        ..
                                    </option>
                                </c:forEach>
                            </select>
                            <c:if test="${requestScope.fields.hasErrors('isPeriodInvalid')}">
                                <div class="alert alert-error">
                                    <div class="alert alert-danger" role="alert">
                                        <div style="text-align: center" class="error-invalid">Invalid period</div>
                                    </div>
                                </div>
                            </c:if>
                        </div>

                        <div class="form-group">
                            <label for="year">Year:</label>
                            <input type="text" id="year" name="year" class="form-control"
                                   value="${param.get('year')}" required/>
                            <c:if test="${requestScope.fields.hasErrors('isYearInvalid')}">
                                <div class="alert alert-error">
                                    <div class="alert alert-danger" role="alert">
                                        <div style="text-align: center" class="error-invalid">Invalid year value</div>
                                    </div>
                                </div>
                            </c:if>
                        </div>

                        <div class="form-group">
                            <div style="text-align: center">
                                <input type="submit" class="btn btn-primary center-block" value="Apply"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>

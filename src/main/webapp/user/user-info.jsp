<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>User info</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
</head>

<body>

<%@include file="user-navbar.html" %>

<div class="container">
    <div style="text-align: center">
        <h1>User Information</h1>
    </div>
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
            <td><span>${sessionScope.user.firstName} ${sessionScope.user.lastName}</span></td>
        </tr>
        <tr>
            <td><b>Email: </b></td>
            <td><span>${sessionScope.user.email}</span></td>
        </tr>
        <tr>
            <td><b>Age: </b></td>
            <td><span>${sessionScope.user.age}</span></td>
        </tr>
        <tr>
            <td><b>Registration date: </b></td>
            <td><span>${sessionScope.user.dateOfRegistration}</span></td>
        </tr>
        <tr>
            <td><b>IPN: </b></td>
            <td><span>${sessionScope.user.ipn}</span></td>
        </tr>
        <tr>
            <td><b>Personality: </b></td>
            <td><span>${sessionScope.user.personality}</span></td>
        </tr>
        <tr>
            <td><b>Address: </b></td>
            <td><span>${sessionScope.user.address}</span></td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/taglib.jspf" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <link rel="stylesheet" href="css/styleForLogAndRegForms.css" type="text/css">
    <script src='https://www.google.com/recaptcha/api.js'></script>
</head>
<body>
<div class="login-page">
    <div class="form">
        <form method="post" action="login">
            <div>
                <input style="float: left;" type="text" placeholder="login" name="login"/>
                <span>${errors.loginError}</span>
            </div>
            <div>
                <input style="float: left;" type="password" placeholder="password" name="password"/>
                <span>${errors.passwordError}</span>
            </div>
            <input style="background:greenyellow;" type="submit" value=<fmt:message key="login"/>>
        </form>
    </div>
</div>
<center>
    <a href="http://localhost:8080/">
        <ins>Back</ins>
    </a>
</center>

<script src="js/myJS/RegistrationFormValidationJS.js"></script>

<!--<script src="js/jquery-2.2.3.min.js"></script>-->
<!--<script src="js/myJS/RegistrationFormValidationJQuery.js"></script>-->

</body>
</html>
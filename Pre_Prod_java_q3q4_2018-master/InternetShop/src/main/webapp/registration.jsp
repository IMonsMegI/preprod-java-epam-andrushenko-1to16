<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="captcha" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <form method="post" action="registration" id="registration" enctype="multipart/form-data">
            <div>
                <input type="text" placeholder="name" name="name" id="name" value="${name}"/>
                <span>${errors.nameError}</span>
            </div>
            <div>
                <input type="text" placeholder="surname" name="surname" id="surname" value="${surname}"/>
                <span>${errors.surnameError}</span>
            </div>
            <div>
                <input type="text" placeholder="login" name="login" id="login" value="${login}"/>
                <span>${errors.loginError}</span>
            </div>
            <div>
                <input type="text" placeholder="email" name="email" id="email" value="${email}"/>
                <span>${errors.emailError}</span>
            </div>
            <div>
                <input type="password" placeholder="password" name="password1" id="password1"/>
                <span>${errors.passwordError}</span>
            </div>
            <div><input type="password" placeholder="repeat password" name="password2" id="password2"/></div>
            <p>Choose profile image</p>
            <input type="file" name="image" accept="image/jpeg">
            <captcha:registrationCaptchaTag/>
            <input type="text" placeholder="Captcha" name="myCaptcha">
            <span>${errors.captchaError}</span>

            <input style="background:greenyellow;" type="button" onclick="validate(this.form)" value="Registration">
            <!--<button style="background:greenyellow;" type="button" onclick="validate(this.form)">Registration</button>-->
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
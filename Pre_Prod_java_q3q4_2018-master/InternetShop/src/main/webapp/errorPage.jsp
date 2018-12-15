<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/taglib.jspf" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/style.css" type="text/css">
</head>
<body>
<c:set var="title" value="Error" scope="page"/>
<center>
    <table id="main-container">
        <tr>
            <td class="content">
                <h1 align="center" class="error">Похоже, что произошла ошибка!</h1>
                <c:set var="code" value="${statusCode}"/>
                <c:set var="message" value="${message}"/>
                <c:if test="${not empty code}">
                    <h2>Error code: ${code}</h2>
                </c:if>
                <c:if test="${not empty message}">
                    <h3>${message}</h3>
                </c:if>
            </td>
        </tr>
    </table>
</center>
</body>
</html>
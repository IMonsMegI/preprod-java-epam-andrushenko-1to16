<%@ include file="/taglib.jspf" %>

<c:if test="${empty user}">
    <li class="text-center border-right text-white">
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
    </li>
    <li class="text-center text-white">
        <a href="registration.jsp" class="text-white">
            <i class="fas fa-sign-out-alt mr-2"></i> <fmt:message key="reg"/> </a>
    </li>
</c:if>
<c:if test="${not empty user}">
    <li class="text-center border-right text-white">
        <i class="fas fa-sign-in-alt mr-2"></i> <img
            src="${pageContext.servletContext.contextPath}/usersImages/${user.image}" width="30" height="30">
        <fmt:message key="welcome"/>, ${user.login}
    </li>
    <li class="text-center text-white">
        <a href="${pageContext.servletContext.contextPath}/logout" class="text-white">
            <i class="fas fa-sign-out-alt mr-2"></i> <fmt:message key="logout"/> </a>
    </li>
</c:if>
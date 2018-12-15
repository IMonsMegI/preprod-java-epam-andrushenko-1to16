<%@ include file="/taglib.jspf" %>

<li class=" dropdown show text-center border-right text-white">
    <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        <fmt:message key="select_lang"/>
    </a>

    <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
        <c:forEach items="${applicationLocales}" var="locale">
            <label><a href="#" onclick="return setAttr('lang','${locale}')">
                <fmt:message key="${locale}"/></a>
            </label>
            <br>
        </c:forEach>
    </div>
</li>

<script src="js/myJS/langChangeLink.js"></script>
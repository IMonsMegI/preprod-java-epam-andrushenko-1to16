<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="taglib.jspf" %>
<html>
<head>
    <title>TV Shop</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8"/>

    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>

    <!-- Custom-Files -->
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- Bootstrap css -->
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- Main css -->
    <link rel="stylesheet" href="css/fontawesome-all.css">
    <!-- Font-Awesome-Icons-CSS -->
    <link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- pop-up-box -->
    <link href="css/menu.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- menu style -->
    <!-- //Custom-Files -->

    <!-- web fonts -->
    <link href="//fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i&amp;subset=latin-ext"
          rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese"
          rel="stylesheet">
    <!-- //web fonts -->
</head>

<%@ include file="header.jspf" %>

<body>
<!-- top Products -->
<div class="ads-grid py-sm-5 py-4">
    <div class="container py-xl-4 py-lg-2">
        <!-- tittle heading -->
        <h3 class="tittle-w3l text-center mb-lg-5 mb-sm-4 mb-3">
            <span>O</span>ur
            <span>P</span>roducts</h3>
        <!-- //tittle heading -->
        <div class="row">
            <!-- product left -->
            <div class="agileinfo-ads-display col-lg-9">
                <div class="wrapper">
                    <!-- second section -->
                    <div class="product-sec1 px-sm-4 px-3 py-sm-5  py-3 mb-4">
                        <h3 class="heading-tittle text-center font-italic"><fmt:message key="tv"/></h3>
                        <div class="row">
                            <c:forEach items="${products}" var="product">
                                <div class="col-md-4 product-men mt-5">
                                    <div class="men-pro-item simpleCart_shelfItem">
                                        <div class="men-thumb-item text-center">
                                            <img src="${pageContext.servletContext.contextPath}/productImages/${product.image}"
                                                 width="200" height="200">
                                            <div class="men-cart-pro">
                                                <div class="inner-men-cart-pro">
                                                    <a href="" class="link-product-add-cart"><fmt:message
                                                            key="quick_view"/></a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="item-info-product text-center border-top mt-4">
                                            <h4 class="pt-1">
                                                <a href="">${product.model}</a>
                                            </h4>
                                            <div class="info-product-price my-2">
                                                <span class="item_price">${product.cost}</span>
                                            </div>
                                            <c:if test="${not empty user}">
                                                <div class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out">
                                                    <input type="button" value=
                                                        <fmt:message key="add_to_cart"/> class="button addToCart"
                                                    data-parameter="${product.id}"/>
                                                </div>
                                            </c:if>
                                            <c:if test="${empty user}">
                                                <div class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out">
                                                    <span><fmt:message key="login_for_add"/></span>
                                                </div>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <!-- //second section -->
                </div>
            </div>
            <!-- //product left -->

            <!-- product right -->
            <div class="col-lg-3 mt-lg-0 mt-4 p-lg-0">
                <form action="productFilter">
                    <div class="side-bar p-sm-4 p-3">
                        <div class="search-hotel border-bottom py-2">
                            <h3 class="agileits-sear-head mb-3"><fmt:message key="search_here"/></h3>
                            <input type="text" placeholder="Product name..." name="searchName" id="searchName"
                                   value="${filterDTO.searchName}">
                        </div>
                        <!-- price -->
                        <div class="range border-bottom py-2">
                            <h3 class="agileits-sear-head mb-3"><fmt:message key="price"/></h3>
                            <div class="w3l-range">
                                <div class="form-group row">
                                    <div class="col-sm-5">
                                        <input type="number" name="minPrice" class="form-control form-control-sm"
                                               id="minPrice" placeholder="Min" min="0" value="${filterDTO.minPrice}">
                                    </div>
                                    <div class="col-sm-5">
                                        <input type="number" name="maxPrice" class="form-control form-control-sm"
                                               id="maxPrice" placeholder="Max" min="1" value="${filterDTO.maxPrice}">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- //price -->
                        <!-- manufacturers -->
                        <div class="left-side border-bottom py-2">
                            <h3 class="agileits-sear-head mb-3"><fmt:message key="manufact"/></h3>
                            <ul>
                                <ul>
                                    <c:if test="${empty filterDTO}">
                                        <c:forEach items="${manufactureProducts}" var="manufacture">
                                            <li>
                                                <input type="checkbox" name="manufacture" value="${manufacture.id}"
                                                       class="checked">
                                                <span class="span">${manufacture.getValue()}</span>
                                            </li>
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${not empty filterDTO}">
                                        <c:forEach items="${manufactureProducts}" var="manufacture">
                                            <c:set var="checkForExist" value="false"/>
                                            <c:forEach items="${filterDTO.manufacture}" var="manufactureDTO">
                                                <li>
                                                    <c:if test="${manufacture.id == manufactureDTO}">
                                                        <input type="checkbox" name="manufacture"
                                                               value="${manufacture.id}" class="checked" checked>
                                                        <span class="span">${manufacture.value}</span>
                                                        <c:set var="checkForExist" value="true"/>
                                                    </c:if>
                                                </li>
                                            </c:forEach>
                                            <c:if test="${checkForExist==false}">
                                                <li>
                                                    <input type="checkbox" name="manufacture" value="${manufacture.id}"
                                                           class="checked">
                                                    <span class="span">${manufacture.value}</span>
                                                </li>
                                            </c:if>
                                        </c:forEach>
                                    </c:if>
                                </ul>
                        </div>
                        <!-- //manufacturers -->
                        <!-- categories -->
                        <div class="left-side border-bottom py-2">
                            <h3 class="agileits-sear-head mb-3"><fmt:message key="categor"/></h3>
                            <ul>
                                <c:if test="${empty filterDTO}">
                                    <c:forEach items="${categoryProducts}" var="category">
                                        <li>
                                            <input type="checkbox" name="category" value="${category.id}"
                                                   class="checked">
                                            <span class="span">${category.getValue()}</span>
                                        </li>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${not empty filterDTO}">
                                    <c:forEach items="${categoryProducts}" var="category">
                                        <c:set var="checkForExist" value="false"/>
                                        <c:forEach items="${filterDTO.category}" var="categoryDTO">
                                            <li>
                                                <c:if test="${category.id == categoryDTO}">
                                                    <input type="checkbox" name="category" value="${category.id}"
                                                           class="checked" checked>
                                                    <span class="span">${category.value}</span>
                                                    <c:set var="checkForExist" value="true"/>
                                                </c:if>
                                            </li>
                                        </c:forEach>
                                        <c:if test="${checkForExist==false}">
                                            <li>
                                                <input type="checkbox" name="category" value="${category.id}"
                                                       class="checked">
                                                <span class="span">${category.value}</span>
                                            </li>
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </ul>
                        </div>
                        <!-- //categories-->
                        <div class="row border-bottom py-2">
                            <div class="col-7 text-left">
                                <fmt:message key="sort_by"/>:
                                <select class="ml-4" name="sortBy" id="sortBy">
                                    <c:choose>
                                        <c:when test="${filterDTO.sortBy == ''}">
                                            <option value="" selected></option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value=""></option>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${filterDTO.sortBy == 'model'}">
                                            <option value="model" selected>model</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="model">model</option>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${filterDTO.sortBy == 'cost'}">
                                            <option value="cost" selected>cost</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="cost">cost</option>
                                        </c:otherwise>
                                    </c:choose>
                                </select>

                                <c:choose>
                                    <c:when test="${filterDTO.sortWay == 'desc'}">
                                        <input name="sortWay" id="sortWay" value="desc" class="ml-4" type="radio"
                                               checked/> Desc
                                    </c:when>
                                    <c:otherwise>
                                        <input name="sortWay" value="desc" class="ml-4" type="radio"/> Desc
                                    </c:otherwise>
                                </c:choose>
                                <c:choose>
                                    <c:when test="${filterDTO.sortWay == 'asc'}">
                                        <input name="sortWay" id="sortWay" value="asc" class="ml-4" type="radio"
                                               checked/> asc
                                    </c:when>
                                    <c:otherwise>
                                        <input name="sortWay" value="asc" class="ml-4" type="radio"/> asc
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <div class="col-5 text-right">
                                Items on page:
                                <input type="number" placeholder="6" min="0" max="50" name="productsOnPage"
                                       id="productsOnPage" value="${filterDTO.productsOnPage}">
                            </div>
                        </div>
                        <div class="left-side text-center border-bottom py-3">
                            <button class="btn btn-success btn-md" type="submit"><fmt:message key="apply"/></button>
                            <input type="hidden" id="countOfPages" value="countOfPages">
                            <input type="hidden" id="startValue" value="startValue">
                            <input type="hidden" id="endValue" value="endValue">
                            <input type="hidden" id="currentPage" value="currentPage">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- //top products -->
<!-- pagination -->
<div class="row">
    <div class="col-lg-3 mt-lg-0 mt-4 p-lg-0"></div>
    <div class="col-lg-6 mt-lg-0 mt-4 p-lg-0 pagination pagination-lg justify-content-center">
        <c:if test="${startValue!=1}">
            <a class="page-link color-page enabled" data-parameter="${startValue-1}" href="#"><<<</a>
        </c:if>
        <c:if test="${currentPage!=1}">
            <a class="page-link color-page enabled" data-parameter="${currentPage-1}" href="#"><fmt:message
                    key="prev"/></a>
        </c:if>

        <c:forEach begin="${startValue}" end="${endValue}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <a style="background-color:#ccff66;" class="active page-link color-page" data-parameter="${i}"
                       href="">${i}</a>
                </c:when>
                <c:otherwise>
                    <a class="page-link color-page" data-parameter="${i}" href="">${i}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${currentPage!=countOfPages && fn:length(requestScope.products) != 0}">
            <a class="page-link color-page enabled" data-parameter="${currentPage+1}" href="#"><fmt:message
                    key="next"/></a>
        </c:if>

        <c:if test="${endValue!=countOfPages}">
            <a class="page-link color-page enabled" data-parameter="${endValue+1}" href="#">>>></a>
        </c:if>
    </div>
</div>
</div>
<!-- //pagination -->


<script src="js/jquery-2.2.3.min.js"></script>
<script src="js/jquery.magnific-popup.js"></script>
<script src="js/minicart.js"></script>
<script src="js/scroll.js"></script>
<script src="js/SmoothScroll.min.js"></script>
<script src="js/move-top.js"></script>
<script src="js/easing.js"></script>
<script src="js/bootstrap.js"></script>

<script src="js/myJS/paginationReferenceBuilder.js"></script>
<script src="js/myJS/addToCart.js"></script>
<script src="js/myJS/myJSForPages.js"></script>

</body>

</html>
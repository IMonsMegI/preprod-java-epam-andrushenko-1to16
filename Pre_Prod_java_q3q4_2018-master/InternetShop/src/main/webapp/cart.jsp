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

<body>

<%@ include file="header.jspf" %>

<!-- checkout page -->
<div class="privacy py-sm-5 py-4">
    <div class="container py-xl-4 py-lg-2">
        <!-- tittle heading -->
        <h3 class="tittle-w3l text-center mb-lg-5 mb-sm-4 mb-3">
            <span>C</span>art
        </h3>
        <!-- //tittle heading -->
        <div class="checkout-right">
            <div class="table-responsive">
                <table class="timetable_sub">
                    <thead>
                    <tr>
                        <th><fmt:message key="prod"/></th>
                        <th><fmt:message key="count"/></th>
                        <th><fmt:message key="prod_name"/></th>
                        <th><fmt:message key="price"/></th>
                        <th><fmt:message key="remove"/></th>
                    </tr>
                    </thead>
                    <tbody class="tableItems">
                    <c:forEach items="${cart}" var="cartItem">
                        <tr class="item${cartItem.key.id}">
                            <td class="invert-image">
                                <a href="">
                                    <img src="${pageContext.servletContext.contextPath}/productImages/${cartItem.key.image}"
                                         class="img-responsive">
                                </a>
                            </td>
                            <td class="invert">
                                <div class="quantity">
                                    <div class="quantity-select">
                                        <input type="button" value="-" class="entry value-minus minusCountItem"
                                               data-parameter="${cartItem.key.id}" style="color:black;"/>
                                        <div class="entry value" style="color:black;">${cartItem.value}</div>
                                        <input type="button" value="+" class="entry value-plus active plusCountItem"
                                               data-parameter="${cartItem.key.id}" style="color:black;"/>
                                    </div>
                                </div>
                            </td>
                            <td class="invert">${cartItem.key.model}</td>
                            <td class="invert">${cartItem.key.cost}</td>
                            <td class="invert">
                                <div class="rem">
                                    <input type="button" value="Delete" class="button deleteFromCart"
                                           data-parameter="${cartItem.key.id}"/>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <span><fmt:message key="sum_cost"/> : </span>
                <div class="summaryCost">${summaryCostOfProductsInCart}</div>
                <center><input type="button" value=
                <fmt:message key="clear"/> class="button clearCart" />
                </center>
            </div>
        </div>
        <div class="checkout-left">
            <div class="address_form_agile mt-sm-5 mt-4">
                <h4 class="mb-sm-4 mb-3"><fmt:message key="add_new_details"/></h4>
                <form action="order" method="post" class="creditly-card-form agileinfo_form">
                    <div class="creditly-wrapper wthree, w3_agileits_wrapper">
                        <div class="information-wrapper">
                            <div class="first-row">
                                <div class="w3_agileits_card_number_grid_left form-group">
                                    <div class="controls">
                                        <input type="number" class="form-control" placeholder="Card Number"
                                               name="cardNumber" id="cardNumber" required="">
                                    </div>
                                </div>
                                <div class="controls form-group">
                                    <input type="text" class="form-control" placeholder="Town/City" name="city"
                                           id="city" required="">
                                </div>
                                <div class="controls form-group">
                                    <select class="option-w3ls" name="deliveryWay" id="deliveryWay">
                                        <option><fmt:message key="delivery"/></option>
                                        <option>Ukr Pochta</option>
                                        <option>Novaya Pochta</option>
                                        <option>DHS</option>
                                    </select>
                                </div>
                                <div class="controls form-group">
                                    <select class="option-w3ls" name="paymentWay" id="paymentWay">
                                        <option><fmt:message key="payment"/></option>
                                        <option>Visa</option>
                                        <option>PayPal</option>
                                        <option>MasterCard</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="checkout-right-basket">
                        <center><input class="btn btn-success btn-md" type="button" onclick="validate(this.form)" value=
                        <fmt:message key="make_payment"/>></center>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- //checkout page -->


<script src="js/jquery-2.2.3.min.js"></script>
<script src="js/jquery.magnific-popup.js"></script>
<script src="js/minicart.js"></script>
<script src="js/SmoothScroll.min.js"></script>
<script src="js/move-top.js"></script>
<script src="js/easing.js"></script>
<script src="js/bootstrap.js"></script>

<script src="js/myJS/orderFormValidation.js"></script>
<script src="js/myJS/minusCountItem.js"></script>
<script src="js/myJS/plusCountItem.js"></script>
<script src="js/myJS/deleteFromCart.js"></script>
<script src="js/myJS/clearCart.js"></script>
<script src="js/myJS/myJSForPages.js"></script>

</body>

</html>

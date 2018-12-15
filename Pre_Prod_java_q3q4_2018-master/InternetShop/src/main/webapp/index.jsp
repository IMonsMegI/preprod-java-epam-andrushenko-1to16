<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="taglib.jspf" %>

<html>
<head>
    <title>TV Shop</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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


<br><br><br><br><br><br>
<center>
    <!-- search -->
    <div class="col-10 agileits_search">
        <form class="form-inline" action="#" method="post">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" required>
            <button class="btn my-2 my-sm-0" type="submit"><fmt:message key="search"/></button>
        </form>
    </div>
    <!-- //search -->
</center>


<script src="js/jquery-2.2.3.min.js"></script>
<script src="js/jquery.magnific-popup.js"></script>
<script src="js/minicart.js"></script>
<script src="js/imagezoom.js"></script>

<!-- flexslider -->
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen"/>

<script src="js/jquery.flexslider.js"></script>
<script>
    // Can also be used with $(document).ready()
    $(window).load(function () {
        $('.flexslider').flexslider({
            animation: "slide",
            controlNav: "thumbnails"
        });
    });


</script>
<!-- //FlexSlider-->

<script src="js/jquery.flexslider.js"></script>
<script src="js/SmoothScroll.min.js"></script>
<script src="js/move-top.js"></script>
<script src="js/easing.js"></script>
<script src="js/bootstrap.js"></script>

<script src="js/myJS/langChangeLink.js"></script>
<script src="js/myJS/myJSForPages.js"></script>

</body>

</html>
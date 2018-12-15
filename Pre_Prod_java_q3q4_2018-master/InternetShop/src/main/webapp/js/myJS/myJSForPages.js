//Page single.html

//<!-- nav smooth scroll -->
$(document).ready(function () {
    $(".dropdown").hover(
        function () {
            $('.dropdown-menu', this).stop(true, true).slideDown("fast");
            $(this).toggleClass('open');
        },
        function () {
            $('.dropdown-menu', this).stop(true, true).slideUp("fast");
            $(this).toggleClass('open');
        }
    );
});
//<!-- //nav smooth scroll -->

//<!-- popup modal (for location)-->
$(document).ready(function () {
    $('.popup-with-zoom-anim').magnificPopup({
        type: 'inline',
        fixedContentPos: false,
        fixedBgPos: true,
        overflowY: 'auto',
        closeBtnInside: true,
        preloader: false,
        midClick: true,
        removalDelay: 300,
        mainClass: 'my-mfp-zoom-in'
    });

});
//<!-- //popup modal (for location)-->

//<!-- cart-js -->
paypals.minicarts.render(); //use only unique class names other than paypals.minicarts.Also Replace same class name in css and minicart.min.js

paypals.minicarts.cart.on('checkout', function (evt) {
    var items = this.items(),
        len = items.length,
        total = 0,
        i;

    // Count the number of each item in the cart
    for (i = 0; i < len; i++) {
        total += items[i].get('quantity');
    }

    if (total < 3) {
        alert('The minimum order quantity is 3. Please add more to your shopping cart before checking out');
        evt.preventDefault();
    }
});
//<!-- //cart-js -->

//<!-- start-smooth-scrolling -->
jQuery(document).ready(function ($) {
    $(".scroll").click(function (event) {
        event.preventDefault();

        $('html,body').animate({
            scrollTop: $(this.hash).offset().top
        }, 1000);
    });
});
//<!-- //end-smooth-scrolling -->

//<!-- smooth-scrolling-of-move-up -->
$(document).ready(function () {
    /*
    var defaults = {
        containerID: 'toTop', // fading element id
        containerHoverID: 'toTopHover', // fading element hover id
        scrollSpeed: 1200,
        easingType: 'linear'
    };
    */
    $().UItoTop({
        easingType: 'easeOutQuart'
    });

});
//<!-- //smooth-scrolling-of-move-up -->

//////////////////////////////////////////////////////////////////////////////////
//Page checkout.html
//<!-- quantity -->
$('.value-plus').on('click', function () {
    var divUpd = $(this).parent().find('.value'),
        newVal = parseInt(divUpd.text(), 10) + 1;
    divUpd.text(newVal);
});

$('.value-minus').on('click', function () {
    var divUpd = $(this).parent().find('.value'),
        newVal = parseInt(divUpd.text(), 10) - 1;
    if (newVal >= 1) divUpd.text(newVal);
});

$(document).ready(function (c) {
    $('.close1').on('click', function (c) {
        $('.rem1').fadeOut('slow', function (c) {
            $('.rem1').remove();
        });
    });
});

$(document).ready(function (c) {
    $('.close2').on('click', function (c) {
        $('.rem2').fadeOut('slow', function (c) {
            $('.rem2').remove();
        });
    });
});

$(document).ready(function (c) {
    $('.close3').on('click', function (c) {
        $('.rem3').fadeOut('slow', function (c) {
            $('.rem3').remove();
        });
    });
});
//<!-- //quantity -->

////////////////////////////////////////////////////////////////////////////




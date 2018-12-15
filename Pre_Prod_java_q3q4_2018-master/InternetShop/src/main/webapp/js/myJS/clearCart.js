$(document).ready(function () {
    $(".clearCart").click(function () {
        $.ajax({
            type: "POST",
            url: 'clearCart',
            success: function (response) {
                $('.tableItems').remove();
                var data = jQuery.parseJSON(JSON.stringify(response));
                $('.summaryCost').html(data["summaryCost"]);
                $('.summaryCount').html(data["summaryCount"]);
            },
            error: function (response) {
                alert('Error');
            }
        });
    });
});
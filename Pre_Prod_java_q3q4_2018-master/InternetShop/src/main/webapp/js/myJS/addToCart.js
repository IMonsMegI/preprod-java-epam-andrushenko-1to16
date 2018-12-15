$(document).ready(function () {
    $(".addToCart").click(function () {
        var id = this.getAttribute('data-parameter');
        $.ajax({
            type: "POST",
            data: {
                id: id
            },
            url: 'addToCart',
            success: function (response) {
                var data = jQuery.parseJSON(JSON.stringify(response));
                $('.summaryCount').html(data["summaryCount"]);
            },
            error: function (response) {
                alert('Error');
            }
        });
    });
});
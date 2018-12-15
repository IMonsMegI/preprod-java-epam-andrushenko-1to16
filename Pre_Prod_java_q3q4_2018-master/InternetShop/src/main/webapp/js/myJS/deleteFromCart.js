$(document).ready(function () {
    $(".deleteFromCart").click(function () {
        var id = this.getAttribute('data-parameter');
        $.ajax({
            type: "POST",
            data: {
                id: id
            },
            url: 'deleteFromCart',
            success: function (response) {
                $('.item' + id).remove();
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
$(document).ready(function () {
    $(".plusCountItem").click(function () {
        var id = this.getAttribute('data-parameter');
        $.ajax({
            type: "POST",
            data: {
                id: id
            },
            url: 'plusCountItem',
            success: function (response) {
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
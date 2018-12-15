$(document).ready(function () {
    $('.color-page').click(function (e) {
        var searchName = $('#searchName');
        var minPrice = $('#minPrice');
        var maxPrice = $('#maxPrice');
        var sortBy = $('#sortBy');
        var sortWay = $('#sortWay');
        var productsOnPage = $('#productsOnPage');
        var countOfPages = $('#countOfPages');
        var startValue = $('#startValue');
        var endValue = $('#endValue');

        var category = [];
        var manufacture = [];

        $('input:checkbox[name="manufacture"]:checked').each(function () {
            manufacture.push($(this).val());
        });

        $('input:checkbox[name="category"]:checked').each(function () {
            category.push($(this).val());
        });

        var result = 'productFilter?' +
            'searchName=' + searchName.val() +
            '&minPrice=' + minPrice.val() +
            '&maxPrice=' + maxPrice.val() +
            '&sortBy=' + sortBy.val() +
            '&sortWay=' + sortWay.val() +
            '&productsOnPage=' + productsOnPage.val() +
            "&countOfPages=" + countOfPages.val() +
            '&currentPage=' + this.getAttribute('data-parameter') +
            '&startValue=' + startValue.val() +
            '&endValue=' + endValue.val();

        for (i = 0; i < category.length; i++) {
            result += '&category=' + category[i];
        }

        for (i = 0; i < manufacture.length; i++) {
            result += '&manufacture=' + manufacture[i];
        }
        console.log(result);
        $(".color-page").attr("href", result);
    });
});
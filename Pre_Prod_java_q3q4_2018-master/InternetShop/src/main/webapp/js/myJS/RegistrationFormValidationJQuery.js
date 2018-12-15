function validate(form) {
    if (validateForm()) {
        form.submit();
    }
}

function validateForm() {
    $(".text-error").remove();


    // Check name
    var elem_name = $("#login");
    var v_name = false;
    if (elem_name.val().length < 4 || elem_name.val().length > 10) {
        var v_name = true;
        elem_name.after('<span class="text-error">Login length must be between 5 and 10 characters</span>');
    }
    $("#login").toggleClass('error', v_name);


    // Проверка e-mail
    var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    var elem_email = $("#email");
    var v_email = elem_email.val() ? false : true;

    if (v_email) {
        elem_email.after('<span class="text-error">Input email!</span>');
        v_email = true;
    } else if (!reg.test(elem_email.val())) {
        v_email = true;
        elem_email.after('<span class="text-error">Input correct e-mail</span>');
    }
    $("#email").toggleClass('error', v_email);


    // Проверка паролей
    var elem_password1 = $("#password1");
    var elem_password2 = $("#password2");

    var v_pass1 = elem_password1.val() ? false : true;
    var v_pass2 = elem_password2.val() ? false : true;

    if (elem_password1.val() != elem_password2.val()) {
        v_pass1 = true;
        v_pass2 = true;
        elem_password1.after('<span class="text-error">Passwords are not equals!</span>');
    } else if (elem_password1.val().length < 6) {
        v_pass1 = true;
        v_pass2 = true;
        elem_password1.after('<span class="text-error">Input correct password!</span>');
    }

    $("#password1").toggleClass('error', v_pass1);
    $("#password2").toggleClass('error', v_pass2);

    return (!v_name && !v_email && !v_pass1 && !v_pass2);
}
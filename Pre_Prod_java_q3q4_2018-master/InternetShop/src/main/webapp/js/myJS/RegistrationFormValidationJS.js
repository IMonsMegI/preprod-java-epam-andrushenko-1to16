var elems;
var check = [];

function showError(container, errorMessage) {
    container.className = 'error';
    var msgElem = document.createElement('span');
    msgElem.className = "error-message";
    msgElem.style.color = "red";
    msgElem.innerHTML = errorMessage;
    container.appendChild(msgElem);
}

function resetError(container) {
    container.className = '';
    if (container.lastChild.className == "error-message") {
        container.removeChild(container.lastChild);
    }
}

function checkLogin() {
    resetError(elems.login.parentNode);
    if (!elems.login.value) {
        showError(elems.login.parentNode, 'Input login!');
        return false;
    }
    return true;
}

function checkEmail() {
    resetError(elems.email.parentNode);
    var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    if (!elems.email.value) {
        showError(elems.email.parentNode, 'Input email!');
        return false;
    }
    if (reg.test(elems.email.value) == false) {
        showError(elems.email.parentNode, 'Input correct e-mail');
        return false;
    }
    return true;
}

function checkPassword() {
    resetError(elems.password1.parentNode);
    if (!elems.password1.value || elems.password1.value.length < 5 || elems.password1.value.length > 10) {
        showError(elems.password1.parentNode, 'Input correct password!');
        return false;
    } else if (elems.password1.value != elems.password2.value) {
        showError(elems.password1.parentNode, 'Passwords are not equals!');
        return false;
    }
    return true;
}

function validate(form) {
    elems = form.elements;
    check = [];
    check.push(checkLogin());
    check.push(checkEmail());
    check.push(checkPassword());
    var status = true;
    check.forEach(function (item) {
        console.log(item);
        if (item == false) {
            status = false;
        }
    });
    if (status) {
        form.submit();
    }
}
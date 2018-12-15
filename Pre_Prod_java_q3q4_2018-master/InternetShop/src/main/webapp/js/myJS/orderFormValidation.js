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

function checkCardNumber() {
    resetError(elems.cardNumber.parentNode);
    if (!elems.cardNumber.value) {
        showError(elems.cardNumber.parentNode, 'Input card number!');
        return false;
    }
    return true;
}

function checkCity() {
    resetError(elems.city.parentNode);
    if (!elems.city.value) {
        showError(elems.city.parentNode, 'Input city!');
        return false;
    }
    return true;
}

function checkDeliveryWay() {
    resetError(elems.deliveryWay.parentNode);
    if (elems.deliveryWay.value == "Select delivery way") {
        showError(elems.deliveryWay.parentNode, 'Input delivery way!');
        return false;
    }
    return true;
}

function checkPaymentWay() {
    resetError(elems.paymentWay.parentNode);
    if (elems.paymentWay.value == "Select payment way") {
        showError(elems.paymentWay.parentNode, 'Input payment way!');
        return false;
    }
    return true;
}

function validate(form) {
    elems = form.elements;
    check = [];
    check.push(checkCardNumber());
    check.push(checkCity());
    check.push(checkDeliveryWay());
    check.push(checkPaymentWay());
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
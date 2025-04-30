// JS script for client-side form validation
(function () {
    'use strict';
    window.addEventListener('load', function () {
        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        const forms = document.getElementsByClassName('needs-validation');
        // Loop over them and prevent submission
        const validation = Array.prototype.filter.call(forms, function (form) {
            form.addEventListener('submit', function (event) {
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
        });
    }, false);

})();

function callAjax(url, param, method, successCallback, errorCallback) {
    let argumentsLength = arguments.length;
    $.ajax({
        url: url,
        data: (argumentsLength < 2) ? {} : param,
        method: (argumentsLength < 3) ? "GET" : method,
        // contentType: "application/json; charset=utf-8",
        beforeSend: function (request) {
            request.setRequestHeader("client", "lms");
        },
        success: function (data) {
            (argumentsLength < 4) ? callAjaxDefaultSuccessCallback(data) : successCallback(data, param);
        },
        error: function (data) {
            (argumentsLength === 5) ? errorCallback(data) : callAjaxDefaultErrorCallback(data);
        },
    });
}

function callAjaxDefaultSuccessCallback(response) {
    console.log(response)
    if (response['error']) {
        alert(response.message);
    } else {
        alert(response.message);
    }
}

function callAjaxDefaultErrorCallback(response) {
    if (response['responseJSON']['error']) {
        alert(response['responseJSON']['error']);
    } else {
        alert(response['responseJSON']['message']);
    }
}
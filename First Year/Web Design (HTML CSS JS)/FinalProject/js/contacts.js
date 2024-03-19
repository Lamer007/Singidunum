function validateForm() {
    var email = document.getElementById("email")

    if (email.value == "") {
        alert("Please enter you email")
        email.focus();
        return false;
    } else {
        if (!checkEmail()) {
            alert("Please enter your email correcly")
            email.focus();
            return false;
        }
    }

    var text = document.getElementById("text")
    if (text.value == "") {
        alert("Please write your problem")
        text.focus();
        return false;
    }

    success()
}

function checkEmail() {
    var email = document.getElementById("email")
    var regExpName = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;

    if (!regExpName.test(email.value)) {
        return false;
    } else {
        return true;
    }
}

function success() {
    document.getElementById("not").innerHTML = "Your letter has been successfully sent!"
}
function functionOfHead() {
    document.getElementById("head").innerHTML = "My First JavaScript Function On Head";
}

function functionOfBodyBefore() {
    document.getElementById("bodyBefore").innerHTML = "My First JavaScript Function On BodyBefore";
}

function functionOfBodyAfter() {
    //var bodyString; //undefined
    var bodyString = "On BodyAfter";
    document.getElementById("bodyAfter").innerHTML = "My First JavaScript Function "+bodyString;
}

function functionOfBodyAfterCharge() {
    document.write("Nothing on body after script document write");
    document.write("<br>");
    document.write("Hello \
        World!");
}

function validate_required(field,alerttext) {
    with (field) {
        if (value==null||value=="") {
            alert(alerttext);
            return false;
        }
        else {
            return true;
        }
    }
}

function validate_form(thisForm) {
    with (thisForm) {
        if (validate_required(email,"Email must be filled out!")==false) {
            email.focus();
            return false;
        }
    }
}

function validate_email(field,alerttext) {
    with (field) {
        apos=value.indexOf("@");
        dotpos=value.lastIndexOf(".");
        if (apos<1||dotpos-apos<2) {
            alert(alerttext);
            return false;
        }
        else {
            return true;    
        }
    }
}
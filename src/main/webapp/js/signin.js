/**
 * Created by zhangruoqiu on 2017/4/30.
 */
function check(form) {
    if (document.forms.loginForm.email.value == "") {
        alert("Please input username");
        document.forms.loginForm.email.focus();
        return false;
    } else if (document.forms.loginForm.pwd.value == "") {
        alert("Please input passwprd");
        document.forms.loginForm.pwd.focus();
        return false;
    }
}
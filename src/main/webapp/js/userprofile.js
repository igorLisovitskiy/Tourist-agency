$(document).ready(function() {
    var info = document.getElementById('form-info');
    var pass = document.getElementById('form-password');
    window.onclick = function (event) {
        if (event.target == info) {
            info.style.display = "none";
        }
        if (event.target == pass) {
            pass.style.display = "none";
        }
    };
});
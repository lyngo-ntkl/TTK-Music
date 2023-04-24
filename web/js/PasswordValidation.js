/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function validatePasswordFormat(password, informId) {
    var passwordFormat = /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).{6,32}$/;
    if(password.value.match(passwordFormat)){
        document.getElementById(informId).innerHTML = "Correct password format.";
        document.getElementById(informId).style.color = "green";
    } else{
        document.getElementById(informId).innerHTML = "Password must have 6 - 32 characters in length with uppercase letters, lowercase letters, numbers and symbols.";
        document.getElementById(informId).style.color = "red";
    }
}

function checkPasswordMatching() {
    var password1 = document.getElementById('password1');
    var password2 = document.getElementById('password2');
    if(password1 != password2){
        document.getElementById('confirmInform').innerHTML = "Password doesn't match";
        document.getElementById('confirmInform').style.color = "red";
    } else {
        document.getElementById('confirmInform').innerHTML = "Password matches";
        document.getElementById('confirmInform').style.color = "green";
    }
}
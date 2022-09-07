function addition() {
    let a1 = document.getElementById('a1').value;
    let a2 = document.getElementById('a2').value;
    let add = parseFloat(a1) + parseFloat(a2);
    document.getElementById('result').innerHTML= add;
}
function subtraction() {
    let a1 = document.getElementById('a1').value;
    let a2 = document.getElementById('a2').value;
    let sub = parseFloat(a1) - parseFloat(a2);
    document.getElementById('result').innerHTML= sub;
}
function multiplication() {
    let a1 = document.getElementById('a1').value;
    let a2 = document.getElementById('a2').value;
    let mul = parseFloat(a1) * parseFloat(a2);
    document.getElementById('result').innerHTML= mul;
}
function division() {
    let a1 = document.getElementById('a1').value;
    let a2 = document.getElementById('a2').value;
    let div = parseFloat(a1) / parseFloat(a2);
    document.getElementById('result').innerHTML= div;
}

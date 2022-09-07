let x = 0;
let array = Array();
function addBt() {
    array[x]=document.getElementById('inputArray').value;
    alert(' elemnet ' + array[x] +' add ' + x);
    x++;
    document.getElementById('inputArray').value = '';
}
function displayBt() {
    let e = "<hr/>";
    for (let i = 0; i<array.length; i++){
        e += "element " + i + ' = ' + array[i] + '</br>';
    }
    document.getElementById('result').innerHTML = e;

}
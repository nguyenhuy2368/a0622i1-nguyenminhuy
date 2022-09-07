function tinhDiem() {
    let a = document.getElementById("vatLy").value;
    let b = document.getElementById("hoaHoc").value;
    let c = document.getElementById('sinhHoc').value;
    trungBinh =((parseInt(a)+parseInt(b)+parseInt(c))/3);
    tong = parseInt(a)+parseInt(b)+parseInt(c);
    document.getElementById('trungBinh').innerHTML = trungBinh;
    document.getElementById('tong').innerHTML = tong;
}

function bai1() {
  let a = parseInt(prompt('Nhập a:'));
  let b = parseInt(prompt('Nhập b:'));
  if (a % b === 0){
        alert('a chia het cho b') ;
  }
  else {
    alert('a ko chia het cho b');
  }
}
function bai2() {
  let a = parseInt(prompt('nhập tuổi:'));
  if (a >= 15){
    alert('Đủ tuổi học lớp 10')
  }
  else {
    alert('Chưa đủ tuổi học lớp 10')
  }
}
function bai3() {
  let a = parseInt(prompt('nhập số nguyên bất kì'));
  if (a > 0){
    alert('lớn hơn 0');
  }else {
    alert('bé hơn 0');
  }
}
function bai4() {
  let a = parseInt(prompt('a'));
  let b = parseInt(prompt('b'));
  let c = parseInt(prompt('c'));
  if (a > b && a > c){
    alert('max = a')
  }else if (b>a && b>c){
    alert('max = b');
  }else {
    alert('max =c');
  }
}
function bai5() {
  let a = parseInt(prompt('bài kiểm tra'));
  let b = parseInt(prompt('giữa kỳ'));
  let c = parseInt(prompt('cuối kỳ'));
  let tb =(a+b+c)/3;
  if (tb >= 8){
    alert('giỏi');
  }else if (8 > tb >= 5){
    alert('khá');
  }else {
    alert('yếu');
  }
}
function bai6() {
  let ds = parseInt(prompt('nhap doanh so ban hang'));
  let hh;
  if (ds >10000000){
    hh = ds * 0.15;
  }else if (10000000 >= ds >5000000){
    hh = ds * 0.1;
  }else {
    hh = ds * 0.05;
  }
  alert('hoa hong =' +hh);
}
function bai7() {
  let tg = parseInt(prompt('nhap so phut da goi'));
  let tien;
  if(tg>200){
    tien = tg*2000;
  }else if (200>=tg>100){
    tien = tg*3500;
  }else {
    tien = tg*5000;
  }
  alert('so tien cuoc dien thoai: ' + tien);
}

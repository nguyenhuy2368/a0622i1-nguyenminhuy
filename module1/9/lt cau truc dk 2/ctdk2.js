function bai1() {
    let c = parseInt(prompt('nhap gia tri do c:'));
    let f = c * 9 / 5 +32;
    alert('gia tri do f='+ f);
}
function bai2() {
    let m = parseInt(prompt('nhap do dai gia tri met'));
    let ft = m * 3.2808;
    alert('gia tri chuyen sang feet =' + ft);
}
function bai3() {
    let a = parseInt(prompt('nhập độ dài cạnh hình vuông'));
    let s = a*a;
    alert('dien tich hinh vuong:'+s);
}
function bai4() {
    let a = parseInt(prompt("Nhập cạnh a: "));
    let b = parseInt(prompt("Nhập cạnh b: "));
    let s = a*b;
    alert("Diện tích hình chữ nhật là: "+ s);
}
function bai5() {
    let a = parseInt(prompt("Nhập cạnh a: "));
    let b = parseInt(prompt("Nhập cạnh b: "));
    let s = a*b/2;
    alert("Diện tích hình tam giác vuông là: "+ s);
}
function bai6() {
    let a = parseInt(prompt("Nhập số a: "));
    let b = parseInt(prompt("Nhập số b: "));
    if (a === 0){
        if (b === 0){
            alert("Phương trình có vô số nguyên");
        }
        else {
            alert("Phương trình vô nghiệm");
        }
    }
    else {
        alert("Nghiệm của phương trình này là x = " + -b/a);
    }
}
function bai7() {
    let a = parseInt(prompt("Nhập số a: "));
    let b = parseInt(prompt("Nhập số b: "));
    let c = parseInt(prompt("Nhập số c: "));
    if (a === 0){
        alert("Đây không phải phương trình bậc 2");
    }
    else{
        let delta = b*b - 4*a*c;
        if(delta < 0){
            alert("Phương trình vô nghiệm!");
        }
        else if(delta === 0){
            alert("Phương trình có nghiệm kép x = : " + -b/2*a);
        }
        else {
            let x1 = (-b + Math.sqrt(delta))/(2*a);
            let x2 = (-b - Math.sqrt(delta))/(2*a);
            alert("Phương trình có 2 nghiệm phân biệt x1 = " + x1.toFixed(2) + ", x2 = " + x2.toFixed(2));
        }
    }
}
function bai8() {
    let age = parseInt(prompt("Nhập một số: "));
    if (0 < age < 120){
        alert(age + " là tuổi của một người!");
    }
    else {
        alert(age + " không phải là tuổi của một người!");
    }
}
function bai9() {
    let a = parseInt(prompt("Nhập cạnh a: "));
    let b = parseInt(prompt("Nhập cạnh b: "));
    let c = parseInt(prompt("Nhập cạnh c: "));
    if (a>0 && b>0 && c>0 && a+b>c && b+c>a && a+c>b){
        alert("Là 3 cạnh của một tam giác");
    }
    else {
        alert("Không phải là 3 cạnh của một tam giác");
    }
}
function bai10() {
    let dien1 = parseInt(prompt("Nhập đơn giá 50kWh đầu: "));
    let dien2 = parseInt(prompt("Nhập đơn giá từ 50 - 100kWh: "));
    let dien3 = parseInt(prompt("Nhập đơn giá 101 - 200kWh: "));
    let dien4 = parseInt(prompt("Nhập đơn giá 201 - 300kWh: "));
    let dien5 = parseInt(prompt("Nhập đơn giá 300+kWh: "));
    let tieuthu = parseInt(prompt("Nhập số kWh đã dùng: "));
    let tongtien;
    if (tieuthu <= 50){
        tongtien = dien1 * tieuthu;
    }
    else if (50 < tieuthu <= 100){
        tongtien = dien1*50 + dien2*(tieuthu - 500);
    }
    else if (100 < tieuthu <= 200){
        tongtien = dien1*50 + dien2*50 + dien3*(tieuthu - 100);
    }
    else if (200 < tieuthu < 300) {
        tongtien = dien1*50 + dien2*50 + dien3*100 + dien4*(tieuthu - 200);
    }
    else {
        tongtien = dien1*50 + dien2*50 + dien3*100 + dien4*100 + dien5*(tieuthu - 300);
    }
    alert("Tổng tiền điện: " + tongtien);
}
function bai11() {
    let thunhap = parseInt(prompt("Nhập thu nhập: "));
    let thue;
    if (thunhap <= 5000000){
        thue = thunhap*0.05;
    }
    else if (5000000 < thunhap <= 10000000){
        thue = thunhap*0.1 - 250000;
    }
    else if (10000000 < thunhap <= 18000000){
        thue = thunhap*0.15 - 750000;
    }
    else if (18000000 < thunhap <= 32000000){
        thue = thunhap*0.2 - 1650000;
    }
    else if (32000000 < thunhap <= 52000000){
        thue = thunhap*0.25 - 3250000;
    }
    else if (52000000 < thunhap <= 80000000){
        thue = thunhap*0.3 - 5850000;
    }
    else {
        thue = thunhap*0.35 - 9850000;
    }
    alert("Thuế thu nhập: " + thue);
}

function bai12() {
    let v = parseInt(prompt("Nhập số tiền vốn ban đầu: "));
    let r = parseFloat(prompt("Nhập lãi suất: "));
    let t = parseInt(prompt("Nhập số tháng gửi tiền: "));
    let A = v * Math.pow((1+r), t);
    alert("Tổng vốn lẫn lãi thu được là: " + A.toFixed(2));
}
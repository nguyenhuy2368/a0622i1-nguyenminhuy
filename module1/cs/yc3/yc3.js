function bai1() {
    function arr(arrA, arrB) {
        for (let i = 0; i < arrA.length; i++) {
            let tong = 0;
            for (let j = 0; j <= i; j++) {
                tong += arrA[j];
            }
            arrB[i] = tong;
        }
    }

    let arrA = [1, 2, 3, 4, 5];
    let arrB = [];
    arr(arrA, arrB);
    alert(arrB);

}

function bai2() {
    function missingValue(value, a) {
        for (let i = 0; i < a.length; i++) {
            if (a[i] === value) {
                return false;
            }
        }
        return true;
    }

    function nhapPhanTu(arr) {
        let soPhanTu = Number(prompt("Nhập số phần tử: "));
        for (let i = 0; i < soPhanTu; i++) {
            arr.push(parseInt(prompt("Nhập phần tử thứ " + i + ":")));
        }
    }

    let a = [];
    let b = [];
    let c = [];
    console.log(nhapPhanTu(a), nhapPhanTu(b));
    for (let i = 0; i < b.length; i++) {
        if (missingValue(b[i], a)) {
            c.push(b[i]);
        }
    }
    alert(c);
}

function bai3() {

}

function bai4() {
    let a = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
    let b = ["Không", "Một", "Hai", "Ba", "Bốn", "Năm", "Sáu", "Bảy", "Tám", "Chín"];
    let nhapSo = prompt("Nhập một số bất kỳ lớn hơn 0: ");
    let c = nhapSo.split("");

    function hienThi(c) {
        let d = [];
        for (let i = 0; i < c.length; i++) {
            for (let j = 0; j < a.length; j++) {
                if (c[i] == a[j]) {
                    d[i] = b[j];
                }
            }
        }
        return d;
    }

    alert(hienThi(c).join(" "));
}

function bai5() {
    let menu = ['Cafe', 'Cam vắt', 'Nước ép cà rốt', 'Nước ép cà chua', 'Nước lọc',
        'Nước dừa'];
    let mang = ['1', '2', '3', '4', '5', '6', '7'];
    let giaBan = [20000, 30000, 30000, 30000, 15000, 35000,];

    function hienThi() {
        // Hiển thị MENU
        let arr = menu.map(function (item) {
            return `<li>${item}</li>`
        });
        document.getElementById("list").innerHTML = arr.join('');

        // Hiện thị nút chọn
        let tablString = '<table border="1">';
        for (let i = 0; i < mang.length; i++) {
            tablString += `<td onclick="goiMon(${i})" style="width: 100px;height: 50px;text-align: center;background-color: #4CAF50">${mang[i]}</td>`
        }
        tablString += '</table>';
        document.getElementById("bang").innerHTML = tablString;
    };
    hienThi();

    function goiMon(a) {
        if (a != 6) {
            document.getElementById("hienGia").innerHTML = `Giá của <b>${menu[a]}</b> là: ${giaBan[a].toLocaleString()} VNĐ.`;
            document.getElementById("thongTin").innerHTML = `Vui lòng nhập số lượng: <input id="soLuong" type="text"> <button type="button" onclick="tinhTien(${giaBan[a]})">Nhập</button>`;
        } else {
            document.getElementById("hienGia").innerText = 'Cảm ơn quý khách ^^';
            document.getElementById("thongTin").innerText = '';
        }
    }

    function tinhTien(giaTien) {
        let soLuong = +document.getElementById("soLuong").value;
        let tongTien = (giaTien * soLuong).toLocaleString();
        document.getElementById("giatien").innerHTML = `Số tiền bạn phải trả là: ${tongTien}`;
    }
}
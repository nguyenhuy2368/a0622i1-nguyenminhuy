function bai1() {
    let luong = parseFloat(prompt('Nhập lương nhân viên'));
    let thue;
    if (luong >= 15000000) {
        thue = luong * 0.2;
    } else if (15000000 >= luong >= 7000000) {
        thue = luong * 0.1;
    } else if (7000000 > luong) {
        thue = luong * 0.05;
    }
    let luongThuc = luong - thue;
    alert('thuế thu nhập:  ' + thue + ' lương thực nhập:  ' +luongThuc);
}
function bai2() {
    let a = prompt('nhập ký tự cần kiểm tra ');
    switch (a) {
        case 'o':
        case 'u':
        case 'i':
        case 'a':
        case 'e':
        case 'O':
        case 'U':
        case 'I':
        case 'A':
        case 'E':
           alert('kt nguyên âm');
           break;
        default:
            alert('ko nguyên âm');
            break;
    }

}
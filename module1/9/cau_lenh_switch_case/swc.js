function findday() {
    let mon = document.getElementById('month').value;
    let result;
    switch (mon) {
        case '1' :
            document.getElementById('result').innerHTML = 'Tháng 1 có 31 ngày';
            break;
        case '2':
            document.getElementById('result').innerHTML = 'Tháng 2 có 28 hoặc 29 ngày';
            break;
        case '3':
            document.getElementById('result').innerHTML = 'Tháng 3 có 31 ngày';
            break;
        case '4':
            document.getElementById('result').innerHTML = 'Tháng 4 có 30 ngày';
            break;
        case '5':
            document.getElementById('result').innerHTML = 'Tháng 5 có 30 ngày';
            break;
        case '6':
            document.getElementById('result').innerHTML = 'Tháng 6 có 31 ngày';
            break;
        case '7':
            document.getElementById('result').innerHTML = 'Tháng 7 có 31 ngày';
            break;
        case '8':
            document.getElementById('result').innerHTML = 'Tháng 8 có 31 ngày';
            break;
        case '9':
            document.getElementById('result').innerHTML = 'Tháng 9 có 30 ngày';
            break;
        case '10':
            document.getElementById('result').innerHTML = 'Tháng 10 có 31 ngày';
            break;
        case '11':
            document.getElementById('result').innerHTML = 'Tháng 11 có 30 ngày';
            break;
        case '12':
            document.getElementById('result').innerHTML = 'Tháng 12 có 31 ngày';
            break;
        default:
            document.getElementById('result').innerHTML = "Tháng bạn nhập sắp có vui lòng đợi tới chết";
    }

}
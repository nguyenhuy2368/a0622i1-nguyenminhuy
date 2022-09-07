function bai1() {
    let m = +prompt('nhap m');
    let n = +prompt('nhap n');
    let arr = new Array(m);
    for (let i = 0; i < arr.length; i++) {
        arr[i] = new Array(n);
    }
    for (let i = 0; i < arr.length; i++) {
        for (let j = 0; j < arr[i].length; j++) {
            arr[i][j] = +prompt("nhập vào phẩn tử thứ : " + i + "-" + j);
        }
    }
    console.log(arr);

    function tongChan(arr) {
        let sum = 0;
        for (let i = 0; i < arr.length; i++) {
            for (let j = 0; j < arr[i].length; j++) {
                if (arr[i][j] % 2 === 0) {
                    sum += arr[i][j];
                }
            }
        }
        return sum;
    }

    alert("tổng các số chẵn trong mảng 2 chiều : " + tongChan(arr));
}

function bai2() {
    let m = +prompt('nhap m');
    let n = +prompt('nhap n');
    let arr = new Array(m);
    for (let i = 0; i < arr.length; i++) {
        arr[i] = new Array(n);
    }
    for (let i = 0; i < arr.length; i++) {
        for (let j = 0; j < arr[i].length; j++) {
            arr[i][j] = +prompt("nhập vào phẩn tử thứ : " + i + "-" + j);
        }
    }
    console.log(arr);

    function isPrime(a) {
        if (a < 2) {
            return false;
        } else {
            for (let i = 2; i < a; i++) {
                if (a % i == 0) {
                    return false
                }
            }
        }
        return true;
    }

    function check(arr) {
        let arr1 = [];
        for (let i = 0; i < arr.length; i++) {
            for (let j = 0; j < arr[i].length; j++) {
                if (isPrime(arr[i][j])) {
                    arr1.push(arr[i][j]);
                }
            }
        }
        alert('sl cac snt trong mang: '
        arr1.length + ' cac so do la: ' + arr1.join()
    )
        ;
    }

    check(arr);
}

function bai3() {
    let m = +prompt('nhap m');
    let n = +prompt('nhap n');
    let arr = new Array(m);
    for (let i = 0; i < arr.length; i++) {
        arr[i] = new Array(n);
    }
    for (let i = 0; i < arr.length; i++) {
        for (let j = 0; j < arr[i].length; j++) {
            arr[i][j] = +prompt("nhập vào phẩn tử thứ : " + i + "-" + j);
        }
    }
    console.log(arr);

    function max(arr) {
        let max = [0][0];
        for (let i = 0; i < arr.length; i++) {
            for (let j = 0; j < arr[i].length; j++) {
                if (max > arr[i][j]) {
                    max = arr[i][j];
                }
            }
        }
        return max;
    }
    function min(arr) {
        let min = [0][0];
        for (let i = 0; i < arr.length; i++) {
            for (let j = 0; j < arr[i].length; j++) {
                if (min < arr[i][j]) {
                    min = arr[i][j];
                }
            }
        }
        return min;
    }
    max(arr);
    min(arr);
}
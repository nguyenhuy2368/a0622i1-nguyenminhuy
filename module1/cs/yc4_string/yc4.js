function bai1() {
    function deleteSpace(str) {
        let arr1 = str.split(" ");
        for (let i = 0; i < arr1.length; i++) {
            if (arr1[i] === "") {
                arr1.splice(i, 1);
            }
        }
        return arr1;
    }

    function capitalizeFirstLetter(mang) {
        return mang.map(function (element) {
            return element.replace(element.charAt(0), element.charAt(0).toUpperCase());
        });
    }

    function findLongestWord(mang) {
        let max = mang[0].length;
        let cnt = 0;
        for (let i = 1; i < mang.length; i++) {
            if (max < mang[i].length) {
                max = mang[i].length;
                cnt = i;
            }
        }
        return mang[cnt];
    }

    let str = prompt("Nhập chuỗi: ").toLowerCase();
    console.log(str);
    let mang = deleteSpace(str);
    console.log(mang);
    mang = capitalizeFirstLetter(mang);
    alert("Chuỗi đã thay đổi là: " + mang.join(" "));
    alert("Từ dài nhất là: " + findLongestWord(mang));
}
function bai2() {
    function differentSymbolsNaive(str) {
        let arr1 = str.split("");
        let arr2 = [];
        let flag = true;
        arr2[0] = arr1[0];
        for (let i = 0; i < arr1.length; i++) {
            for (let j = 0; j < arr2.length; j++) {
                if (arr1[i] === arr2[j]) {
                    flag = false;
                    break;
                } else {
                    flag = true;
                }
            }
            if (flag) {
                arr2.push(arr1[i]);
            }
        }
        return arr2.length;
    }

    let str = prompt("Nhập chuỗi: ");
    alert("Số kí tự khác nhau trong chuỗi là: " + differentSymbolsNaive(str));
}
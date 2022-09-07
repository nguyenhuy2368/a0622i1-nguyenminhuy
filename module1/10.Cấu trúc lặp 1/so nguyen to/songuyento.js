//let m = prompt("nhập vào số lượng số nguyên tố cần in ra")
document.getElementById('soNguyenTo').value
let count =0;
let n = 2;
while (count<m){
    let flag=true;
    for (let i = 2; i <n; i++) {
        if (n%i==0){
            flag=false;
            break;
        }
    }
    if (flag==true){
        document.write(n + "<br>");
        count++;
    }
    n++;
}
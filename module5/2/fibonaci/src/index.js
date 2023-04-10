"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
// happy coding 👻
function sumFibonacci(count) {
    var num1 = 0;
    var num2 = 1;
    var sum;
    var fi = [];
    for (var i = 0; i < count; i++) {
        fi.push(num1);
        sum = num1 + num2;
        num1 = num2;
        num2 = sum;
    }
    console.log("fi :" + fi);
    console.log("sum " + sum);
    return sum;
}
sumFibonacci(15);

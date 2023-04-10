import { log } from "console";

// happy coding 👻
function sumFibonacci(count: number) {
    let num1 = 0;
    let num2 = 1;
    let sum;
    let fi: Array<number> = [];
    for (let i = 0; i < count; i++) {
        fi.push(num1);
        sum = num1 + num2;
        num1 = num2;
        num2 = sum;
    }
    console.log("fi" + fi);
    console.log("sum" + sum);
    return sum;
}

sumFibonacci(15);
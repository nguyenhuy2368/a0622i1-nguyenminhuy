function bmiz() {
    let wei = document.getElementById('weight').value;
    let hei = document.getElementById('height').value;
    let bmi = parseFloat(wei) / (parseFloat(hei) * parseFloat(hei));
    if (bmi < 18)
        document.getElementById('result').innerHTML = 'Underweight';
    else if (bmi < 25)
        document.getElementById('result').innerHTML = 'Normal';
    else if (bmi < 30)
        document.getElementById('result').innerHTML = 'Overweight';
    else
        document.getElementById('result') = 'Obese';
pa
}
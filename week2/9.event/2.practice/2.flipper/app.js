// 버튼을 누르면 배경색과 글씨색이 바뀌게
const button = document.getElementById('button');
const container = document.getElementById('container');
const text = document.getElementById('text');
button.addEventListener('click', colorChange);

const number = Math.floor(Math.random() * 360);

function colorChange(){
    let R = number;
    let G = number;
    let B = number;


    container.style.backgroundColor = `rgb(${R}, ${G}, ${B})`;
    text.textContent = `rgb(${R}, ${G}, ${B})`;
}

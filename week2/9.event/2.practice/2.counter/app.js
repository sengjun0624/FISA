// 버튼을 누르면 배경색과 글씨색이 바뀌게
const button = document.getElementById('button');
const container = document.getElementById('container');
const text = document.getElementById('text');
console.dir(container);
console.log(button);

button.addEventListener('click', colorChange);
function colorChange(){
    let R = Math.floor(Math.random() * 360);
    let G = Math.floor(Math.random() * 360);
    let B = Math.floor(Math.random() * 360);

    container.style.backgroundColor = `rgb(${R}, ${G}, ${B})`;
    text.textContent = `rgb(${R}, ${G}, ${B})`;
}

// 버튼을 누르면 배경색과 글씨색이 바뀌게
const button = document.getElementById('button');
const container = document.getElementById('container');
const text = document.getElementById('text');
const colorChange = () => {

    const rgb = Array(3).fill().map(() => Math.floor(Math.random() * 360));
    container.style.backgroundColor = `rgb(${rgb.join(', ')})`;
    text.textContent = `rgb(${rgb.join(', ')})`;
};
button.addEventListener('click', colorChange);

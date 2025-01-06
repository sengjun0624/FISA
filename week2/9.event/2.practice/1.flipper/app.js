const p = document.getElementById('pTag');
const increase = document.getElementById('increase');
const decrease = document.getElementById('decrease');
const reset = document.getElementById('reset');
//증가 감소 리셋 이벤트 달면 되는거고 벨류가 0이면 검정 양수면 초록 음수면 빨강.

p.textContent = 0;


increase.addEventListener('click', up);
decrease.addEventListener('click', down);
reset.addEventListener('click', zero);

function down() {
    p.textContent--;
    let value = p.textContent;
    if (value > 0) p.style.color = 'green';
    else if (value == 0) p.style.color = 'black';
    else if (value < 0) p.style.color = 'red';
}

function zero() {
    p.textContent = 0;
    let value = p.textContent;
    p.style.color = 'black';
}

function up() {
    p.textContent++;
    let value = p.textContent;
    if (value > 0) p.style.color = 'green';
    else if (value == 0) p.style.color = 'black';
    else if (value < 0) p.style.color = 'red';
}

increase.addEventListener('click', up);
decrease.addEventListener('click', down);
reset.addEventListener('click', zero);

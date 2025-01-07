const p = document.getElementById('pTag');
const btns = document.querySelectorAll('button');

p.textContent = 0;

btns.forEach(btn => btn.addEventListener('click', () => {
    if (btn.id === 'increase') p.textContent++;
    else if (btn.id === 'decrease') p.textContent--;
    else p.textContent = 0;

    p.style.color = p.textContent > 0 ? 'green' : p.textContent < 0 ? 'red' : 'black';
}));

// darkmode 토글 버튼 가져오기
const checkbox = document.getElementById('checkbox');
// dark라는 접두사를 활성화 하기 위해 <html class='dark'> 와 같이 적용해야함
// default: white <html> dark: <html class='dark'>
const html = document.querySelector('html');

//checkbox clicked, dark mode
checkbox.addEventListener('click', () => {html.classList.toggle('dark');});
/*
아니면 checked 값에 따라 html.classList.
checkbox.checked? html.classList.add('dark') : html.classList.remove('dark');
*/


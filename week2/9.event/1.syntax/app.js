const button = document.querySelector('button');
console.dir(button);

button.onclick = () => console.log('이벤트 추가하는 두번째 방법');

button.addEventListener('click',()=>{
    const btnstyle= button.style;
    btnstyle.backgroundColor = 'transparent';
    btnstyle.border='1px dashed black';

})
/*
select 박스를 JS가 제어할 수 있어야함.
select 박스에 이벤트를 주어야함.
이벤트 - select 박스의 값이 변경되었다는 것을 감지할 이벤트
 */

const doc = document.getElementById('cookie');
console.log(doc);
const res = document.querySelector("#result");
doc.addEventListener('change', selectChanged);

/*
* addEventListener('이벤트 종류, 타입', 이벤트 발생 시 동작키실 코드 , 함수)
*/
function selectChanged(){
    console.log('call event');
    if (doc.value === "one") {
        res.textContent = "동생을 아끼는 마음이 아름답다";
    }else if (doc.value === "two") {
        res.textContent = "앗차차 실수로 동생 쿠키를 다 먹어버렸네 까비까비";
    }else if (doc.value === "random") {
        res.textContent = "안내면 진거 가뷔바위보! 하나빼기!";
    }else{
        res.textContent = "";
    }
}


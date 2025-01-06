/*
* 변수는 선언과 초기화라는 과정을 통해 작성할 수 있음
*
* 변수의 선언
* 변수 선언 시 사용하는 키워드 or 예약어
* var(사용하지말자), let,const
*
*/
console.log("var a: " + a);
var a = 5;
// 호이스팅?으로 한번 스캐닝한 변수를 출력하는건데 var는 선언이전에 출력을해도 끌어올려서 출력을한다.
/*
* 둘의 순서를 바꿔도 에러가 안뜬다, 즉 초기화를 하지않았음에도  출력이 나온다
* 변수 선언시에는 let을 사용한다.
*
*/
let userName = 'Yoo';
console.log("userName: " + userName);

userName = 'Kim';
console.log("Rename userName:" + userName);
// 일단 Const로 만들어두고 변경 되는 부분들만 let으로 바꾸는게 변경 가능성을 줄일 수 있다.
// let => 내 의도와 관계없이 변경되는값이라고 인식될수가있다.

const allUsers = 5;
console.log("allUsers: " + allUsers);
// allUsers=10; 상수는 변경불가능

// 상수는 대문자로 사용하기도 함
const PI = 3.14;
const BUTTON_PRIMARY_COLOR = 'red';
console.log("PI: " + PI);
console.log("BUTTON_PRIMARY_COLOR: " + PI);
// 변경이 필요한 부분만 Let으로 변경을 하는식에 방어적인 코드 작성법을 추천.

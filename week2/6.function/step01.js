/*
JS는 함수 정의 방식이 다양함
1. 함수 선언문 방식
 */

/**
 * JS Doc
 * 두 수를 받아서 덧셈 결과를 반환
 * @param {number} a
 * @param {number} b
 * @returns {number}덧셈 결과를 반환
 * @author 'sengjun0624
 */
function add(a, b) {
    console.log(a + b);
}
add(3, 5);
add(5, '3');

console.log("\n");
console.log("\n");

// ----------------------------------------------------------------------
console.log("두번째 함수 선언 방식 '함수 표현식 방식");
const multiply = function (a, b) {
    console.log(a * b);
}

console.log("multiply: " + multiply);
console.log('함수명 출력하면 시그니처가 출력됨');
multiply(2, 3);
// ----------------------------------------------------------------------

console.log("\n");
console.log("\n");

console.log(" ES6에 등장한 화살표 함수 문법");
const sub = (a, b) => console.log(a - b);
sub(1, 2);

console.log("\n");
console.log("\n");
// ----------------------------------------------------------------------

console.log("화살표 함수의 추가 문법 this binding 때문에 이것만 사용한다.");
console.log("구현부의 로직이 한 줄일 경우  {}, return 키워드 생략 가능");

console.log("\n");
console.log("\n");

const sub2 = (a, b) => a - b;
console.log('별도의 파라미터가 없으면 ()작성은 필수');
console.log('그렇지 않으면 문법 구조가 깨짐');

const hello = () => console.log('hello!!');
hello();

console.log("\n");
console.log("\n");
console.log('파라미터가 1개면 ? () 생략 가능');

const newVar = (x) => x * x;
const newVar2 = x => x * x;

console.log(newVar);
console.log(newVar2);
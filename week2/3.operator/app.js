// 산술 연산자
// console.log(5 + 5AC);
// console.log(5 - 10);
// console.log(5/2);
// console.log(5*4);
// console.log(10 % 3);
// console.log(2 ** 2);

// 증감(증가, 감소) 연산자
let age = 5;
//
// 후위 연산: 해당 라인의 코드를 먼저 수행 하고나서 연산을 수행하는 연산자
console.log(age++); // 5
console.log(age); // 6
console.log(age--);
console.log(age);

// 전위 연산: 연산을 먼저 수행하고 코드를 실행
let number = 3;
console.log(++number);

// 관계 연산자
const result = age > 10; // 조건식, 조건식의 결과값은 항상 true/false
console.log(result);
console.log(typeof result);

// 동등 연산자(서로 동등한지 비교)
console.log(1 == '1'); // true, 실행 과정에서 암묵적(implicit)으로 타입을 변환하여 비교
console.log(1 === '1'); // false, 순수하게 타입을 가지고 비교(Strict check)

console.log(1 !== '1');

// 논리 연산자
console.log(true && true); // true이고 true이면? true
console.log(5 > 3 && 2 === 2);

// 삼항 연산자(Ternary Operator)
let yourAge = 25;
let beverage = yourAge >= 20 ? '새로' : '스프라이트';
console.log(beverage);

console.log(yourAge >= 20 ? '새로' : '스프라이트');

// 할당 연산자, 변수에 값 대입 시 사용
yourAge = yourAge + 1; // 올해가 지났다, 한살 추가
yourAge += 1; // 축약표현, yourAge = yourAge + 1과 같음
// -=, /=, %=도 가능
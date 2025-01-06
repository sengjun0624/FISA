const a = 5;
console.log('const a: ' + a);
// data Type 을 왜 쓰는건가요
// 메모리를 효율적으로 쓰기위해? 데이터별로 메모리가 다르다, 가독성
console.log('type of a: ' + typeof (a));


/*
* JAVA와 JS의 가장 큰 차이 비동기 동기, 강타입
* JS에선 타입이 런타임에 결정된다. => 동적타입 언어,프로토타입 기반 언어다.
* JAVA는 타입이 컴파일타임에 결정된다. => 정적타입 언어다.
* JS,JAVA는 관련이 없다.
* 고민해볼 점 : 타입없이 메모리를 결정해줄순없을까?
*/
let userName = 'Yoo';
console.log("\n");
console.log('before typeof userName: ' + typeof (userName));
userName = 5;
console.log('after typeof userName: ' + typeof (userName));
console.log('=> So , JS can change type in compile time');
console.log("\n");


let myName = 'SeungJun' + ' Lee';
console.log("(comma)my name is ", myName);
console.log("(plus)my name is " + myName);
console.log(`(\`백틱문법을 사용 \${})my name is ${myName}`);
console.log("\n");
console.log(`\${}에 들어갈 수 있는 값`);
console.log('값 (value), 식 (expresseong) 할당 가능');
console.log('const b = 6 과 같은 문장은 할당 불가능');




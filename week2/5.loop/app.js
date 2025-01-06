for (let i = 0; i < 5; i++) {
    console.log(i);
}

// SUM
console.log("-----SUM------ (1,10)");
let sum = 0;
for (let i = 1; i <= 10; i++) {
    sum += i;
}
console.log(sum);

console.log('자바 스크립트에서 문자열은 배열처럼 동작하기도 함.');
const rainbow = 'rainbow';
console.log('문자열 index로 접근가능');
console.log('rainbow[0]: ' + rainbow[0]);

for (let i = 0; i < rainbow.length; i++) {
    console.log(rainbow[i]);
}
const foods = ['apple', 'orange-cookie', 'avocado', 'doctor-peppermint'];
let favorite = '내가 좋아하는 음식은.. ';

for (let i = 0; i < foods.length; i++) {
    if (i === foods.length - 1) {
        favorite += "그리고 " + foods[i];
        break;
    }
    favorite += foods[i] + ", ";

}
console.log(favorite + "\n");
console.log("\n");


const fruits = ['apple', 'banana', 'coconut'];

//우측의 함수를  좌측의 변수에 할당
console.log('함수도 변수에 넣을 수 있다. => 일급 객체');
//Call Back 함수
const fruitsPrinter = fruit => console.log(fruit);

// fruitsPrinter('apple');
// fruits.forEach(fruitsPrinter);

// 별도의 함수를 빼지않고 inline으로 작성 => 임시변수
fruits.forEach(fruit => console.log(fruit));
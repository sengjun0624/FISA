// 콜 백 (CallBack)
// 어떤 함수의 인자값으로 보내지는 함수로써, 무언가가 발생했을 때 실행되는 함수

function greeting(name) {
    console.log(`hello ${name}`);
}
// greeting('Yoo');

function processUserInput(name, callbackFunction) {
    callbackFunction(name);
}

console.log('함수를 인자로 받아서 호출할 수 있다.');
// processUserInput라는 함수로 전달 greeting이라는 함수
// => 콜백 함수
processUserInput('y', greeting);
console.log('\n');

/**
 * @Mission1
 * 쿠팡에서 사과를 기다리는 함수 waitCoupang(appleBox, callback)
 * 함수의 동작: '쿠팡에서 ${appleBox}가 도착했다'를 출력하는 함수
 * @Mission2
 *  bringItToNeighbor(별도의 파라미터 없음)
 *  함수의 동작: '옆집 아주머니에게 전달 완료'를 출력하는 함수
 */

function waitCoupang(appleBox, callback) {
    console.log(`쿠팡에서 ${appleBox}가 도착했다`);
    callback();
}
function bringItToNeighbor() {
    console.log('옆집 아주머니에게 전달 완료');
}
waitCoupang('사과박스', bringItToNeighbor);

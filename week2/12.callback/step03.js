/**
 * @Title 복잡해지는 비동기 처리 작업
 * function a() {
 *     setTimeout(() => console.log('a() called'), 1000);
 * }
 * function b() {
 *     setTimeout(() => console.log('b() called'), 500);
 * }
 * function c() {
 *     setTimeout(() => console.log('c() called'), 1200);
 * }
 * a();
 * console.log('a() is done');
 * b();
 * console.log('b() is done');
 * c();
 * console.log('c() is done');
 * Q. setTimeout()을 활용하여 지연 시간에 관계없이 a, b, c 순서로 동작하도록 보장하려면?
 *
 * a() called
 * a() is done
 * b() called
 * b() is done
 * c() called
 * c() is done
 */

function a() {
    setTimeout(() => console.log('a() called'), 1000);
}
function b() {
    setTimeout(() => console.log('b() called'), 500);
}
function c() {
    setTimeout(() => console.log('c() called'), 1200);
}
a();
console.log('a() is done');
b();
console.log('b() is done');
c();
console.log('c() is done');



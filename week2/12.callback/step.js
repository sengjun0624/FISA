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
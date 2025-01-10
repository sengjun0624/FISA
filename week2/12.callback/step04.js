/**
* @mission a,b,c  순서로 호출되고 완료되어야함.
 * 기존 코드는 a,b,c가 순서대로 호출되는 꼴이였음.
* */
function a(callback) {
    setTimeout(() => {
        console.log('a() called')
        callback();

    }, 1000);
}
function b(callback) {
    setTimeout(() => {
        console.log('b() called')
        callback();
    }, 500);
}
function c(callback) {
    setTimeout(() => {
        console.log('c() called')
        callback();
    }, 1200);
}

a(() => {
    console.log('a() is done');
    b(() => {
        console.log('b() is done');
        c(() => {
            console.log('c() is done');
        });
    });
});



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

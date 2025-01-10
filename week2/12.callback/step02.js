 function a(callback) {
    setTimeout(() => {
        console.log('a() called')

        callback('a() is done');
    }, 1000);
}

function printMessage(msg){
    console.log(msg);
}

a(printMessage);
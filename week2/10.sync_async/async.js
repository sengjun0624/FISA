function first() {
    console.log('first called');

}

function second() {
    console.log('second called');

}

/*
* 앞선 작업이 아직 완료되지 않아도
* 다음 작업을 곧바로 수행 가능 -> 비동기로 동작
* 쓰레드가 차단되지 않고, 다음 작업을 수행할 수 있음
* -> 브라우저에서 제공하는 web API를 활용했기 때뭉네
* */
setTimeout(first, 3000);
second();
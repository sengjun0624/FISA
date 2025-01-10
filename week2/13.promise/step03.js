/* Promise 객체는 크게 두 가지 값을 관리함
    1. 비동기 처리 수행 여부에 따른 상태값(pending, fulfilled, rejected)
    2. 비동기 처리 결과값(JSON 데이터)

    정리하면, promise는 비동기 처리 상태와 처리 결과를 관리하는 객체

    아래 코드 실행 후 콘솔에서
    PromiseState, PromiseResult 확인(fulfilled, Object)
*/

// executor라는 콜백에 비동기 처리 코드를 작성하면 됨
const executor = (resolve, reject) => { // executor의 인수로 resolve, reject 콜백 전달
    const xhr = new XMLHttpRequest();
    const url = 'https://jsonplaceholder.typicode.com/posts/1';
    xhr.open('GET', url);
    xhr.send();

    xhr.onload = () => {
        if (xhr.status === 200) {
            // 응답 성공 시 resolve()가 호출됨
            resolve(JSON.parse(xhr.response));
        } else {
            // 응답 실패 시, reject()가 호출됨
            console.error(xhr.status);
            reject(new Error('응답 실패'));
        }
    }
};

const myPromise = new Promise(executor);
console.dir(myPromise);

// then() - resolve되었을 경우 후속처리를 수행할 수 있는 함수
myPromise.then(result => {
    console.log(result);
    console.log(myPromise);
});
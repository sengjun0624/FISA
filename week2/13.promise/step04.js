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
/*const afterThan = myPromise.then(result => { //얘도 프로미스를 return 함.
    console.log(result);
    console.log(myPromise);
});*/

myPromise
    .then(result => {
        console.log(result);
        console.log(myPromise);})
    .catch(error => {
    console.error(`error : ${error}`);
})



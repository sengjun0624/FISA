const executor = (resolve,reject) => {  //resolve, reject 는 함수
    const xhr = new XMLHttpRequest();
    const url = 'https://jsonplaceholder.typicode.com/posts/1';
    xhr.open('GET', url);
    xhr.send();

    xhr.onload = () => {
        if (xhr.status === 200) {
            // 응답 성공 시 resolve()가 호츨딤.
            resolve(JSON.parse(xhr.response));
        } else {
            //응답 실패 시 reject()가 호출 됨
            console.error(xhr.status);
            reject(new Error('응답 실패'));
        }
    }
};

const myPromise = new Promise(executor);
console.log(myPromise);
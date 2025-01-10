/**
 * @summary
 * promise로 post를 get 받아서 작성자 id를 가지고 다시 get 요청 보내서 유저조회하기.
 */
/*
    Promise를 활용하여 콜백 패턴으로 발생할 수 있는 콜백 헬 개선
*/
const url = 'https://jsonplaceholder.typicode.com';

const promiseGet = url => {
    return new Promise((resolve, reject) => {
        const xhr = new XMLHttpRequest();
        xhr.open('GET', url);
        xhr.send();

        xhr.onload = () => {
            if (xhr.status === 200) {
                // 응답 성공
                resolve(JSON.parse(xhr.response));
            } else {
                // 에러 처리
                reject(new Error(xhr.status));
            }
        };
    });
};
/*
promiseGet(`${url}/posts/1`)
.then(result => {
    promiseGet(`${url}/users/${result.userId}`)
        .then(result => {console.log('--------',result);})
})
.catch(error => {console.error(error.message);});
*/
promiseGet(`${url}/posts/1`) // post id가 1번인 post 조회
    .then(post => promiseGet(`${url}/users/${post.userId}`))
    .then(user => console.log(user))
    .catch(error => console.error(error.message));

async function get() {
    const post = await promiseGet(`${url}/posts/1`);
    const user = await promiseGet(`${url}/users/${post.userId}`);
    console.log(user);
}

get();
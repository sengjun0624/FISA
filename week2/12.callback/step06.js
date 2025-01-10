let post;
const get = (url) => {
    console.log('get() started');
    const xhr = new XMLHttpRequest();
    xhr.open('GET', url);
    xhr.send();
    xhr.onload = () => {
        if (xhr.status === 200) {
            console.log(xhr.response);
            post = JSON.parse(xhr.response); // 상위 스코프에 값을 할당
            return JSON.parse(xhr.response); // 값 그 자체를 반환(?)
        } else {
            console.error(`${xhr.status} ${xhr.statusText}`);
        }
    }
    console.log('get() ended');
}
const url = 'https://jsonplaceholder.typicode.com/posts/1';
const getResult = get(url);
console.log(getResult);
console.log(post);


// 비동기 처리 결과를 외부에 반환하거나 상위 스코프 변수에 할당할 수 없다.
// 비동기 함수 get()의 처리결과
